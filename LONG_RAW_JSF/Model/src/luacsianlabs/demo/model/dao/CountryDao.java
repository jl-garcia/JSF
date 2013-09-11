package luacsianlabs.demo.model.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collection;

import luacsianlabs.demo.model.utils.CountryUtils;
import luacsianlabs.demo.model.conn.ConnOracle;

import luacsianlabs.demo.model.dto.Country;

import oracle.net.aso.e;

import oracle.sql.BLOB;
import oracle.sql.RAW;

import org.primefaces.model.DefaultStreamedContent;

public class CountryDao implements CountryDaoService{
    public  void saveCountry(Connection conn, Country c, InputStream is, long fileLength) {
        PreparedStatement pt = null;
        int i = 1;
        try {
            pt = conn.prepareStatement("INSERT INTO COUNTRIES " + "VALUES (?,?,?,?)");
            pt.setString(i++, c.getCountryId());
            pt.setString(i++, c.getCountryName());
            pt.setString(i++, c.getFlag());
            pt.setBinaryStream(i++, is, fileLength);

            System.out.println("Numero de registros insertados: "+pt.executeUpdate());                        
        } catch (SQLException f) {
            f.printStackTrace();
        } finally{
            try {
                pt.close();
            } catch (SQLException f) {
                f.printStackTrace();
            }
        }
    }

    /**
     *
     * @param cn
     * @param idCountry
     * @param path
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public  Country getCountry(Connection cn, String idCountry, String path) {
        Country c = new Country();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from COUNTRIES WHERE COUNTRY_ID = '" + idCountry + "'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                c.setCountryName(rs.getString("COUNTRY_NAME"));
                c.setCountryId(rs.getString("COUNTRY_ID"));
                c.setFlag(rs.getString("NAME_FLAG"));
                String pathname = path + "\\" + c.getFlag();
                c.setPath(pathname);
                //Blob bin = rs.getBlob("FLAG");

                //  InputStream iss = rs.getBinaryStream("FLAG");
                InputStream iss = new ByteArrayInputStream(rs.getBytes("FLAG"));
                // System.out.println("OKOKOKOKOK: "+ iss);
                // InputStream inStream = bin.getBinaryStream();
                c.setImageFlag(new DefaultStreamedContent(iss, "image"));
                //CountryUtils.saveImage(pathname, c, bin);

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
            rs = null;
            st = null;
        }
        return c;
    }

    public  Collection<Country> getCountries(Connection cn, String path) throws SQLException {
        Collection<Country> listCountries = null;
        Country c = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM COUNTRIES WHERE NAME_FLAG != 'null'";
        try {
            st = cn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            listCountries = new ArrayList<Country>();

            int res = 1;
            while (rs.next()) {
                System.out.println("HAY RESULTADOS: " + res++);
                c = new Country();
                c.setCountryName(rs.getString("COUNTRY_NAME"));
                c.setCountryId(rs.getString("COUNTRY_ID"));
                c.setFlag(rs.getString("NAME_FLAG"));
                String pathname = path + "\\" + c.getFlag();
                c.setPath(pathname);
                InputStream iss = new ByteArrayInputStream(rs.getBytes("FLAG"));
                c.setImageFlag(new DefaultStreamedContent(iss, "image", c.getCountryName()));
                CountryUtils.saveImageB(pathname, c, iss);
                listCountries.add(c);
            }
        } finally {

            if (st != null)
                try {
                    st.close();
                } catch (SQLException sqlEx) {
                }
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
            rs = null;
            st = null;
        }
        return listCountries;
    }


    public  Country getCountryDemo(Connection cn, String idCountry, String path) {
        Country c = new Country();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from COUNTRIES WHERE COUNTRY_ID = '" + idCountry + "'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                c.setCountryName(rs.getString("COUNTRY_NAME"));
                c.setCountryId(rs.getString("COUNTRY_ID"));
                c.setFlag(rs.getString("NAME_FLAG"));
                String pathname = path + "\\" + c.getFlag();
                c.setPath(pathname);
                //               Blob bin = rs.getBlob("FLAG");
                //InputStream inStream = bin.getBinaryStream();
                //InputStream inStream = rs.getBinaryStream("FLAG");
                InputStream iss = new ByteArrayInputStream(rs.getBytes("FLAG"));
                System.out.println("PROBANDO:............ " + iss);

                c.setImageFlag(new DefaultStreamedContent(iss, "image"));

                int chunk;
                FileOutputStream file = null;
                try {
                    file = new FileOutputStream("C:\\Users\\Evaluacion\\Desktop\\MEX.jpg");
                    while ((chunk = iss.read()) != -1)
                        file.write(chunk);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (file != null) {
                        try {
                            file.close();
                        } catch (IOException e) {
                        }
                    }
                }
                //CountryUtils.saveImageB(pathname, c, inStream,);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
            rs = null;
            st = null;
        }
        return c;
    }


}
