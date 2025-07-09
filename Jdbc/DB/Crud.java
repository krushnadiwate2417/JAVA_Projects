package DB;

import java.sql.*;
import java.util.Scanner;

public class Crud {

    private Connection con;
    Scanner scan = new Scanner(System.in);

    public Crud(Connection con)throws SQLException{
        this.con = con;
    }

    public void read()throws SQLException{
        String query = "Select * FROM students";
        PreparedStatement st = con.prepareStatement(query);
        ResultSet result = st.executeQuery();

        while(result.next()){
            System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getInt(3));
        }
    }

    public void insert()throws SQLException{

        System.out.println("Enter Your ID");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Your Name");
        String name = scan.nextLine();

        System.out.println("Enter Your Makrs");
        int marks = scan.nextInt();

        String query = "INSERT INTO students VALUES(?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        st.setString(2, name);
        st.setInt(3, marks);
        st.execute();
        System.out.println("Inserted SuccessFully");
    }

    public void updateNameWithId()throws SQLException{

        System.out.println("Enter ID ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Name to Update");
        String name = scan.nextLine();

        String query = "UPDATE students SET name = ? WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, name);
        st.setInt(2, id);
        st.execute();
        System.out.println("Updated SuccessFully");
    }

    public void updateMarksWithId()throws SQLException{


        System.out.println("Enter ID ");
        int id = scan.nextInt();

        System.out.println("Enter Marks to Update");
        int marks = scan.nextInt();

        String query = "UPDATE students SET marks = ? WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, marks);
        st.setInt(2, id);
        st.execute();
        System.out.println("Updated SuccessFully");
    }

    public void deleteById()throws SQLException{

        System.out.println("Enter ID to delete record");
        int id = scan.nextInt();

        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        st.execute();
        System.out.println("Deleted SuccessFully");
    }

}
