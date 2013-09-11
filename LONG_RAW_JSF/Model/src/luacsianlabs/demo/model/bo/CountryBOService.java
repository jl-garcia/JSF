package luacsianlabs.demo.model.bo;

import java.io.InputStream;

import java.util.Collection;

import luacsianlabs.demo.model.dto.Country;

public interface CountryBOService {
    
    public void saveCountry(Country country, InputStream is, long fileLenght);
    
    public  Country getCountry(String id, String path);
    
    public  Collection<Country> getCountries(String path);
    
    public  byte[] getByteImagen(String imagePath);
}
