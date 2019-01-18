package com.wangbo.test;

import com.wangbo.repository.DepartmentRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

public class SSPTest {
    private ApplicationContext ctx = null;
    private DepartmentRepository departmentRepository = null;

    private EntityManagerFactory entityManagerFactory;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        departmentRepository = ctx.getBean(DepartmentRepository.class);
        entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
    }

    @Test
    public void test3(){
        
    }

    @Test
    public void test2(){
        departmentRepository.findAll();
        departmentRepository.findAll();
    }

    @Test
    public void testDatasource() throws SQLException {

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
