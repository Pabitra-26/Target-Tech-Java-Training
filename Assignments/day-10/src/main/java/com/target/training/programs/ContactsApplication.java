package com.target.training.programs;

import com.target.training.dao.ContactsDao;
import com.target.training.dao.DaoException;
import com.target.training.dao.DaoFactory;
import com.target.training.entity.Contact;
import com.target.training.entity.Gender;
import com.target.utils.KeyboardUtil;


import java.text.ParseException;
import java.util.Date;
import java.util.List;


public class ContactsApplication {

    ContactsDao dao;

    public static void main(String[] args) throws ParseException, DaoException {

        new ContactsApplication().start();
    }

    void line(char patter){
        for(int i=0; i<= 220; i++){
            System.out.print(patter);
        }
        System.out.println();
    }

    int menu(){
        line('.');
        int choice = -1;
        do{
            System.out.println("0. Exit");
            System.out.println("1. Add new contact");
            System.out.println("2. List all contacts");
            System.out.println("3. Search by lastname");
            System.out.println("4. Search by email address");
            System.out.println("5. Search by phone number");
            System.out.println("6. Search by city");
            System.out.println("7. Search by date of birth range");
            System.out.println("8. Delete contact");
            System.out.println("9. Edit contact");
            try{
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if(choice < 0 || choice > 9){
                    System.out.println("Invalid choice, please try again!");
                }
            }
            catch(Exception e){
                System.out.println("Invalid choice, please try again!");
            }
        } while(choice < 0 || choice > 9 );

        return choice;
    }


    void start() throws ParseException, DaoException {

        dao = DaoFactory.getContactDao();
        int choice;

        while((choice = menu())!= 0){
            switch(choice){
                case 1:
                    acceptAndAddContactDetails();
                    break;

                case 2:
                    listContacts();
                    break;

                case 3:
                    searchByLastName();
                    break;

                case 4:
                    searchByEmail();
                    break;

                case 5:
                    searchByPhone();
                    break;

                case 6:
                    searchByCity();
                    break;

                case 7:
                    searchByBirthDate();
                    break;

                case 8:
                    deleteContact();
                    break;

                case 9:
                    updateContact();
                    break;

            }
        }
        System.out.println("Bye!");
    }

    private void updateContact() {
        Integer id = KeyboardUtil.getInt("Enter id of the contact to be updated: ");
        try{
            Integer index = id;
            String firstname = KeyboardUtil.getString("Enter firstname: ");
            String lastname = KeyboardUtil.getString("Enter lastname: ");
            String gender = KeyboardUtil.getString("Enter gender (Male or Female): ");
            Gender gen = Gender.MALE;
            if(gender.equals("Male")){
                gen = Gender.MALE;
            }
            else if(gender.equals("Female")){
                gen = Gender.FEMALE;
            }
            String email = KeyboardUtil.getString("Enter email: ");
            String phone = KeyboardUtil.getString("Enter phone number: ");
            String address = KeyboardUtil.getString("Enter address: ");
            String city = KeyboardUtil.getString("Enter city: ");
            String state = KeyboardUtil.getString("Enter state: ");
            Integer pinCode = KeyboardUtil.getInt("Enter pin Code: ");
            String country = KeyboardUtil.getString("Enter country: ");
            Date birthDate = KeyboardUtil.getDate("Enter birth date: ");
            Contact contact1 = new Contact(index, firstname, lastname, gender, email, phone, address, city, state, pinCode, country, birthDate);
            dao.updateContact(contact1);
            System.out.println("Contact updated successfully!");

        }
        catch (Exception e){
            System.out.println("There was a problem while adding the product details.");
            System.out.println(e.getMessage());
        }

    }

    private void deleteContact() throws DaoException{
        Integer id = KeyboardUtil.getInt("Enter id of the contact to be deleted: ");
        dao.deleteContact(id);
        System.out.println("Contact deleted successfully!");
    }

    private void searchByBirthDate() {
        Date fromDate = KeyboardUtil.getDate("Enter \"from\" date: ");
        Date toDate = KeyboardUtil.getDate("Enter \"to\" date: ");
        try{
            List<Contact> conts = dao.getContactsByBirthDate(fromDate, toDate);
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", "ID", "First Name", "Last Name", "Gender", "Email", "Phone Number", "Address", "City", "State", "Pin Code", "Country", "Birth Date");
            line('=');
            for (Contact c : conts) {
                System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", c.getId(), c.getFirstname(), c.getLastname(), c.getGender(), c.getEmail(), c.getPhone(), c.getAddress(), c.getCity(), c.getState(), c.getPinCode(), c.getCountry(), c.getBirthDate());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("Contact with birth dates, ranging from " + fromDate + " to " + toDate + " do not exist!");
        }
    }

    private void searchByCity() {

        String city = KeyboardUtil.getString("Enter city: ");
        try{
            List<Contact> conts = dao.getContactsByCity(city);
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", "ID", "First Name", "Last Name", "Gender", "Email", "Phone Number", "Address", "City", "State", "Pin Code", "Country", "Birth Date");
            line('=');
            for (Contact c : conts) {
                System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", c.getId(), c.getFirstname(), c.getLastname(), c.getGender(), c.getEmail(), c.getPhone(), c.getAddress(), c.getCity(), c.getState(), c.getPinCode(), c.getCountry(), c.getBirthDate());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("Contact with city " + city + " doesn't exist!");
        }
    }

    private void searchByPhone() {

        String phone = KeyboardUtil.getString("Enter phone number: ");
        try{
            Contact c = dao.getContactByPhone(phone);
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", "ID", "First Name", "Last Name", "Gender", "Email", "Phone Number", "Address", "City", "State", "Pin Code", "Country", "Birth Date");
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", c.getId(), c.getFirstname(), c.getLastname(), c.getGender(), c.getEmail(), c.getPhone(), c.getAddress(), c.getCity(), c.getState(), c.getPinCode(), c.getCountry(), c.getBirthDate());
            line('-');
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchByEmail() {
        String email = KeyboardUtil.getString("Enter email: ");
        try{
            Contact c = dao.getContactByEmail(email);
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", "ID", "First Name", "Last Name", "Gender", "Email", "Phone Number", "Address", "City", "State", "Pin Code", "Country", "Birth Date");
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", c.getId(), c.getFirstname(), c.getLastname(), c.getGender(), c.getEmail(), c.getPhone(), c.getAddress(), c.getCity(), c.getState(), c.getPinCode(), c.getCountry(), c.getBirthDate());
            line('-');
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchByLastName() throws DaoException {
        String lastname = KeyboardUtil.getString("Enter lastname: ");
        try{
            List<Contact> conts = dao.getContactsByLastname(lastname);
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", "ID", "First Name", "Last Name", "Gender", "Email", "Phone Number", "Address", "City", "State", "Pin Code", "Country", "Birth Date");
            line('=');
            for (Contact c : conts) {
                System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", c.getId(), c.getFirstname(), c.getLastname(), c.getGender(), c.getEmail(), c.getPhone(), c.getAddress(), c.getCity(), c.getState(), c.getPinCode(), c.getCountry(), c.getBirthDate());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("Contact with last name " + lastname + " doesn't exist!");
        }

    }

    private void acceptAndAddContactDetails(){
        try{
            Integer id = KeyboardUtil.getInt("Enter id: ");
            String firstname = KeyboardUtil.getString("Enter firstname: ");
            String lastname = KeyboardUtil.getString("Enter lastname: ");
            String gender = KeyboardUtil.getString("Enter gender (Male or Female): ");
            Gender gen = Gender.MALE;
            if(gender.equals("Male")){
                gen = Gender.MALE;
            }
            else if(gender.equals("Female")){
                gen = Gender.FEMALE;
            }
            String email = KeyboardUtil.getString("Enter email: ");
            String phone = KeyboardUtil.getString("Enter phone number: ");
            String address = KeyboardUtil.getString("Enter address: ");
            String city = KeyboardUtil.getString("Enter city: ");
            String state = KeyboardUtil.getString("Enter state: ");
            Integer pinCode = KeyboardUtil.getInt("Enter pin Code: ");
            String country = KeyboardUtil.getString("Enter country: ");
            Date birthDate = KeyboardUtil.getDate("Enter birth date: ");
            Contact contact1 = new Contact(id, firstname, lastname, gender, email, phone, address, city, state, pinCode, country, birthDate);
            dao.addContact(contact1);
            System.out.println("New contact added successfully!");

        }
        catch (Exception e){
            System.out.println("There was a problem while adding the product details.");
            System.out.println(e.getMessage());
        }
    }

    private void listContacts(){
        try{
            List<Contact> cont = dao.getContacts();
            line('=');
            System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", "ID", "First Name", "Last Name", "Gender", "Email", "Phone Number", "Address", "City", "State", "Pin Code", "Country", "Birth Date");
            line('=');
            for (Contact c : cont) {
                System.out.printf("%-10s %-15s %-15s %-10s %-35s %-20s %-20s %-20s %-20s %-20s %-20s %10s\n", c.getId(), c.getFirstname(), c.getLastname(), c.getGender(), c.getEmail(), c.getPhone(), c.getAddress(), c.getCity(), c.getState(), c.getPinCode(), c.getCountry(), c.getBirthDate());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("There was a problem");
        }
    }
}
