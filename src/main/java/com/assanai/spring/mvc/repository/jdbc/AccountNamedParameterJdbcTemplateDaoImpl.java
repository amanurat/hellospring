package com.assanai.spring.mvc.repository.jdbc;

/**
 * Created by amanurat on 12/27/2015 AD.
 */

import com.assanai.spring.mvc.domain.Account;
import com.assanai.spring.mvc.repository.jdbc.exception.InsertFailedException;
import com.assanai.spring.mvc.repository.jdbc.mapper.AccountRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("accountNamedParameterJdbcTemplateDaoImpl")
public class AccountNamedParameterJdbcTemplateDaoImpl implements AccountDao {

    private static Logger LOG = LoggerFactory.getLogger(AccountNamedParameterJdbcTemplateDaoImpl.class);

    public static final String FIND_ACCOUNT_BY_ID = "select id ,owner_name, balance, access_time, locked from account where id = :id";
    public static final String FIND_ACCOUNT_BY_OWNER_NAME = "select id ,owner_name, balance, access_time, locked from account where owner_name = :ownerName";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //==================================== Using JdbcTemplate for query then transform object by RowMapper ====================================
    public Account findOne(long id) {

        return namedParameterJdbcTemplate.queryForObject(FIND_ACCOUNT_BY_ID, Collections.singletonMap("id", id), new AccountRowMapper());
    }

    //==================================== Using NamedParameterJdbcTemplate for query then transform by RowMapper====================================

    public Account findOne(String name) {
        return namedParameterJdbcTemplate.queryForObject(FIND_ACCOUNT_BY_OWNER_NAME, Collections.singletonMap("ownerName", name), new AccountRowMapper());

    }

    //==================================== Using NamedParameterJdbcTemplate for query and return specific object and passing parameter as HashMap ====================================
    public String findOwnerNameById(Long id) {

        String sql = "select owner_name from account where id = :accountId";

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("accountId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }
    //==================================== Using NamedParameterJdbcTemplate for query and return specific object and passing parameter as SqlParameterSource ====================================
    public Long countAccountByBalance(int balance) {

        String sql = "select count(*) from account where balance = :balance";

        SqlParameterSource namedParameters = new MapSqlParameterSource("balance", balance);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Long.class);
    }


    //==================================== Using JdbcTemplate with PrepareStatement ====================================
    public List<Account> findAll(final boolean locked) {


        return namedParameterJdbcTemplate.query("select * from account where locked = :locked", Collections.singletonMap("locked", locked),new AccountRowMapper());

    }

    //==================================== Using namedParameterJdbcTemplate, Query in Clause and use MapSqlParameterSource to mapping parameters ====================================
    public List<Account> findAll(List<Long> accountIds) {

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource("accountIds", accountIds);

        return namedParameterJdbcTemplate.query("select * from account where id in (:accountIds)", sqlParameterSource, new AccountRowMapper());
    }



    //Using update() for execute query and binding parameters
    public void delete(long accountId) {

        String delQuery = "delete from account where id = :id";

        int count = namedParameterJdbcTemplate.update(delQuery, new MapSqlParameterSource("id", accountId));

        if(count!=0)
            System.out.println("User deleted successfully.");
        else
            System.out.println("Couldn't delete user with given id as it doesn't exist");
    }


    //Using update() for execute query to binding parameters and types
    /*public int create(Account account) {
        String insertQuery = "insert into account (OWNER_NAME, BALANCE, ACCESS_TIME , LOCKED) values (?, ?, ?, ?)";

        Object[] params = new Object[] {
                account.getOwnerName(),
                account.getBalance(),
                account.getAccessTimestamp(),
                account.getLocked() };

        int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.TIMESTAMP, Types.BOOLEAN};

        return jdbcTemplate.update(insertQuery, params, types);

    }*/


    public boolean createWithoutReturnId(final Account account) {
        System.out.println("JDBCExample: account (owner_name, balance, access_time, locked) is called");

        String sql = "INSERT INTO account (owner_name, balance, access_time, locked) VALUES (:owner_name,:balance,:access_time,:locked)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("owner_name", account.getOwnerName());
        params.addValue("balance", account.getBalance());
        params.addValue("access_time", account.getAccessTimestamp());
        params.addValue(("locked"), account.getLocked());


        int count = namedParameterJdbcTemplate.update(sql, params);

        if (count != 1) throw new InsertFailedException("Cannot insert account");

        return true;
    }


    public void createBatch(List<Account> accounts) {

    }

    //Using update() for execute query to binding parameters and types
    public void create(final Account account) {

        LOG.info("create account ...");


        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO account (owner_name, balance, access_time, locked) VALUES (:owner_name,:balance,:access_time,:locked)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("owner_name", account.getOwnerName());
        params.addValue("balance", account.getBalance());
        params.addValue("access_time", account.getAccessTimestamp());
        params.addValue(("locked"), account.getLocked());


        int count = namedParameterJdbcTemplate.update(sql, params, keyHolder);

        account.setId(keyHolder.getKey().longValue());

        if (count != 1) throw new InsertFailedException("Cannot insert account");

        // try to force throw exception for testing transaction rollback
//        throw new InsertFailedException("force throw exception..");


    }

}
