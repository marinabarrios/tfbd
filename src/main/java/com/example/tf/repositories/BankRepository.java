package com.example.tf.repositories;

import com.dbd23.demo1.library.LibraryException;
import com.example.tf.model.*;

import java.util.List;
import java.util.Optional;

public interface BankRepository {
    public void save(Bank bank) throws LibraryException;

    public void update(Bank bank) throws LibraryException;

    public boolean delete(Bank bank) throws LibraryException;

    public Optional<Bank> findById(Long id);

    public List<Bank> findAll();

    public List<Bank> findBankCustomerCount();
}