package luacsianlabs.demo.model.conn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

import oracle.net.aso.f;

import oracle.sql.BLOB;

public class ConnOracle {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "welcome1");

        return conn;
    }

    public static PreparedStatement getStatement(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("");

        return stmt;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            DriverManager.registerDriver(new OracleDriver());
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "welcome1");

            Statement stmt = conn.createStatement();

            //PreparedStatement pt = conn.prepareStatement("UPDATE COUNTRIES SET FLAG = ?, NAME_FLAG = ? WHERE COUNTRY_ID= ?");
            //PreparedStatement pt = conn.prepareStatement("SELECT * FROM COUNTRIES WHERE NAME_FLAG != 'null'");
            PreparedStatement pt = conn.prepareStatement("INSERT INTO COUNTRIES_BK " + "VALUES (?,?,?,?)");

            File fi = new File("C:\\Users\\Evaluacion\\Pictures\\flags\\china.gif");
            FileInputStream fis = new FileInputStream(fi);

            byte[] zipped = new byte[(int) fi.length()];
            //  fis.read(zipped);

            Long lo = new Long("00010203040506070809");
            int i = 1;
            pt.setString(i++, "CN");
            pt.setString(i++, "China");
            pt.setString(i++, fi.getName());
            pt.setBinaryStream(i++, fis, fi.length());

            //System.out.println("Resultado de la ejecucionnnn: " + pt.executeUpdate());

            ResultSet rs = pt.executeQuery();
            int k = 1;
            while (rs.next()) {
                System.out.println("RESUTADO: " + k++);
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
