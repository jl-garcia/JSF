package lucasianlabs.demo.view.backing;

import java.io.IOException;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import luacsianlabs.demo.model.bo.CountryBO;
import luacsianlabs.demo.model.bo.CountryBOService;

import luacsianlabs.demo.model.dto.Country;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

public class FileUploadController {

    private CountryBOService servicioBO;
    
    
    
    


    public FileUploadController() {
        super();
        
        servicioBO = new CountryBO();
    }

    public void upload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        byte[] content = event.getFile().getContents();
        
        String idCountry = (String) event.getComponent().getAttributes().get("idCountry"); 
        String nameCountry = (String) event.getComponent().getAttributes().get("nameCountry"); 
        
        Country country = new Country(idCountry, nameCountry, event.getFile().getFileName());
         try {
            servicioBO.saveCountry(country, event.getFile().getInputstream(), event.getFile().getSize());
        } catch (IOException e) {
            e.printStackTrace();
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    
}
