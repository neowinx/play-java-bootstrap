package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Ciudad extends Model {

  private static final long serialVersionUID = 1L;

  @Id
  public Long id;

  public String nombre;

  @ManyToOne
  public Departamento departamento;

}