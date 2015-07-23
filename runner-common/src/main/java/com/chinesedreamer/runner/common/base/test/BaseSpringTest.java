package com.chinesedreamer.runner.common.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: 
 * @author Paris
 * @date Jul 23, 20153:55:29 PM
 * @version beta
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-config.xml")
public abstract class BaseSpringTest extends AbstractJUnit4SpringContextTests{
 
} 
