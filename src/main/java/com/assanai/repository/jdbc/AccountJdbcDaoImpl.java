package com.assanai.repository.jdbc;

/**
 * Created by amanurat on 12/27/2015 AD.
 */

import com.assanai.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountJdbcDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Account findOne(long accountId) {
        return jdbcTemplate.queryForObject("select id ,owner_name, balance, access_time, locked from account where id = ?", new RowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getLong("id"));
                account.setOwnerName(rs.getString("owner_name"));
                account.setBalance(rs.getDouble("balance"));
                account.setAccessTimestamp(rs.getTimestamp("access_time"));
                account.setLocked(rs.getBoolean("locked"));
                return account;
            }
        }, accountId);
    }

    //Using NamedParameterJdbcTemplate
    public String findOwnerNameById(Long id) {
        String sql = "select owner_name from account where id = :accountId";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("accountId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }
    //Using NamedParameterJdbcTemplate with SqlParameterSource
    public Long countAccountByBalance(int balance) {
        String sql = "select count(*) from account where balance = :balance";
        SqlParameterSource namedParameters = new MapSqlParameterSource("balance", balance);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Long.class);
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

    //Using update() for execute query to binding parameters and types
    public int create(Account account) {
        String insertQuery = "insert into account (OWNER_NAME, BALANCE, ACCESS_TIME , LOCKED) values (?, ?, ?, ?)";

        Object[] params = new Object[] {
                    account.getOwnerName(),
                    account.getBalance(),
                    account.getAccessTimestamp(),
                    account.getLocked() };

        int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.DATE, Types.BOOLEAN};

        return jdbcTemplate.update(insertQuery, params, types);

    }


}
