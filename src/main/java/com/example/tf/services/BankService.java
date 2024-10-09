package com.example.tf;

import com.example.tf.TfException;
import com.example.tf.model.Bank;

import java.util.List;
import java.util.Optional;

public interface BankService {
    
    public Bank createBank(String name, String cuit, String address, String telephone) throws TfException;

    public Bank updateBank(Long id, String name, String cuit, String address, String telephone) throws TfException;

    public boolean deleteBank(Long id) throws TfException;

    public Optional<Bank> getById(Long id);

    public List<Bank> getListOfBanks();

    public Bank getBankCustomerCount();
}