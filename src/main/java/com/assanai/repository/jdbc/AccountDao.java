package com.assanai.repository.jdbc;

import com.assanai.domain.Account;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
public interface AccountDao {
    Account findOne(long id);

    String findOwnerNameById(Long id);

    //Using NamedParameterJdbcTemplate with SqlParameterSource
    Long countAccountByBalance(int balance);

    void delete(long accountId);

    int create(Account account);
}
