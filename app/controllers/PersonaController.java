package controllers;

import play.*;
import play.mvc.*;

import com.avaje.ebean.Page;

import java.util.List;

import views.html.*;

import models.Persona;

public class PersonaController extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	public static Result list(Integer page, Integer size, String filter){
		Page<Persona> personas = Persona.page(page, size, "nombre", "asc", filter);
		return ok(views.html.persona.list.render(personas));
	}

	public static Result edit(Long id){
		return ok("Insercion de Personas");
	}

	public static Result update(Long id){
		return ok("Edicion de Personas");
	}

}