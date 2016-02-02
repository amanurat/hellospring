package com.assanai.repository.jdbc;

/**
 * Created by amanurat on 12/27/2015 AD.
 */

import com.assanai.domain.Account;
import com.assanai.repository.jdbc.exception.InsertFailedException;
import com.assanai.repository.jdbc.mapper.AccountRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository("accountJdbcTemplateDaoImpl")
public class AccountJdbcTemplateDaoImpl implements AccountDao {

    private static Logger LOG = LoggerFactory.getLogger(AccountJdbcTemplateDaoImpl.class);

    public static final String FIND_ACCOUNT_BY_OWNER_NAME = "select id ,owner_name, balance, access_time, locked from account where owner_name = :ownerName";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    //==================================== Using JdbcTemplate for query then transform object by RowMapper ====================================
    public Account findOne(long id) {
        return jdbcTemplate.queryForObject("select id ,owner_name, balance, access_time, locked from account where id = ?", new AccountRowMapper(), id);
    }

    public Account findOne(String name) {
        return jdbcTemplate.queryForObject("select id ,owner_name, balance, access_time, locked from account where owner_name = ?", new AccountRowMapper(), name);
    }

    public String findOwnerNameById(Long id) {
        return jdbcTemplate.queryForObject("select owner_name from account where id =?", String.class, id);
    }

    //Recommend use where cause with namedParameterJdbcTemplate
    public List<Account> findAll(List<Long> accountIds) {

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource("accountIds", accountIds);

        return namedParameterJdbcTemplate.query("select * from account where id in (:accountIds)", sqlParameterSource, new AccountRowMapper());
    }

    public Long countAccountByBalance(int balance) {
        return null;
    }


    //==================================== Using JdbcTemplate with PrepareStatement ====================================
    public List<Account> findAll(final boolean locked) {

        return jdbcTemplate.query("select * from account where locked = ? ", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setBoolean(1, locked);
            }
        }, new AccountRowMapper());

    }

    public boolean createWithoutReturnId(final Account account) {
        System.out.println("JDBCExample: account (owner_name, balance, access_time, locked) is called");
        final String INSERT_SQL = "INSERT INTO account (owner_name, balance, access_time, locked) VALUES (?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setString(1, account.getOwnerName());
                preparedStatement.setDouble(2, account.getBalance());
                preparedStatement.setTimestamp(3, account.getAccessTimestamp());
                preparedStatement.setBoolean(4, account.getLocked());

                return preparedStatement;
            }
        });
        return true;
    }


    //Using update() for execute query and binding parameters
    public void delete(long accountId) {

        String delQuery = "delete from account where id = ?";

        int count = jdbcTemplate.update(delQuery, new Object[] { accountId });

        if(count!=0)
            System.out.println("User deleted successfully.");
        else
            System.out.println("Couldn't delete user with given id as it doesn't exist");
    }

    public boolean createAccount2(Account account) {
        return false;
    }

    public void update(Account account) {

        String delQuery = "update account set owner_name=?, balance=?, access_time=?, locked=? ";

        int count = jdbcTemplate.update(delQuery, new Object[] { account.getOwnerName(), account.getBalance(), account.getAccessTimestamp(), account.getLocked() });

        if(count!=0)
            System.out.println("User update successfully.");
        else
            System.out.println("Couldn't update user");
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

/*


    public boolean createAccount2(final Account account) {
        LOG.info("create account ...");
        PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
                "insert into account (owner_name, balance, access_time, locked) values (?,?,?,?)",
                new int[]{Types.VARCHAR, Types.DOUBLE, Types.TIMESTAMP, Types.BOOLEAN});

        int count = jdbcTemplate.update(psCreatorFactory.newPreparedStatementCreator(
                new Object[] {account.getOwnerName(), account.getBalance(), account.getAccessTimestamp(), account.getLocked()}));
        if (count != 1) throw new InsertFailedException("Cannot insert account");

        return true;
    }*/

    //Using update() for execute query to binding parameters and types
    public void create(final Account account) {

        LOG.info("create account ...");

        PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
                "INSERT INTO account (owner_name, balance, access_time, locked) VALUES (?,?,?,?)",
                new int[]{Types.VARCHAR, Types.DOUBLE, Types.TIMESTAMP, Types.BOOLEAN});

        KeyHolder keyHolder = new GeneratedKeyHolder();


        int count = jdbcTemplate.update(
                    psCreatorFactory.newPreparedStatementCreator(
                            new Object[]{account.getOwnerName(), account.getBalance(), account.getAccessTimestamp(), account.getLocked()}), keyHolder);

        account.setId(keyHolder.getKey().longValue());

        if (count != 1) throw new InsertFailedException("cannot insert account");


//        throw new InsertFailedException("force throw exception.."); // try to force throw exception for testing transaction rollback
    }


    public void createBatch(final List<Account> accounts){

        String sql = "insert into account (owner_name, balance, access_time, locked) values (?,?,?,?)";

        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Account employee = accounts.get(i);
                ps.setString(1, employee.getOwnerName());
                ps.setDouble(2, employee.getBalance());
                ps.setTimestamp(3, employee.getAccessTimestamp());
                ps.setBoolean(4, employee.getLocked());
            }

            public int getBatchSize() {
                return accounts.size();
            }
        });

        if (accounts.size() != batchUpdate.length) {
            throw new InsertFailedException("Create account batch do not success");
        }

    }


}
