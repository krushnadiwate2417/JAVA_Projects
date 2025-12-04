package hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Appointment {
    private Connection connection;
    private Scanner scanner;

    public Appointment(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void setAppointment(){
        System.out.println("Book Appointment : ");
        System.out.print("Enter Patient Id : ");
        int patient_id = scanner.nextInt();
        System.out.print("Enter Doctor Id : ");
        int doctor_id = scanner.nextInt();
        System.out.print("Enter Appointment Date : ");
        String appointemnt = scanner.next();

        String query = "INSERT INTO appointments(patient_id,doctor_id,appointment VALUES(?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, patient_id);
            statement.setInt(2, doctor_id);
            statement.setString(3, appointemnt);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Appointment Booked Successfully");
            }else{
                System.out.println("Could'nt book appointment");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void viewAppointments(){
        String query = "SELECT id, doctors.name as doctor_name, patients.name as patient_name, appointment FROM appointments INNER JOIN patients ON appointments.patient_id = patients.id INNER JOIN doctors ON appointments.doctor_id = doctors.id";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            System.out.println("ID \t Doctor Name \t Patient Name \t App_Date \n");
            if(result.next()){
                System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getDate(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
