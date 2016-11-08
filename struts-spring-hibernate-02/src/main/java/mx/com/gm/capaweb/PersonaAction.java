package mx.com.gm.capaweb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capaservicio.PersonaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.h2.engine.User;

public class PersonaAction extends DispatchAction {

	// Atributo que será inyectado por Spring 
	private PersonaService personaService;

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	private static Log logger = LogFactory.getLog("PersonaAction");

	public ActionForward accionListar(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		logger.info("Ejecutando método listar");

		this.setListaPersonas(req);

		return mapping.findForward("listar");
	}

	private void setListaPersonas(HttpServletRequest req) {
		List<Persona> personas = this.personaService.listarPersonas();
		// Compartimos la lista de objetos persona con el JSP
		req.setAttribute("personas", personas);
		// Desplegamos solo para validar
		for (Persona persona : personas) {
			logger.info("Persona:" + persona);
			}
		}
	 
	}
