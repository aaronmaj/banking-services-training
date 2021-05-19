package com.banque.services.core.persistence.jpa;

import com.banque.services.core.model.Compte;
import com.banque.services.core.persistence.CompteDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class JpaCompteDao implements CompteDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banking-pu");

    @Override
    public List<Compte> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Compte> people = em.createQuery("select c from Compte c", Compte.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return people;
    }

    @Override
    public Optional<Compte> findbyId(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Compte compte = em.find(Compte.class, id);
        em.getTransaction().commit();
        em.close();
        return Optional.of(compte);
    }

    public Optional<Compte> findbyNum(String numcompte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Compte compte = em.createQuery("select c from Compte c where c.numero =?1", Compte.class)
                .setParameter(1,numcompte)
                .getSingleResult();

        em.getTransaction().commit();
        em.close();
        return Optional.of(compte);
    }
    @Override
    public Integer save(Compte compte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(compte);
        em.getTransaction().commit();
        em.close();
        return compte.getId();
    }

    @Override
    public void delete(Compte compte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(compte);
        em.getTransaction().commit();
        em.close();

    }

}
