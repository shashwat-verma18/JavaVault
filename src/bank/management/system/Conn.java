package bank.management.system;

import java.sql.*;
public class Conn {

    /* Five steps in JDBC Connectivity :
        1. Register the Driver
        2. Create Connection
        3. Create Statement
        4. Execute Query
        5. Close the connection
     */

    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bank","root","123456789");
            s = c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
