package com.target.trianing.dao;

import java.text.ParseException;
import java.util.ResourceBundle;

public final class DaoFactory {
    // do not let anyone instantiate this class
    private DaoFactory() {
    }

    private static ContactsDao dao = null;

    public static ContactsDao getContactDao() throws DaoException, ParseException {
        if (dao != null) return dao;

        ResourceBundle rb = ResourceBundle.getBundle("contact-dao");
        String discriminator = rb.getString("discriminator");

        switch (discriminator.toLowerCase()) {
            case "arraylist":
                dao = new ArrayListContactDao();
                break;
            case "jdbc":
//                dao= new JdbcContactsDao(); break;
            case "hashmap":
                // dao= new HashMapContactDao(); break;
            case "csv":
                // dao= new CsvProductDao(); break;
            case "jpa":
                // dao= new JpaProductDao(); break;
            default:
                throw new DaoException("Request for unknown type of implementation for ProductDao");
        }
        return dao;
    }
}
