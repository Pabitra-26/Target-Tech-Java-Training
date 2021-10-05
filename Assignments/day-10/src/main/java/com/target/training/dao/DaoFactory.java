package com.target.training.dao;

import java.util.ResourceBundle;

public final class DaoFactory {

    private DaoFactory(){}

    private static ContactsDao dao = null;

    public static ContactsDao getContactDao() throws DaoException {
        if(dao != null) {
            return dao;
        }

        ResourceBundle rb = ResourceBundle.getBundle("contact-dao");

        String discriminator = rb.getString("discriminator");

        switch (discriminator.toLowerCase()){

            case "arraylist":
                // dao = new ArrayListContactsDao();
                break;

            case "jdbc":
                // dao = new JdbcContactsDao();
                break;

            case "hashmap":
                // dao = new HashmapContactsDao();
                break;

            case "jpa":
                 dao = new JpaContactsDao();
                break;

            default:
                throw new DaoException("Request for unknown type of implementation of ContactsDao");
        }

        return dao;
    }
}
