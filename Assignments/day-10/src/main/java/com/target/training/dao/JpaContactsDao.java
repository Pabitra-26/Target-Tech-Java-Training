package com.target.training.dao;

import com.target.training.entity.Contact;
import com.target.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


@Slf4j
public class JpaContactsDao implements ContactsDao{

    @Override
    public void addContact(Contact contact) throws DaoException, ParseException {

        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{

            em.persist(contact);
            tx.commit();
        }
        catch (Exception e){
            tx.rollback();
        }
       // em.close();

    }

    @Override
    public Contact getContact(int id) throws DaoException {

        EntityManager em = JpaUtil.createEntityManager();
        Contact contact = em.find(Contact.class, id);

        if(contact == null){
            throw new DaoException("No data found for contacts with id "+ id);
        }

//        em.close();


        return contact;
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {
        EntityManager em = JpaUtil.createEntityManager();
//
        em.merge(contact);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();

//        em.close();


    }

    @Override
    public void deleteContact(int id) throws DaoException {
        EntityManager em = JpaUtil.createEntityManager();
        Contact contact = em.find(Contact.class, id);
        System.out.println(contact);
        em.remove(contact);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();

//        em.close();


    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {

        String jpql = "from Contact where email = ?0";

        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Contact> qry = em.createQuery(jpql, Contact.class);
        qry.setParameter(0, email);
        Contact contact = qry.getSingleResult();
//        em.close();
        return contact;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        String jpql = "from Contact where phone = ?0";

        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Contact> qry = em.createQuery(jpql, Contact.class);
        qry.setParameter(0, phone);
        Contact contact = qry.getSingleResult();
//        em.close();
        return contact;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        String jpql = "from Contact where lastname = ?0";

        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Contact> qry = em.createQuery(jpql, Contact.class);
        qry.setParameter(0, lastname);
        List<Contact> contacts = qry.getResultList();
//        em.close();
        return contacts;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        String jpql = "from Contact where city = ?0";

        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Contact> qry = em.createQuery(jpql, Contact.class);
        qry.setParameter(0, city);
        List<Contact> contacts = qry.getResultList();
//        em.close();
        return contacts;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {


        EntityManager em = JpaUtil.createEntityManager();

        return em.createQuery("select a from Contact a", Contact.class).getResultList();
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        String jpql = "from Contact where birthDate >= ?0 and birthDate <= ?1";
        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Contact> qry = em.createQuery(jpql, Contact.class);
        qry.setParameter(0, from);
        qry.setParameter(1, to);
        List<Contact> contacts = qry.getResultList();
//        em.close();
        return contacts;
    }
}
