package com.example.tf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    Long id;

    @Column(length = 50)
    String cardNumber;

    //muchas tarjetas pueden pertenecer a un banco
    @ManyToOne
    @JoinColumn(name = "bank_id") // clave foránea de Bank
    private Bank bank;

    // Muchas tarjetas pueden pertenecer a un solo cliente
    @ManyToOne
    @JoinColumn(name = "customer_id")  // clave foránea en la tabla Card
    private Customer customer;

    //Constructores
    public Card() {
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    //Getters y Setters para los atributos individuales
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
