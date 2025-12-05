import java.sql.*;

public class Db {
    private String uname;
    private String url;
    private String pass;
    private Connection con;

    public Db(String uname, String url, String pass) throws ClassNotFoundException, SQLException{
        this.url = url;
        this.uname = uname;
        this.pass = pass;


        Class.forName("com.mysql.cj.jdbc.Driver");

        this.con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established ! ");
    }

    public Connection connected(){
        return con;
    }

    public void closeConnection() throws SQLException{
        con.close();
        System.out.println("Connection Closed Successfully ! ");
    }

}
