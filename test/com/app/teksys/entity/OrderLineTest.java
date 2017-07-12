/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.teksys.entity;

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
import org.junit.rules.ExpectedException;

/**
 *
 * @author Anish Panthi
 */
public class OrderLineTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Map<String, Order> o;
    private Order c;

    public OrderLineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        o = new HashMap<>();

        c = new Order();

        c.add(new OrderLine(new Item("book", (float) 12.49), 1));
        c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
        c.add(new OrderLine(new Item("chocolate bar", (float) 0.845), 1));

        o.put("Order 1", c);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class OrderLine.
     */
    @Test
    public void testGetItem() throws Exception{
//        System.out.println("getItem");
        Item item = new Item("book", (float) 12.49);
        OrderLine instance = new OrderLine(item,1);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class OrderLine.
     */
    @Test
    public void testGetQuantity() throws Exception{
        System.out.println("getQuantity");
        Item item = new Item("book", (float) 12.49);
        OrderLine instance = new OrderLine(item,1);
        int expResult = 1;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    @Test
    public void testOrderLine() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Item is NULL");

        Item item = null;
        OrderLine orderLine = new OrderLine(item, 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOrder() throws Exception {

        OrderLine orderLine = null;
        Order order = new Order();
        order.add(orderLine);
    }

    @Test
    public void testOrder() {
        assertEquals(o.size(), 1);
        assertTrue(o.get("Order 1").get(0).getQuantity() > 0);
        assertEquals(o.get("Order 1").get(0).getItem().getDescription(), "book");
    }

}
