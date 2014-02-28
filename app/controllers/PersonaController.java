package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import com.avaje.ebean.Page;

import java.util.List;

import views.html.*;

import play.i18n.Messages;

import models.Persona;

public class PersonaController extends Controller {

  public static Result GO_HOME = redirect(
    routes.PersonaController.list(0, 5, "nombre", "")
  );

  public static Result index() {
    return ok(index.render());
  }

  public static Result list(Integer page, Integer size, String sortBy, String filter){
    Page<Persona> personas = Persona.page(page, size, sortBy, "asc", filter);
    return ok(views.html.persona.list.render(personas, sortBy));
  }

  public static Result create() {
    Form<Persona> personaForm = form(Persona.class);
    return ok(
      views.html.persona.edit.render(null, personaForm)
    );
  }

  public static Result edit(Long id){
    Form<Persona> personaForm = form(Persona.class).fill(
      Persona.find.byId(id)
    );
    return ok(
      views.html.persona.edit.render(id, personaForm)
    );
  }

  public static Result update(Long id){
    Form<Persona> personaForm = form(Persona.class).bindFromRequest();
    if(personaForm.hasErrors()) {
      return badRequest(views.html.persona.edit.render(id, personaForm));
    }
    if(id == null)
      personaForm.get().save();
    else
      personaForm.get().update(id);
    flash("success", Messages.get("persona_") + " " + Messages.get("msg_entity_updated"));
    return GO_HOME;
  }

  public static Result delete(Long id) {
      Persona.find.ref(id).delete();
      flash("success", Messages.get("persona_") + " " + Messages.get("msg_entity_updated"));
      return GO_HOME;
  }

}