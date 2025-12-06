import java.sql.SQLException;
import java.util.Scanner;

import hospitalmanagement.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            Db conn = new Db("root", "jdbc:mysql://localhost:3306/hospital", "Krishna@2__4");
            Patients patients = new Patients(conn.connected(), scan);
            Doctors doctors = new Doctors(conn.connected(), scan);
            Appointment appointment = new Appointment(conn.connected(), scan);

            while(true){
                System.out.println("======= Main Menu =======");
                System.out.println("Please Select one of the following operations : ");
                System.out.println("1. Pateints\n2. Doctors\n3.Appointments\n4.Exit");
                int choosen = scan.nextInt();
                if(choosen==1){
                    System.out.println("Please Select : ");
                    System.out.println("1.Add Pateints\n2.Get all Patinets\n3.Check Patient by Id");
                    int ptOp = scan.nextInt();
                    if(ptOp==1){
                        patients.addPatient();
                    }else if(ptOp == 2){
                        patients.viewPatients();
                    }else{
                        System.out.println("Please Enter a Patient Id : ");
                        int ptId = scan.nextInt();
                        Boolean pateintId = patients.checkPatient(ptId);
                        if(pateintId == true){
                            System.out.println("Patient is Present");
                        }else{
                            System.out.println("Patient is not Present");
                        }
                    }
                }
                if(choosen==2){
                    System.out.println("Please Select : ");
                    System.out.println("1. Get all doctors\n2.Check doc by id");
                    int docOp = scan.nextInt();
                    if(docOp==1){
                        doctors.getDoctors();
                    }else if(docOp==2){
                        System.out.println("Please Enter Doc Id : ");
                        int docID = scan.nextInt();
                        Boolean docCheck = doctors.checkDoctor(docID);
                        if(docCheck == true){
                            System.out.println("Doc is Present");
                        }else{
                            System.out.println("Doc is not Present");
                        }
                    }
                }
                if(choosen==3){
                    System.out.println("Please Select : ");
                    System.out.println("1. View Appointments\n2.Book Appointment");
                    int appOp = scan.nextInt();
                    if(appOp == 1){
                        appointment.viewAppointments();
                    }else if(appOp == 2){
                        appointment.setAppointment();
                    }
                }
                if(choosen == 4){
                    System.out.println("Thankyou for using our System");    
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
