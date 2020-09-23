package vn.codegym.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }

    @Override
    public Customer findOne(Long id) {
        return (Customer) sessionFactory.getCurrentSession().get(
                Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().load(
                Customer.class, id);
        if (null != customer) {
            this.sessionFactory.getCurrentSession().delete(customer);
        }
    }

}
