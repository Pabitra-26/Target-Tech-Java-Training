package com.target.trianing.dao;

import com.target.trianing.entity.Contact;
import com.target.trianing.entity.Gender;
import com.target.trianing.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
public class JdbcContactsDao implements ContactsDao {


    @Override
    public void addContact(Contact contact1) throws DaoException, ParseException {
        String sql = "insert into contacts values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            String gender = null;
            if(contact1.getGender() == Gender.MALE){
                gender = "Male";
            }
            else if(contact1.getGender() ==Gender.FEMALE){
                gender = "Female";
            }

            stmt.setInt(1,contact1.getId());
            stmt.setString(2, contact1.getFirstname());
            stmt.setString(3, contact1.getLastname());
            stmt.setString(4, gender);
            stmt.setString(5, contact1.getEmail());
            stmt.setString(6, contact1.getPhone());
            stmt.setString(7, contact1.getAddress());
            stmt.setString(8, contact1.getCity());
            stmt.setString(9, contact1.getState());
            stmt.setInt(10, contact1.getPincode());
            stmt.setString(11, contact1.getCountry());
            java.sql.Date dob = new java.sql.Date((contact1.getBirthDate().getTime()));
            stmt.setDate(12, dob);

            stmt.execute();

            log.debug("Contact added successfully");


        }
        catch(SQLException e){
            log.error("There was an error - {}", e.getMessage());
        }
    }

    @Override
    public Contact getContact(int id) throws DaoException {
        return null;
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

        String gender = null;
        if(contact.getGender() == Gender.MALE){
            gender = "Male";
        }
        else if(contact.getGender() ==Gender.FEMALE){
            gender = "Female";
        }

        String sql = "update contacts set firstname = '" + contact.getFirstname() + "' , lastname = '" + contact.getLastname() + "' , gender = '" + gender +
                "' , email = '" + contact.getEmail() + "' , phone = '" + contact.getPhone() + "' , address = '" + contact.getAddress() + "' , city = '" +
                contact.getCity() + "' , state = '" + contact.getState() + "' , pincode = " + contact.getPincode() + " , country = '" + contact.getCountry() + "' , birthdate = '" +
                new java.sql.Date(contact.getBirthDate().getTime()) + "' where id = "+ contact.getId();

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ){
            stmt.execute(sql);
            System.out.println("Contact updated successfully!");
        }

        catch(SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void deleteContact(int id) throws DaoException {
        String sql = "delete from contacts where id = '"+id+"'";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ){
            stmt.execute(sql);
            System.out.println("Contact deleted successfully1");
            }

         catch(SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "select * from contacts where email = '"+email+"'";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){

            while(rs.next()) {

                contacts.add(new Contact(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), Gender.valueOf(rs.getString("gender").toUpperCase()), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getInt("pincode"),
                        rs.getString("country"), rs.getDate("birthdate")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return (Contact) contacts.get(0);
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "select * from contacts where phone = '"+phone+"'";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){

            while(rs.next()) {

                contacts.add(new Contact(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), Gender.valueOf(rs.getString("gender").toUpperCase()), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getInt("pincode"),
                        rs.getString("country"), rs.getDate("birthdate")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return (Contact) contacts.get(0);
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "select * from contacts where lastname = '"+lastname+"'";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                contacts.add(new Contact(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), Gender.valueOf(rs.getString("gender").toUpperCase()), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getInt("pincode"),
                        rs.getString("country"), rs.getDate("birthdate")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "select * from contacts where city = '"+city+"'";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                contacts.add(new Contact(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), Gender.valueOf(rs.getString("gender").toUpperCase()), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getInt("pincode"),
                        rs.getString("country"), rs.getDate("birthdate")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "select * from contacts";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                contacts.add(new Contact(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), Gender.valueOf(rs.getString("gender").toUpperCase()), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getInt("pincode"),
                        rs.getString("country"), rs.getDate("birthdate")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        System.out.println(from +" " + to);
        List<Contact> contacts = new ArrayList<>();
        java.sql.Date date1 = new java.sql.Date(from.getTime());
        java.sql.Date date2 = new java.sql.Date(to.getTime());
        String sql = "select * from contacts where birthdate between '"+date1+"' and '"+date2+"'";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                contacts.add(new Contact(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), Gender.valueOf(rs.getString("gender").toUpperCase()), rs.getString("email"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getInt("pincode"),
                        rs.getString("country"), rs.getDate("birthdate")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
    }
}
