package com.example.tf.repositories;

import com.example.tf.TfException;
import com.example.tf.model.*;

import java.util.List;
import java.util.Optional;

public interface BankRepository {
    public void save(Bank bank) throws TfException;

    public void update(Bank bank) throws TfException;

    public boolean delete(Bank bank) throws TfException;

    public Optional<Bank> findById(Long id);

    public List<Bank> findAll();

    public List<Bank> findBankCustomerCount();
}