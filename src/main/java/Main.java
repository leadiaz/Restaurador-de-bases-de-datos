import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) {
        String url = "jdbc:jtds:sqlserver://";
        String server  = "192.168.200.141:1433/";
        String database = args + ";instance=DESARROLLO_2017";
        String drives = ";tds=8.0;lastupdatecount=true";
        String passUser = "user=sa;password=clave_2017";

        String connectionUrl = url + server + database + drives;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "sa", "clave_2017");
            String query = "select top(10)* from Fafusuarios";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if(con != null){

                System.out.println("connection successful!!!");

                while (res.next() ){
                    System.out.println(res.getString("name"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}