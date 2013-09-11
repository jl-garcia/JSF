package luacsianlabs.demo.model.dao;

import java.io.InputStream;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.Collection;

import luacsianlabs.demo.model.dto.Country;

public interface CountryDaoService {
    public  void saveCountry(Connection conn, Country c, InputStream is, long fileLength);
    
    public  Country getCountry(Connection cn, String idCountry, String path);
    
    public  Collection<Country> getCountries(Connection cn, String path) throws SQLException;
}
