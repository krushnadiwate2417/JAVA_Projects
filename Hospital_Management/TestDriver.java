public class TestDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver FOUND!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
