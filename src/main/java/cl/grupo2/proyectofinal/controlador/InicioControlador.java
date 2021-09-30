package cl.grupo2.proyectofinal.controlador;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class InicioControlador {
		
		@RequestMapping(value="/", method = RequestMethod.GET)
		public String inicio() {
			return "inicio";
		}
		
		@RequestMapping(value="/cerrarsesion", method = RequestMethod.GET)
		public String cerrarSesion() {
			return "logout";
		}
		
		@RequestMapping("/error")
	    public String error(ModelMap model)
	    {
	        model.addAttribute("error", "true");
	        return "login";
	    }

	    @RequestMapping("/login")
	    public String login()
	    {
	        return "login";
	    }
	    
	    @RequestMapping("/logout")
	    public String logout()
	    {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	        SecurityContextHolder.getContext().setAuthentication(null);
	        }
	        return "redirect:/login?logout"; 
	    }
	    
	    @RequestMapping("/menuInicio")
	    public String validarsesion() {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String nombre = auth.getName();
	        if(nombre.equalsIgnoreCase("saul")) {

	            return "sesionCliente";

	        }else if (nombre.equalsIgnoreCase("jorge")) {
	            return "sesionAdministrativo";
	        }
	        else if (nombre.equalsIgnoreCase("anton")){
	            return "sesionProfesional"; 
	        }else {

	             
	           return "login";

	        }
	    }
	    
	    @RequestMapping("/customAaccessDenied")
	    public String Forbidden() {
			return "accesDenied";
	    	
	    }
}
