package com.assanai.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amanurat on 1/25/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/test-context-annotation.xml", "classpath:spring/test-mvc-dispatcher-servlet.xml"})
@WebAppConfiguration
@Transactional
abstract class BaseControllerTests {
}
