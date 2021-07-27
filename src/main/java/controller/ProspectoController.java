
package controller;

import gestion.ProspectoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Prospecto;


@Named(value = "prospectoController")
@SessionScoped
public class ProspectoController extends Prospecto implements Serializable {

    
    public ProspectoController() {
    }
    
    public String inserta (){
        
        if (ProspectoGestion.insertar(this)){
            
            return "confirmacion.xhtml";
            
        }else {
            
            FacesMessage mensaje = new FacesMessage (FacesMessage.SEVERITY_ERROR, "Error",
                    "Posible cédula duplicada...");
            FacesContext.getCurrentInstance().addMessage("registroProspectoForm:cedula", mensaje);
            return "registro.xhtml";
            
        }
        
        
        
    }
    
}
