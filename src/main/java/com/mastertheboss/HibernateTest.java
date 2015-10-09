package com.mastertheboss;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.format.DateTimeFormat;

import com.mastertheboss.entity.Department;
import com.mastertheboss.entity.Employee;
import com.mastertheboss.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class HibernateTest {
  public static void main(String[] args) {

    DateTimeFormat d = null;
    Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();

    Department department = new Department("java");
    session.save(department);

    session.save(new Employee("Jakab Gipsz", department));
    session.save(new Employee("Captain Nemo", department));

    session.getTransaction().commit();

    Query q = session.createQuery("From Employee ");

    List<Employee> resultList = q.list();
    System.out.println("num of employess:" + resultList.size());
    for (Employee next : resultList) {
      System.out.println("next employee: " + next);
    }

  }
}
