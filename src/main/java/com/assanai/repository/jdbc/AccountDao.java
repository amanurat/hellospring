package com.assanai.repository.jdbc;

import com.assanai.domain.Account;

import java.util.List;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
public interface AccountDao {
    Account findOne(long id);

    Account findOne(String name);

    String findOwnerNameById(Long id);

    List<Account> findAll(List<Long> accountIds);

    //Using NamedParameterJdbcTemplate with SqlParameterSource
    Long countAccountByBalance(int balance);

    void delete(long accountId);

    void create(Account account);

    List<Account> findAll(boolean locked);

    boolean createWithoutReturnId(Account account);

    void createBatch(List<Account> accounts);
}
