package didenko.managment.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import didenko.managment.dao.Employee;


public class HibarnateUtil {
 private static SessionFactory sessionFactory;

 public static SessionFactory getSessionFactory() {
  if (sessionFactory == null) {

    Configuration configuration = new Configuration();

    Properties settings = new Properties();
    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/jsp_demo?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
    settings.put(Environment.USER, "hbstudent");
    settings.put(Environment.PASS, "hbstudent");
    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

    settings.put(Environment.SHOW_SQL, "true");

    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

    settings.put(Environment.HBM2DDL_AUTO, "create-drop");

    configuration.setProperties(settings);
    configuration.addAnnotatedClass(Employee.class);

    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).build();
    System.out.println("created");
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;

  }
  return sessionFactory;
 }
}