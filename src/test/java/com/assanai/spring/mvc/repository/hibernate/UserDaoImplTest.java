package com.assanai.spring.mvc.repository.hibernate;


/**
 * Created by amanurat on 12/27/2015 AD.
 */


// TODO: 2/1/2016 Try add more unit test
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:context/application-context.xml")
//@Transactional
public class UserDaoImplTest {


//    @Autowired
    private UserDao userDao;


//    @Test
    public void testFindOne() throws Exception {

        System.out.println(userDao.findOne(1l));

    }
}