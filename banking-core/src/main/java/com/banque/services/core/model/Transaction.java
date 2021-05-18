package com.banque.services.core.model;

import java.time.LocalDate;

public class Transaction {
    public Integer id;
    private final String description;
    private final double amount;
    private final LocalDate date;
    private final Compte source;
    private final TransactionType type;
    private final Compte destination;

    public Transaction(Compte source, String description, double amount, LocalDate date, TransactionType type) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.source = source;
        this.type = type;
        destination = source;
    }

    public Transaction(String description, double amount, LocalDate date, Compte source, TransactionType type, Compte destination) {
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
