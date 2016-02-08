package com.assanai.spring.mvc.repository.jdbc.mapper;

import com.assanai.spring.mvc.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by amanurat on 2/2/2016 AD.
 */
public final class AccountRowMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setOwnerName(rs.getString("owner_name"));
        account.setBalance(rs.getDouble("balance"));
        account.setAccessTimestamp(rs.getTimestamp("access_time"));
        account.setLocked(rs.getBoolean("locked"));
        return account;
    }
}
