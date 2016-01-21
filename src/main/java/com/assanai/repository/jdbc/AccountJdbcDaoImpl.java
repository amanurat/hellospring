package com.assanai.repository.jdbc;

/**
 * Created by amanurat on 12/27/2015 AD.
 */

import com.assanai.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

@Repository
public class AccountJdbcDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public void delete(long accountId) {

        String delQuery = "delete from account where id = ?";

        int count = jdbcTemplate.update(delQuery, new Object[] { accountId });

        if(count!=0)
            System.out.println("User deleted successfully.");
        else
            System.out.println("Couldn't delete user with given id as it doesn't exist");
    }

    public int insert(Account account) {
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
