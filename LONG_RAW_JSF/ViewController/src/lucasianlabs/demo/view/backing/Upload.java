package lucasianlabs.demo.view.backing;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import luacsianlabs.demo.model.dto.Country;

import org.primefaces.model.UploadedFile;

public class Upload {
    
    private Country country;
    private UploadedFile file;
    private String name;

    public Upload() {
        super();
        country = new Country();
    }


    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void save(ActionEvent actionEvent) {
        //Persist user
        System.out.println("okoaksodaksod: "+ country.getCountryName());
        System.out.println("longitud del  archivo?: "+file.getContents());
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

}
