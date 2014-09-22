package com.firststep.spring.test;

import com.firststep.spring.Hello;
import com.firststep.spring.Hello2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by daniel on 9/19/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
public class TestCase {

    @Autowired
    private final Hello hello = null;

    @Autowired
    private final Hello2 hello2 = null;

    @Test
    public void testHello() {
        Assert.assertNotNull(hello);
    }

    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello Hello", hello.sayHello());
    }

    @Test
    public void testHello2() {
        Assert.assertNotNull(hello2);
    }

    @Test
    public void testSayHello2() {
        Assert.assertEquals("Hello2 Hello2", hello2.sayHello());
    }
}
