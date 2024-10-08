package com.example.tf;

public interface BankService {
    
    public Bank createBank(String name, String cuit, String address, String telephone) throws LibraryException;

    public Bank updateBank(Long id, String name, String cuit, String address, String telephone) throws LibraryException;

    public boolean deleteBank(Long id) throws LibraryException;

    public Optional<Bank> getById(Long id);

    public List<Bank> getListOfBanks();

    public Bank getBankCustomerCount();
}