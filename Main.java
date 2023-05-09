import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/pushkar_jdbc";
            String username="root";
            String password="root";
            Connection con= DriverManager.getConnection(url,username,password);

            if(con.isClosed()){
                System.out.println("Connection is closed");

            }
            else{
                System.out.println("Conection is Created");

                //To Create the table table1   --~ statement query
//                String q="Create table table1(id int(20) primary key auto_increment,Name varchar(200) not null , city varchar(200))";
//                Statement stmt=con.createStatement();
//
//                stmt.executeUpdate(q);
//
//                System.out.println("Table is created");
                String q="Insert into table1(Name,city) Values(?,?)";

                PreparedStatement pre=con.prepareStatement(q);

                // set the value
                pre.setString(1,"Pushkar Dayal");
                pre.setString(2,"Sasaram");

                pre.executeUpdate();
                System.out.println("Row is inserted");
                con.close();

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}