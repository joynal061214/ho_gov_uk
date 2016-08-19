/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.home.junit;

import com.dao.controller.DaoClass;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joynal Abedin
 */
public class TestClass {

    public TestClass() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
       
    /*
    Testing 3 methods in 3 classes in one test. e.g. 1 DaoClass method, DbConnection class,
    and applicants class getFname method.
    */
    
    @Test  
    public void TestgetApplicantId() throws InstantiationException, IllegalAccessException, SQLException {
        String expectedResult = "John";
        Object obj = DaoClass.FindById(3).getFname();
        assertEquals(expectedResult, obj);

    }
}
