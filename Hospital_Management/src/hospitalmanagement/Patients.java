package hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Patients {
    private Connection connection;
    private Scanner scanner;

    public Patients(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient(){
        System.out.print("Enter Patient Name : ");
        String name = scanner.next();
        System.out.print("Enter Patient Age : ");
        int age = scanner.nextInt();
        System.out.print("Enter Patient Gender : ");
        String gender = scanner.next();

        try {
            String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2, age);
            statement.setString(3, gender);

            int affectedRow = statement.executeUpdate();
            if(affectedRow > 0){
                System.out.println("Patient Data Inserted !");
            }else{
                System.out.println("Failed to Insert Patient !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void viewPatients(){
        String query = "SELECT * FROM patients";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            System.out.println("Pateint Id \t Name \t Age \t Gender \n ");
            while(result.next()){
                System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+
                result.getInt(3)+"\t"+
                result.getString(4)
            );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPatient(int id){
        String query = "SELECT * FROM patients WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
