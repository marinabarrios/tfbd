package com.example.tf.model;

import com.example.tf.TfException;
import com.example.tf.model.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BankRepositoryImpl implements BankRepository{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Bank bank) throws TfException{
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            session.save(bank);
        } catch (Exception e ){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public void update(Bank bank) throws TfException {
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            session.save(bank);
        } catch (Exception e ){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Bank bank) throws TfException {
        Session session = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            session.delete(bank);
            return true;
        } catch (Exception e ){
            throw new LibraryException(e.getMessage());
        }
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return this.sessionFactory.getCurrentSession().createQuery(
                "from Bank where id = :id"
        ).setParameter("id", id).uniqueResultOptional();
    }

    @Override
    public List<Bank> findAll() {
        return this.sessionFactory.getCurrentSession().createQuery(
                "from Bank"
        ).list();
    }

    //listado del número de clientes de cada banco.
    @Override
    public List<Object[]> findBankCustomerCount() {
        return this.sessionFactory.getCurrentSession().createQuery(
                "select b.name, count(c) " +
                "from Bank b left join b.customers c " +
                "group by b.id"
        ).list();
    }
}