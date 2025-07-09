import java.sql.SQLException;
import java.util.Scanner;

import DB.*;

public class Main{
    public static void main(String[] args) { 
        try {
            DbConnection conn = new DbConnection("jdbc:postgresql://localhost:5432/jdbcDemo", "postgres", "Krishna@2__4");

            Crud operations = new Crud(conn.connected());

            while (true) {

                System.out.println("\nWelcome to Console Based JDBC\n\nWhich Operation would you like to perform ?\n1.Read\n2.Insert\n3.Update\n4.Delete\n5.Exit");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();

                if(choice == 1){
                    operations.read();
                }else if(choice == 2){
                    operations.insert();
                }else if(choice == 3){
                    System.out.println("\nHow would you like to update ?\n1.Update Name\n2.Update Marks");
                    int updateChoice = scan.nextInt();
                    if(updateChoice == 1){
                        operations.updateNameWithId();
                    }else if(updateChoice == 2){
                        operations.updateMarksWithId();
                    }
                }else if(choice == 4){
                    operations.deleteById();
                }else if(choice == 5){
                    break;
                }else{
                    System.out.println("Not Appropriate Choice");
                    break;
                }
                
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}