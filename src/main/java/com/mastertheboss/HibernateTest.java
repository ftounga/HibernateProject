package com.mastertheboss;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.h2.tools.Server;
import org.hibernate.Query;
import org.hibernate.Session;

import com.masterheboss.service.EmployeeService;
import com.mastertheboss.entity.Department;
import com.mastertheboss.entity.Employee;
import com.mastertheboss.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class HibernateTest {
  public static void main(String[] args) {

    Session session = HibernateUtil.getSessionFactory().openSession();
//    try {
//		Server webServer = Server.createWebServer("-web,-webAllowOthers,true,-webPort,8082").start();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
    EmployeeService service = new EmployeeService();
    session.beginTransaction();
    Department department = new Department("java");
    session.save(department);

   session.save(new Employee("Jakab Gipsz", department));
     session.save(new Employee("Captain Nemo", department));

    session.getTransaction().commit();

    Query q = session.createQuery("From Employee ");
    
    List<Employee> list= service.findAllEmployee();
  //  List<Employee> resultList = q.list();
    System.out.println("num of employess:" + list.size());
    for (Employee next : list) {
      System.out.println("next employee: " + next);
    }

  }
}
