package com.banque.services.core.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name ="Comptes")
@XmlRootElement(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="numero", unique = true, nullable = false)
    private String numero;
    @Column(nullable = false)
    private String intitule;
    @Column(columnDefinition = "ENUM('COURANT', 'EPARGNE', 'DEPOT')")
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(columnDefinition = "ENUM('OUVERT','ACTIVE','INACTIVE', 'BLOQUE','CLOTURE')")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(columnDefinition = "ENUM('INDIVIDUEL', 'JOINT', 'INDIVIS')")
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Compte() {
    }

    public Compte(String numero, String intitule, Type type, Status status,
                  double solde, Client client) {
        this.numero = numero;
        this.intitule = intitule;
        this.type = type;
        this.status = status;
        this.solde = solde;
        this.client = client;
        this.categorie = Categorie.INDIVIDUEL;
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

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
