package hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Doctors {
    
    private Connection connection;
    private Scanner scanner;

    public Doctors(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void getDoctors(){
        String query = "SELECT * FROM doctors";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("Doctor Id \t Name \t Specialization \n ");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
                resultSet.getString(3)
            );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkDoctor(int id){
        String qurery = "SELECT * FROM doctors WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(qurery);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
