package com.banque.services.core.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private final String  txnId;
    private final String description;
    private final double amount;
    private final LocalDate date;
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private final Compte source;
    private final TransactionType type;
    @ManyToOne
    private final Compte destination;

    public Transaction(String txnId, Compte source, String description, double amount, LocalDate date, TransactionType type) {
        this.txnId = txnId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.source = source;
        this.type = type;
        destination = source;
    }

    public Transaction(String txnId, String description, double amount, LocalDate date, Compte source, TransactionType type, Compte destination) {
        this.txnId = txnId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.source = source;
        this.type = type;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Compte getSource() {
        return source;
    }

    public TransactionType getType() {
        return type;
    }

    public Compte getDestination() {
        return destination;
    }
}
