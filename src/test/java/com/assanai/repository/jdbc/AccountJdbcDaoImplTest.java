package com.assanai.repository.jdbc;

import com.assanai.domain.Account;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context/application-context.xml")
@Transactional
public class AccountJdbcDaoImplTest {


    @Autowired
    private AccountDao accountDao;

    @Test
    public void findOneShouldFound() throws Exception {

        Account account = accountDao.findOne(1);

        assertThat(account, not(nullValue()));
        assertThat(account.getOwnerName(), is(equalTo("John")));

    }

    @Test
    public void findOwnerNameByIdShouldFound() throws Exception {
        String names = accountDao.findOwnerNameById(1l);

        assertThat(names, is(notNullValue()));
        assertThat(names, is(CoreMatchers.equalTo("John")));

    }

    @Test
    public void countAccountByBalanceShouldFound() throws Exception {

        Long count = accountDao.countAccountByBalance(1000);
        System.out.println(count);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteAccountShouldThrowEmptyResultWhenDataAlreadyDeleted() throws Exception {

        //perform delete account
        accountDao.delete(1l);

        //perform find account already deleted
        accountDao.findOne(1l);
        fail("fail because data do not delete");
    }
}