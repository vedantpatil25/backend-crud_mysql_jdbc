import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.xdevapi.PreparableStatement;

public class stock {

    public void CreateDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "Vedant@2501";

            // connection established
            Connection con = DriverManager.getConnection(url, username, password);

            // statement created
            Statement stmt = con.createStatement();
            System.out.println("Connection Successful");
            String query = "create database temp;";
            // executing the query
            int temp = stmt.executeUpdate(query);
            System.out.println("Database Created " + temp);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/crudApp";
            String username = "root";
            String password = "Vedant@2501";

            // connection established
            Connection con = DriverManager.getConnection(url, username, password);

            // statement created
            Statement stmt = con.createStatement();
            System.out.println("Connection Successful");
            String query = "create table stockPrice(date varchar(20), closingPrice int(10));";

            // executing the query
            int temp = stmt.executeUpdate(query);
            System.out.println("Table is created: " + temp);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData() {

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "crudApp";
            String username = "root";
            String password = "Vedant@2501";

            // connection established
            Connection con = DriverManager.getConnection(url+db, username, password);

            // preapare statement created
            String query = "insert into stockPrice(date, closingPrice) values(?, ?);";
            PreparedStatement pstm = con.prepareStatement(query);

            //setting up the values in the question marks
            pstm.setString(1, "18-06-2023");
            pstm.setInt(2, 149);

            // executing the query
            boolean temp = pstm.execute();
            System.out.println("Data inserted: " + temp);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "crudApp";
            String username = "root";
            String password = "Vedant@2501";

            // connection established
            Connection con = DriverManager.getConnection(url+db, username, password);

            // preapare statement created
            String query = "select * from stockPrice;";
            Statement stm = con.createStatement();

            // executing the query
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()){
                System.out.println("On date "+rs.getString(1) + " closing price was " + rs.getInt(2));
            }

            System.out.println("Data Read successful:");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "crudApp";
            String username = "root";
            String password = "Vedant@2501";

            // connection established
            Connection con = DriverManager.getConnection(url+db, username, password);

            // preapare statement created
            String query = "update stockPrice set closingPrice=? where date=?";
            PreparedStatement pstm = con.prepareStatement(query);

            //setting up the values in the question marks
            pstm.setInt(1, 155);
            pstm.setString(2, "19-06-2023");

            // executing the query
            boolean temp = pstm.execute();
            System.out.println("Data updated successfully: " + temp);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        try {
            String url = "jdbc:mysql://localhost:3306/crudApp";
            String username = "root";
            String password = "Vedant@2501";

            // connection established
            Connection con = DriverManager.getConnection(url, username, password);

            // statement created
            Statement stmt = con.createStatement();
            System.out.println("Connection Successful");
            String query = "delete from stockPrice where date ='18-06-2023';";

            // executing the query
            boolean temp = stmt.execute(query);
            System.out.println("rows deleted successfully: " + temp);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}