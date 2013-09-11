package lucasianlabs.demo.view.backing;

import java.util.Collection;

import javax.faces.component.html.HtmlForm;

import luacsianlabs.demo.model.dto.Country;

import org.primefaces.event.FileUploadEvent;

public class FlagsPrimefaces {

    private String name;

    public FlagsPrimefaces() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

        public void upload(FileUploadEvent event) {
            System.out.println("nombreeee: "+ name);
        }

}
