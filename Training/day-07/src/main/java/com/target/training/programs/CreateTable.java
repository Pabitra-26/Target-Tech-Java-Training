package com.target.training.programs;

import com.target.training.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class CreateTable {

    public static void main(String[] args) {

        String cmd = "create table person(\n" +
                "   id integer primary key,\n" +
                "   name varchar(50) not null,\n" +
                "   price decimal\n" +
                ")";

        try(
                Connection conn = DbUtil.createConnection(); // equivalent of a bridge
                Statement stmt = conn.createStatement() // equivalent of a car that carri
                ){
            stmt.execute(cmd);
            log.debug("SQL command executed successfully on the DB server");

        }// conn.close() and stmt.close() here
        catch (Exception e){
            log.error("There was an error", e);
        }
    }
}
