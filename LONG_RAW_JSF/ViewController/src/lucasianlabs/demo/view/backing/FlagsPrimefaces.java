package lucasianlabs.demo.view.backing;

import java.util.Collection;

import javax.faces.component.html.HtmlForm;

import luacsianlabs.demo.model.dto.Country;

public class FlagsPrimefaces {

    private Collection<Country> countryList;

    public FlagsPrimefaces() {

    }

    public void setCountryList(Collection<Country> countryList) {
        this.countryList = countryList;
    }

    public Collection<Country> getCountryList() {
        return countryList;
    }


}
