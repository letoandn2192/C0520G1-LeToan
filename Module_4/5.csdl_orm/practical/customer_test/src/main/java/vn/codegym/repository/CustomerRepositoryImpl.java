package vn.codegym.repository;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.codegym.model.Customer;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> customerList = null;
        try {
            session = DBConnect.getSessionFactory().openSession();
            customerList = session.createQuery("FROM Customer").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customerList;
    }

    @Override
    public Customer findOne(int id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = DBConnect.getEntityManager().createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = DBConnect.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(customer);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void edit(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = DBConnect.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String queryString = "UPDATE Customer SET name = :name, email = :email, address = :address WHERE id = :id";
            Query query = session.createQuery(queryString);
            query.setParameter("name", customer.getName());
            query.setParameter("email", customer.getEmail());
            query.setParameter("address", customer.getAddress());
            query.setParameter("id", customer.getId());
            query.executeUpdate();
//            session.update(customer);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        Customer customer = findOne(id);
        try {
            session = DBConnect.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(customer);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
