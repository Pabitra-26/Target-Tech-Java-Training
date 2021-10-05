package com.target.trianing.dao;


import com.target.trianing.entity.Contact;
import com.target.trianing.entity.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HashMapContactDao implements ContactsDao {



    HashMap<Integer, Contact> contacts = new HashMap<>();

    public HashMapContactDao() throws ParseException {
        Contact contact1 = new Contact(1, "Pabitra", "Jena", Gender.FEMALE, "pabitra.jena@rocketmail.com", "9876543212","Indiranagar", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("26/08/1999"));
        Contact contact2 = new Contact(2, "Arpita", "Jena", Gender.FEMALE, "arpita.jena@rocketmail.com", "9876823212", "Indiranagar", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2005"));
        Contact contact3 = new Contact(3, "Damon", "Salvatore", Gender.MALE, "damon.salvatore@rocketmail.com", "9879123212", "Mystic Falls", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2005"));
        Contact contact4 = new Contact(4, "Stefan", "Salvatore", Gender.MALE, "stefan.salvatore@rocketmail.com", "9872723212", "Mystic Falls", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("13/05/2005"));
        Contact contact5 = new Contact(5, "Elena", "Gilbert", Gender.MALE, "elena.gilbert@rocketmail.com", "9892123212", "Mystic Falls", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("12/06/2005"));
        contacts.put(contact1.getId(), contact1);
        contacts.put(contact2.getId(),contact2);
        contacts.put(contact3.getId(), contact3);
        contacts.put(contact4.getId(), contact4);
        contacts.put(contact5.getId(), contact5);


    }
    @Override
    public void addContact(Contact contact) throws DaoException{

        if(contact == null){
            throw new DaoException("Cannot get a null contact!");
        }
        if(contact.getId() <= 0 || contact.getId() == null){
            throw new DaoException("Id cannot be 0 or null or negative!");
        }
        if(contact.getFirstname() == null){
            throw new DaoException("Firstname cannot be null");
        }
        if(contact.getLastname() == null){
            throw new DaoException("Lastname cannot be null");
        }
        if(contact.getEmail() == null){
            throw new DaoException("Email cannot be null");
        }
        if(contact.getPhone() == null || contact.getPhone().length() < 10){
            throw new DaoException("Phone number cannot be null or less than 10 digits");
        }
        if(contact.getPincode() == null || (Integer.toString(contact.getPincode())).length()<6){
            throw new DaoException("PinCode cannot be null or less tha 6 digits");
        }
        if(contact.getBirthDate() == null){
            throw new DaoException("Birth date cannot be null");
        }

       contacts.put(contact.getId(), contact);



    }

    @Override
    public Contact getContact(int id) throws DaoException {

            Contact contact =  contacts.get(id);
            if(contact == null){
                throw new DaoException("Contact with id " + id + " not found");
            }
            return contact;

    }

    @Override
    public void updateContact(Contact contact) throws DaoException {
        Integer key = contact.getId();
        contacts.put(key, contact);


    }

    @Override
    public void deleteContact(int id) throws DaoException {
        contacts.remove(id);

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        List<Integer> keys = contacts.keySet().stream().collect(Collectors.toList());
        for(int i =0; i< keys.size(); i++){
            if((contacts.get(keys.get(i))).getEmail().equals(email)){
                return contacts.get(keys.get(i));
            }
        }

        return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        List<Integer> keys = contacts.keySet().stream().collect(Collectors.toList());
        for(int i =0; i< keys.size(); i++){
            if((contacts.get(keys.get(i))).getPhone().equals(phone)){
                return contacts.get(keys.get(i));
            }
        }
        return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        List<Contact> conts = new ArrayList<>();
        List<Integer> keys = contacts.keySet().stream().collect(Collectors.toList());
        for(int i =0; i< keys.size(); i++){

            Contact cont = contacts.get(keys.get(i));

            if(cont.getLastname().equals(lastname)){

                conts.add(contacts.get(keys.get(i)));
            }
        }


        return conts;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        List<Contact> conts = new ArrayList<>();
        List<Integer> keys = contacts.keySet().stream().collect(Collectors.toList());
        for(int i =0; i< keys.size(); i++){
            if((contacts.get(keys.get(i))).getCity().equals(city)){
                System.out.println("Hi1");
                conts.add(contacts.get(keys.get(i)));
            }
        }
        System.out.println("Hi2");

        return conts;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        List<Contact> conts = new ArrayList<>();
        List<Integer> keys = contacts.keySet().stream().collect(Collectors.toList());
        for(int i=0; i< keys.size(); i++){
            conts.add(contacts.get(keys.get(i)));

        }


        return conts;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        List<Contact> conts = new ArrayList<>();
        List<Integer> keys = contacts.keySet().stream().collect(Collectors.toList());
        for(int i=0; i< keys.size(); i++){
            if((contacts.get(keys.get(i))).getBirthDate().after(from) && (contacts.get(keys.get(i))).getBirthDate().before(to)){
                conts.add(contacts.get(keys.get(i)));
            }
        }
        return conts;
    }
}
