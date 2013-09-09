package luacsianlabs.demo.model.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Collection;

import luacsianlabs.demo.model.dao.CountryDao;
import luacsianlabs.demo.model.conn.ConnOracle;
import luacsianlabs.demo.model.dto.Country;

public class CountryBO {
    public static void saveCountry() {
        CountryDao.saveCountry(new Country("MX", "MEXICO", "mexico.jpg"),
                               getByteImagen("C:\\Users\\Evaluacion\\Pictures\\mexico.jpg"));
    }

    public static Country getCountry(String id, String path) {
        if (path == null)
            path ="G:\\CourseWebCenter\\system12.1.2.0.40.66.68\\o.j2ee\\drs\\Application1\\ViewControllerWebApp.war\\images";
        Country c = new Country();
        try {
            Connection conn = ConnOracle.getConnection();
            c = CountryDao.getCountry(conn, id, path);
            System.out.println("Nombre: " + c.getCountryName());
            System.out.println("Flag: " + c.getFlag());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    /**
     *
     * @param id
     * @param path
     * @return
     */
    public static Collection<Country> getCountries(String path) {
        Collection<Country> listCountries = null;
        Connection conn = null;
        //Ruta de las imagenes del proyecto web
        if (path == null)
            path = "G:\\CourseWebCenter\\system12.1.2.0.40.66.68\\o.j2ee\\drs\\Application1\\ViewControllerWebApp.war\\images";
        try {
            conn = ConnOracle.getConnection();
            listCountries = CountryDao.getCountries(conn, path);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listCountries;
    }

    public static byte[] getByteImagen(String imagePath) {
        File fi = new File(imagePath);
        try {
            FileInputStream fis = new FileInputStream(fi);
        } catch (FileNotFoundException e) {
            FileInputStream fis;
            e.printStackTrace();
        }

        byte[] zipped = new byte[(int)fi.length()];

        return zipped;
    }

    private static String getNameImage(String imagePath) {
        File fi = new File(imagePath);
        String name = fi.getName();

        if (name != null) {
            return name;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("PROBANDO");
        saveCountry();
        //getCountry("4", "C:\\Users\\Evaluacion\\Pictures\\tmp");
    }
}
