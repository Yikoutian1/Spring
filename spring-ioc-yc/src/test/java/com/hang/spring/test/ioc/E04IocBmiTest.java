package com.hang.spring.test.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.hang.work.bmi.Container;
import com.hang.work.bmi.Person;

@RunWith(SpringRunner.class)
@ContextConfiguration("/bmi-beans.xml")
public class E04IocBmiTest {
	
	@Resource
	private Container container;
	
	@Test
	public void test() throws Exception{
		
		Person minP = (Person) container.getMin();
		Person maxP = (Person) container.getMax();
		
		assertTrue(container.getList().size() > 10);
		assertEquals("宋江", maxP.getName());
		assertEquals("燕青", minP.getName());
		
	}

}
