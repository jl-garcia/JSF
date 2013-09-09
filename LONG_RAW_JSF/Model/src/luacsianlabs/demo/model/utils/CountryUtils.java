package luacsianlabs.demo.model.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Blob;
import java.sql.SQLException;

import luacsianlabs.demo.model.dto.Country;

public class CountryUtils {
    public CountryUtils() {
        super();
    }

    public static void saveImage(String path, Country c, Blob bin) {
        FileOutputStream fos = null;
        System.out.println("euuuu paht: "+ path);
        File file = new File(path);
        InputStream inStream = null;
        try {
            fos = new FileOutputStream(file);
            inStream = bin.getBinaryStream();
            int size = (int)bin.length();
            byte[] buffer = new byte[size];
            int length = -1;
            while ((length = inStream.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException i) {
                }
            
            if (inStream != null)
                try {
                    inStream.close();
                } catch (IOException i) {
                }
        }
    }
    
    
    
    
    public static void saveImageB(String path, Country c, InputStream inStream) {
        int chunk;
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(path);
            while ((chunk = inStream.read()) != -1)
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
    }
}
