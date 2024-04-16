package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            //save!!!!!!!!
//            session = factory.getCurrentSession();
//            Department dep = new Department("IT",300,600);
//            Employee emp1 = new Employee("Ivan","Ivanov",500);
//            Employee emp2 = new Employee("Vasya","Ivanov",400);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//get!!!!!!
            session=factory.getCurrentSession();
            session.beginTransaction();

            Employee employee=session.get(Employee.class,1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();
            System.out.println("Done!");


        }
        finally {
            factory.close();
        }


    }
}