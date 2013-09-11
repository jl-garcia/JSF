package luacsianlabs.demo.model.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Collection;

import luacsianlabs.demo.model.dao.CountryDao;
import luacsianlabs.demo.model.conn.ConnOracle;
import luacsianlabs.demo.model.dao.CountryDaoService;
import luacsianlabs.demo.model.dto.Country;

public class CountryBO implements CountryBOService {
    private CountryDaoService servicioDao;
    
    public CountryBO (){
            servicioDao = new CountryDao();
        }
    
    
    public void saveCountry(Country country, InputStream is, long fileLenght) {
        Connection conn = null;
        try {
            conn = ConnOracle.getConnection();
            servicioDao.saveCountry(conn, country,  is,  fileLenght);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Country getCountry(String id, String path) {
        if (path == null)
            path =
                "G:\\CourseWebCenter\\system12.1.2.0.40.66.68\\o.j2ee\\drs\\Application1\\ViewControllerWebApp.war\\images";
        Country c = new Country();
        try {
            Connection conn = ConnOracle.getConnection();
            c = servicioDao.getCountry(conn, id, path);
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
    public Collection<Country> getCountries(String path) {
        Collection<Country> listCountries = null;
        Connection conn = null;
        //Ruta de las imagenes del proyecto web
        if (path == null)
            path =
                "G:\\CourseWebCenter\\mywork\\DemoJSF\\LONG_RAW_JSF\\ViewController\\public_html\\images";
        try {
            conn = ConnOracle.getConnection();
            listCountries = servicioDao.getCountries(conn, path);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCountries;
    }

    public byte[] getByteImagen(String imagePath) {
        File fi = new File(imagePath);
        try {
            FileInputStream fis = new FileInputStream(fi);
        } catch (FileNotFoundException e) {
            FileInputStream fis;
            e.printStackTrace();
        }

        byte[] zipped = new byte[(int) fi.length()];

        return zipped;
    }

    private  String getNameImage(String imagePath) {
        File fi = new File(imagePath);
        String name = fi.getName();

        if (name != null) {
            return name;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("PROBANDO");
    }

}
