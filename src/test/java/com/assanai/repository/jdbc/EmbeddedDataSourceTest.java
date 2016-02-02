package com.assanai.repository.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by amanurat on 1/26/2016 AD.
 */
public class EmbeddedDataSourceTest {

    private DataSource dataSource;

    @Before
    public void setUp() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:sql/schema.sql")
                .addScript("classpath:sql/test-data.sql").build();
    }

    @Test
    public void testDataAccessLogic() throws SQLException {
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
        Assert.assertFalse(connection.isClosed());
        connection.close();
    }

    @After
    public void tearDown() {
        ((EmbeddedDatabase) dataSource).shutdown();
    }
}