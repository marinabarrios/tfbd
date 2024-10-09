package com.example.tf.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank")
public class Bank {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank")
    Long id;

    @Column(length = 100)
    String name;

    @Column(length = 20)
    String cuit;

    @Column(length = 100)
    String address;

    @Column(length = 50)
    String telephone;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Card> cards = new ArrayList<>();

    //Constructores
    public Bank() {
    }

    public Bank(String name, String cuit, String address, String telephone) {
        this.name = name;
        this.cuit = cuit;
        this.address = address;
        this.telephone = telephone;
    }

    public Bank(Long id, String name, String cuit, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.cuit = cuit;
        this.address = address;
        this.telephone = telephone;
    }

    //Getters y Setters para los atributos individuales
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    //Getters y Setters para las relaciones (customers y cards)
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    //Métodos auxiliares para agregar o eliminar un Customer o Card
    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setBank(this); // Establece la relación inversa
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.setBank(null); // Rompe la relación inversa
    }

    public void addCard(Card card) {
        cards.add(card);
        card.setBank(this);
    }

    public void removeCard(Card card) {
        cards.remove(card);
        card.setBank(null);
    }
}