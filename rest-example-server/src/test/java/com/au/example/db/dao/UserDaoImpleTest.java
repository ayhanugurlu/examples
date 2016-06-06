//package com.au.example.db.dao;
//
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.UserTransaction;
//
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.Archive;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import com.au.example.db.model.User;
//
//@RunWith(Arquillian.class)
//public class UserDaoImpleTest {
//
//	@Deployment
//	public static Archive<?> createDeployment() {
//		WebArchive jar = ShrinkWrap.create(WebArchive.class, "ayhan.war").addClass(User.class).addClass(UserDao.class).addClass(UserDaoImpl.class)
//				.addAsWebInfResource("test-persistence.xml", "classes/META-INF/persistence.xml")
//				.addAsWebInfResource(EmptyAsset.INSTANCE, "META-INF/beans.xml");
//		System.out.println(jar.toString(true));
//		return jar;
//	}
//
//	@EJB
//	UserDao userDao;
//
//	@Before
//	public void preparePersistenceTest() throws Exception {
//		clearData();
//		insertData();
//
//	}
//
//	@Inject
//	UserTransaction utx;
//
//	@PersistenceContext
//	EntityManager em;
//
//	private void clearData() throws Exception {
//
//		utx.begin();
//		em.joinTransaction();
//		System.out.println("Dumping old records...");
//		em.createQuery("delete from User").executeUpdate();
//		utx.commit();
//
//	}
//
//	private void insertData() throws Exception {
//		User user1 = new User();
//		user1.setName("ayhan");
//		user1.setSurname("ugurlu");
//		user1.setMotherName("aaa");
//		user1.setPassword("213");
//		user1.setChangetype("F");
//		userDao.create(user1);
//
//		User user2 = new User();
//		user2.setName("orhan");
//		user2.setSurname("ugurlu");
//		user2.setMotherName("aaa");
//		user2.setPassword("213");
//		user2.setChangetype("F");
//
//		userDao.create(user2);
//	}
//
//	@Test
//	public void getAllUser() {
//		System.out.println("get all user");
//		List<User> uList = userDao.getAll();
//		for (User u : uList) {
//			System.out.println(u);
//		}
//
//		Assert.assertEquals(uList.size(), 2);
//
//	}
//
//	@Test
//	public void findUser() {
//		System.out.println("find user");
//		User u = userDao.findById(1l);
//		Assert.assertEquals(u.getName(), "ayhan");
//	}
//
//}
