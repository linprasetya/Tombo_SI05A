package Koneksi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Trax
 */
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
 private static Connection koneksi;

 public static Connection GetConnection() throws SQLException{
 if(koneksi==null){
     Driver driver = new Driver();


koneksi=DriverManager.getConnection("jdbc:mysql://localhost/db_tubes","root","");
 }
 return koneksi;
 }
}