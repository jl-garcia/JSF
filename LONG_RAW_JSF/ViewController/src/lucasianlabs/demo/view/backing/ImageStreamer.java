package lucasianlabs.demo.view.backing;

import java.util.Iterator;

import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import luacsianlabs.demo.model.bo.CountryBO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class ImageStreamer {
    public ImageStreamer() {
        super();
    }

    private StreamedContent image;


    public void setImage(StreamedContent image) {
        this.image = image;
    }

    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("idImage");
            System.out.println("ID: " + id);
            image = CountryBO.getCountry(id, null).getImageFlag();
            return image;
        }
    }

}
