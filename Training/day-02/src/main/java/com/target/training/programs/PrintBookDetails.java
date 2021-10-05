package com.target.training.programs;

import com.target.training.model.Book;

public class PrintBookDetails {

    public static void main(String[] args) {

        Book b1;

        b1 = new Book();

        System.out.println("b1 is " + b1);
        System.out.println("Title is " + b1.title);
        b1.title = "Let us C";
        b1.price = 399.0;
        System.out.println("Title is " + b1.title);
        b1.title = "Let us J";
        System.out.println("Title is " + b1.title);
        System.gc();

    }
}
