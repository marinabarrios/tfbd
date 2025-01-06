package com.example.tf.repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tf.model.Bank;

@Repository
public class BankRepositoryImpl {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(BankRepositoryImpl.class);

    public Bank customSave(Bank bank){
        try {
            this.sessionFactory.getCurrentSession().save(bank);
            logger.debug("Banco guardado correctamente con ID: {}", bank.getId());
            return bank; // Devuelve el objeto guardado
        } catch (Exception e ){
            logger.error("Error al guardar el banco: {}", e.getMessage(), e);
            throw new RuntimeException("Error al guardar el banco:", e);
        }
    }

    public Bank customUpdate(Bank bank) {
        try {
            this.sessionFactory.getCurrentSession().update(bank);
            logger.debug("Banco actualizado correctamente con ID: {}", bank.getId());
            return bank; // Devuelve el objeto actualizado
        } catch (Exception e ){
            logger.error("Error al actualizar el banco: {}", e.getMessage(), e);
            throw new RuntimeException("Error al actualizar el banco:", e);
        }
    }

    public void customDelete(Bank bank) {
        try {
            this.sessionFactory.getCurrentSession().delete(bank);
            logger.debug("Banco eliminado correctamente con ID: {}", bank.getId());
           // return true;
        } catch (Exception e ){
            logger.error("Error al eliminar el banco: {}", e.getMessage(), e);
            throw new RuntimeException("Error al eliminar el banco:", e);
        }
    }

    public Optional<Bank> customFindById(Long id) {
        try {
            logger.info("Buscando banco con ID: {}", id);
            Optional<Bank> bank = this.sessionFactory.getCurrentSession().createQuery(
                    "from Bank where id = :id", Bank.class
            ).setParameter("id", id).uniqueResultOptional();
            logger.debug("Banco encontrado: {}", bank.orElse(null));
            return bank;
        } catch (Exception e) {
            logger.error("Error al buscar banco con ID {}: {}", id, e.getMessage(), e);
            return Optional.empty();
        }
    }

    public List<Bank> customFindAll() {
        try {
            logger.info("Buscando todos los bancos");
            List<Bank> banks = this.sessionFactory.getCurrentSession().createQuery(
                    "from Bank", Bank.class
            ).list();
            logger.debug("Cantidad de bancos encontrados: {}", banks.size());
            return banks;
        } catch (Exception e) {
            logger.error("Error al buscar todos los bancos: {}", e.getMessage(), e);
            return List.of();
        }
    }
    
    public Optional<Long> customFindBankCustomerCount(Long bankId) {
    try {
        String hql = "SELECT COUNT(c) FROM Customer c JOIN c.banks b WHERE b.id = :bankId";
        Long count = (Long) this.sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("bankId", bankId)
                .uniqueResult();
        logger.debug("Cantidad de clientes para el banco con ID {}: {}", bankId, count);
        return Optional.ofNullable(count);
    } catch (Exception e) {
        logger.error("Error al contar los clientes del banco con ID {}: {}", bankId, e.getMessage(), e);
        return Optional.empty();
    }
}
    //listado del número de clientes de cada banco.
   /* @Override
    public List<Object[]> findBankCustomerCount() {
        return this.sessionFactory.getCurrentSession().createQuery(
                "select b.name, count(c) " +
                "from Bank b left join b.customers c " +
                "group by b.name", Object[].class
        ).list();
    }
    public Optional<Long> findBankCustomerCount(Long bankId) {
        try {
            String queryString = "SELECT COUNT(c) FROM Customer c JOIN c.banks b WHERE b.id = :bankId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("bankId", bankId);

            Long count = (Long) query.getSingleResult();
            return Optional.ofNullable(count);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }*/
}