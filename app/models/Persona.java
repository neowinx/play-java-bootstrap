package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Persona extends Model {

    private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
    public String nombre;
	
    public String apellido;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date fechaNacimiento;

  @OneToOne
  public Usuario usuario;

    public static Finder<Long,Persona> find = new Finder<Long,Persona>(Long.class, Persona.class);

    /**
     * Return a page of persona
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Persona property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page<Persona> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("nombre", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .findPagingList(pageSize)
                .setFetchAhead(false)
                .getPage(page);
    }

}