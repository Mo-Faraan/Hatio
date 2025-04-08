import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pass = "farhantm@123";
        String query = "insert into student values (?,?,?)";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,user,pass);
        System.out.println("connection established");
        // Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery(query);
        // rs.next();
        // String nm = rs.getString("sname");
        // System.out.println(nm);

        // while (rs.next()){
        //     System.out.print(rs.getInt(1));
        //     System.out.print(rs.getString(2));
        //     System.out.println(rs.getInt(3));
        // }

        // st.execute(query);

        int id = 6;
        String nm = "farhan";
        int mrk = 99;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.setString(2, nm);
        ps.setInt(3,mrk);
        ps.execute();
        con.close();
    }
}
