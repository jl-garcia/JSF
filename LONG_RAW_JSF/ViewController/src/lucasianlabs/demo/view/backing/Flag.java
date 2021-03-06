package lucasianlabs.demo.view.backing;

import java.util.Collection;

import javax.faces.context.FacesContext;

import luacsianlabs.demo.model.dto.Country;
import luacsianlabs.demo.model.bo.CountryBO;
import luacsianlabs.demo.model.bo.CountryBOService;


public class Flag {

    private String img;
    private Country country;
    private Collection<Country> countryList;
    private CountryBOService servicioBO;

    public Flag() {
        servicioBO = new CountryBO();

    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }


    public void setCountryList(Collection<Country> countryList) {
        this.countryList = countryList;
    }

    public Collection<Country> getCountryList() {
        return servicioBO.getCountries(null);
    }
}
