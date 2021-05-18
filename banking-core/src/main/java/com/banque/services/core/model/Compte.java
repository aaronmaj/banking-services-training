package com.banque.services.core.model;

import javax.persistence.*;

@Entity
@Table(name ="Comptes")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="numero", unique = true, nullable = false)
    private String numero;
    @Column(nullable = false)
    private String intitule;
    @Column(name="type", nullable = false)
    private Type type;
    @Column(nullable = false)
    private Status status;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Compte() {
    }

    public Compte(String numero, String intitule, Type type, Status status, double solde, Client client) {
        this.numero = numero;
        this.intitule = intitule;
        this.type = type;
        this.status = status;
        this.solde = solde;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }
}
