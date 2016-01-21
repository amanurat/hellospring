package com.assanai.repository.jdbc;

import com.assanai.domain.Account;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
public interface AccountDao {
    Account findOne(long id);

    void delete(long accountId);

    int insert(Account account);
}
