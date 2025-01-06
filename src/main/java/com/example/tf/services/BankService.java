package com.example.tf.services;

import java.util.List;
import java.util.Optional;

import com.example.tf.model.Bank;

public interface BankService {
    
    public Bank createBank(String name, String cuit, String address, String telephone);

    public Bank updateBank(Long id, String name, String cuit, String address, String telephone);

    public boolean deleteBank(Long id);

    public Optional<Bank> getById(Long id);

    public List<Bank> getListOfBanks();

    public Bank getBankCustomerCount();
}