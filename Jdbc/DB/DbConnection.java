package DB;
import java.sql.*;


public class DbConnection {

    private String url;
    private String uname;
    private String pass;
    private Connection con;

    public DbConnection(String url, String uname, String pass) throws ClassNotFoundException, SQLException{

        this.url = url;
        this.uname = uname;
        this.pass = pass;

        Class.forName("org.postgresql.Driver");

        this.con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established");
    }

    public Connection connected(){
        return con;
    }

    public void closeConnection() throws SQLException{
        this.con.close();
        System.out.println("Connection Closed");
    }

}
