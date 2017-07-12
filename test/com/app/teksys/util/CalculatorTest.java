/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.teksys.util;

import com.app.teksys.entity.Item;
import com.app.teksys.entity.OrderLine;
import com.app.teksys.service.Order;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 *
 * @author Anish Panthi
 */
public class CalculatorTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private Calculator classUnderTest;
    private Map<String, Order> o;

    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Calculator();
        o = new HashMap<>();

        Order c = new Order();

        c.add(new OrderLine(new Item("book", (float) 12.49), 1));
        c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
        c.add(new OrderLine(new Item("chocolate bar", (float) 0.845), 1));

        o.put("Order 1", c);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class Calculator.
     */
    @Test
    public void testCalculateWhenGivenMapShouldDisplayOrderDetails() {
        System.out.println("calculate");
        classUnderTest.calculate(o);
        String logs = systemOutRule.getLog();
        assertTrue(logs.contains("1 book: 13.74"));
    }

}
