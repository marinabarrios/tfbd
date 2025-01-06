package com.example.tf.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    Long id;
    
    @Column(length = 150)
    String completeName;

    @Column(length = 20)
    String dni;

    @Column(length = 20)
    String cuil;

    @Column(length = 100)
    String address;

    @Column(length = 50)
    String telephone;

    @Column(name = "entry_date")
    LocalDate entryDate;

    // Relación Many-to-Many con Bank
    @ManyToMany
    @JoinTable(
        name = "customer_bank", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "customer_id"), // Llave foránea de Customer
        inverseJoinColumns = @JoinColumn(name = "bank_id") // Llave foránea de Bank
    )
    private List<Bank> banks = new ArrayList<>();

    //Un cliente puede tener muchas tarjetas
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    //Constructores
    public Customer() {
    }

    public Customer(String completeName, String dni, String cuil, String address, String telephone, LocalDate entryDate) {
        this.completeName = completeName;
        this.dni = dni;
        this.cuil = cuil;
        this.address = address;
        this.telephone = telephone;
        this.entryDate = entryDate;
    }

    public Customer(Long id, String completeName, String dni, String cuil, String address, String telephone, LocalDate entryDate) {
        this.id = id;
        this.completeName = completeName;
        this.dni = dni;
        this.cuil = cuil;
        this.address = address;
        this.telephone = telephone;
        this.entryDate = entryDate;
    }

    //Getters y Setters para los atributos individuales
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
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

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}