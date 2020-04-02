package didenko.managment.model;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import didenko.managment.dao.Employee;
import didenko.managment.util.HibarnateUtil;


public class EmployeeDao {

    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibarnateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = HibarnateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Delete a user object
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Employee getEmployee(int id) {

        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibarnateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employee;
    }

	public List <Employee> getAllUser() {

        Transaction transaction = null;
        List <Employee> listOfEmployees = null;
        try (Session session = HibarnateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfEmployees = session.createQuery("from Employee").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfEmployees;
    }
}