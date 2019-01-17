package com.wangbo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SSPTest {
    private ApplicationContext ctx = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void testDatasource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
