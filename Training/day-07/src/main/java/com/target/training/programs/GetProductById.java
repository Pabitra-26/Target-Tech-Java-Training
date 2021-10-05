package com.target.training.programs;


import com.target.training.utils.DbUtil;
import com.target.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class GetProductById {

    public static void main(String[] args) {

        String sql = "select * from products where id=?";

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ) {

            int id = KeyboardUtil.getInt("Enter product id to search: ");
            stmt.setInt(1, id);
            stmt.execute();


            try(ResultSet rs = stmt.getResultSet()){
                if(rs.next()){
                    log.debug("id = {}, name = \"{}\", price = {}",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"));
                }
                else{
                    log.warn("No product data found for id {}", id);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
