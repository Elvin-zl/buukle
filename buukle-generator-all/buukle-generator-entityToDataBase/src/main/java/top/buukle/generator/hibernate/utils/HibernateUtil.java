package top.buukle.generator.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static Configuration configuration = null;
	static SessionFactory sessionFactory = null;

	public static Session openSession() {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
}
