package com.example.tf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tf.model.Bank;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
   /*  Bank save(Bank bank);

    Bank update(Bank bank);

    public void delete(Bank bank);

    public Optional<Bank> findById(Long id);

    public List<Bank> findAll();*/

    //public List<Bank> findBankCustomerCount();
    Optional<Bank> findBankCustomerCount(Bank bank);
    
    Bank customSave(Bank bank);

    Bank customUpdate(Bank bank);

    void customDelete(Bank bank);

    Optional<Bank> customFindById(Long id);

    List<Bank> customFindAll();

    Optional<Long> customFindBankCustomerCount(Long bankId);
}   