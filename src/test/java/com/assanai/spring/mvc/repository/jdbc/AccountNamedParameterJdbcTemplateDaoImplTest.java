package com.assanai.spring.mvc.repository.jdbc;

import com.assanai.spring.mvc.domain.Account;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
public class AccountNamedParameterJdbcTemplateDaoImplTest {


    @Autowired
    @Qualifier(value = "accountNamedParameterJdbcTemplateDaoImpl")
    private AccountDao accountDao;

    @Test
    public void findOneByIdShouldFounded() throws Exception {

        Account account = accountDao.findOne(1);

        assertThat(account, not(nullValue()));
        assertThat(account.getOwnerName(), is(equalTo("John")));

    }

    @Test
    public void findOneByNameShouldFounded() throws Exception {

        Account account = accountDao.findOne("John");

        assertThat(account, not(nullValue()));
        assertThat(account.getOwnerName(), is(equalTo("John")));

    }


    @Test
    public void findAccountIsLocked() throws Exception {

        List<Account> accounts = accountDao.findAll(false);

        assertThat(accounts, not(nullValue()));
        assertThat(accounts.get(0).getOwnerName(), is(CoreMatchers.equalTo("John")));

    }

    @Test
    public void findByMultipleAccountIdShouldFounded() throws Exception {

        List<Account> account = accountDao.findAll(Arrays.asList(1l, 2l));

        assertThat(account, not(nullValue()));
        assertThat(account.size(), is(equalTo(2)) );
        assertThat(account.get(0).getOwnerName(), is(equalTo("John")));
        assertThat(account.get(1).getOwnerName(), is(equalTo("Sara")));

    }

    @Test
    public void findOwnerNameByIdShouldFounded() throws Exception {
        String names = accountDao.findOwnerNameById(1l);

        assertThat(names, is(notNullValue()));
        assertThat(names, is(CoreMatchers.equalTo("John")));

    }

    @Test
    public void countAccountByBalanceShouldFounded() throws Exception {

        Long count = accountDao.countAccountByBalance(1000);
        System.out.println(count);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteAccountShouldThrowEmptyResultWhenDataAlreadyDeleted() throws Exception {

        //perform delete account
        accountDao.delete(1l);

        //perform findAll account already deleted
        accountDao.findOne(1l);
        fail("fail because data do not delete");
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteAccount2ShouldThrowEmptyResultWhenDataAlreadyDeleted() throws Exception {

        //perform delete account
        accountDao.delete(1l);

        //perform findAll account already deleted
        accountDao.findOne(1l);
        fail("fail because data do not delete");
    }


    @Test
    @Rollback(value = false)
    public void createAccountShouldCreated() throws Exception {

        Account account = new Account();
        account.setOwnerName("Tony2");
        account.setBalance(20.0);
        account.setAccessTimestamp(new Timestamp(new Date().getTime()));
        account.setLocked(false);

        accountDao.create(account);
        assertThat(account.getId(), is(notNullValue()));


        Account created = accountDao.findOne("Tony2");
        assertThat(created, notNullValue());

    }


    @Test
    @Rollback(value = false)
    public void createAccountWithoutReturnIdShouldCreatedAndDoNotReturnId() throws Exception {

        Account account = new Account();
        account.setOwnerName("damian");
        account.setBalance(20.0);
        account.setAccessTimestamp(new Timestamp(new Date().getTime()));
        account.setLocked(false);

        accountDao.createWithoutReturnId(account);
        assertThat(account.getId(), is(nullValue()));

        Account created = accountDao.findOne("damian");
        assertThat(created, notNullValue());
        assertThat(created.getId(), is(notNullValue()));

    }

}