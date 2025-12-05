import java.sql.SQLException;

import hospitalmanagement.*;

public class Main {
    public static void main(String[] args){

        try {
            Db conn = new Db("root", "jdbc:mysql://localhost:3306/hospital", "Krishna@2__4");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
