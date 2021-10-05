package com.target.trianing.dao;



import com.target.trianing.entity.Contact;
import com.target.trianing.entity.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class ArrayListContactDao implements ContactsDao {


    private List<Contact> contacts = new ArrayList<>();

    public ArrayListContactDao() throws ParseException {
        contacts.add(new Contact(1, "Pabitra", "Jena", Gender.FEMALE, "pabitra.jena@rocketmail.com", "9876543212","Indiranagar", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("26/08/1999")));
        contacts.add(new Contact(2, "Arpita", "Jena", Gender.FEMALE, "arpita.jena@rocketmail.com", "9876823212", "Indiranagar", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2005")));
        contacts.add(new Contact(3, "Damon", "Salvatore", Gender.MALE, "damon.salvatore@rocketmail.com", "9879123212", "Mystic Falls", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2005")));
        contacts.add(new Contact(4, "Stefan", "Salvatore", Gender.MALE, "stefan.salvatore@rocketmail.com", "9872723212", "Mystic Falls", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("13/05/2005")));
        contacts.add(new Contact(5, "Elena", "Gilbert", Gender.MALE, "elena.gilbert@rocketmail.com", "9892123212", "Mystic Falls", "Bangalore" , "Karnataka" , 567894 , "India" , new SimpleDateFormat("dd/MM/yyyy").parse("12/06/2005")));
    }
    @Override
    public void addContact(Contact contact) throws DaoException {

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

        contacts.add(contact);

    }

    @Override
    public Contact getContact(int id) throws DaoException {

        Contact contact = (Contact) contacts.stream()
                .filter(c -> c.getId() == id);
        if(contact == null){
            throw new DaoException("No contact with id " + id + " found");

        }
        return contact;

    }

    @Override
    public void updateContact(Contact contact) throws DaoException {
        Integer index = contact.getId();
        int i = 0;
        for(i=0;i<contacts.size();i++){
            if((contacts.get(i)).getId() == index){
                break;
            }
        }

        contacts.set(i, contact);
    }

    @Override
    public void deleteContact(int id) throws DaoException {
        for(int i = 0; i<contacts.size(); i++){
            if(contacts.get(i).getId() == id){
                contacts.remove(i);
                System.out.println("Deleted successfully!");
                return;
            }
        }
        System.out.println("Contact with id " + id + " cannot be found!");


    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {

        Object contact = contacts.stream()
                .filter(c -> c.getEmail().equals(email))
                .collect(Collectors.toList());

        if(contact == null){
            throw new DaoException("Contact with email " + email + " not found");
        }
        return (Contact)((List<Contact>)contact).get(0);
//
    }


    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        Object contact = contacts.stream()
                .filter(c -> c.getPhone().equals(phone))
                .collect(Collectors.toList());


        if(contact == null){
            throw new DaoException("Contact with phone " + phone + " not found");
        }
        return (Contact)((List<Contact>)contact).get(0);
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        Object contact = contacts.stream()
                .filter(c -> c.getLastname().equals(lastname))
                .collect(Collectors.toList());

        if(contact == null){
            throw new DaoException("Contact with lastname " + lastname + " not found");
        }
        return (List<Contact>) contact;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        Object contact = contacts.stream()
                .filter(c -> c.getCity().equals(city))
                .collect(Collectors.toList());

        if(contact == null){
            throw new DaoException("Contacts with city " + city + " not found");
        }
        return (List<Contact>) contact;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        return this.contacts;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        Object contact = contacts.stream()
                .filter(c -> c.getBirthDate().after(from) && c.getBirthDate().before(to))
                .collect(Collectors.toList());

        if(contact == null){
            throw new DaoException("Contacts not found");
        }
        return (List<Contact>) contact;
    }
}
