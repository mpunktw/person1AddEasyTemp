package auto.model;


import java.util.LinkedList;
import java.util.List;

public final class Person {
  private String svnr;
  private String nname;
  private String vname;
  private Double groesse;
  
  private static List<Person> catalog = new LinkedList<>();
  
  
  public Person() {
//    svnr = null;
//    nname = null;
//    vname = null;
//    gebDat = null;
//    geschlecht = null;
  }
  
  
  public String getSvnr() {
    return svnr;
  }
  
  public void setSvnr(String svnr) throws PersonException {
    if (svnr == null) {
      throw new PersonException("Sozialversicherungsnummer muss angegeben werden!");
    }
    
    if (!svnr.matches("[0-9]{4}[0-3][0-9][0-1][0-9][0-9]{2}")) {
      throw new PersonException("Sozialversicherungsnummer muss im Format nnnnttmmjj sein!");
    }
    
    this.svnr = svnr;
  }
  
  
  public String getNname() {
    return nname;
  }
  
  public void setNname(String nname) throws PersonException {
    if (nname == null) {
      throw new PersonException("Nachname muss angegeben werden!");
    }
    
    if (nname.length() < 2) {
      throw new PersonException("Nachname muss länger als 2 Zeichen sein!");
    }
    
    this.nname = nname;
  }
  
  
  public String getVname() {
    return vname;
  }
  
  
  public void setVname(String vname) throws PersonException {
    if (vname != null && vname.length() == 0) {
      vname = null;
    }
    
    if (vname != null && vname.length() < 2) {
      throw new PersonException("Wenn der Vorname angegeben wird, dann muss er länger als 2 Zeichen sein!");
    }
    
    this.vname = vname;
  }
  
  
  public Number getGroesse() {
    return groesse;
  }
  
  public void setGroesse(Double groesse) throws PersonException {
    if (groesse != null
        && (groesse < 0.5 || groesse > 2.5)) {
      throw new PersonException("Wenn die Größe angegeben wird, muss sie zwischen 0,5 m und 2,5 m sein ("
          + groesse + ")!");
    }
    
    this.groesse = groesse;
  }
  
  
  @Override
  public String toString() {
    return getSvnr() + "/"
        + getNname() + "/"
        + getVname() + "/"
        + getGroesse() + "/";
  }
  
  
  public void save() {
    catalog.add(this);
    System.out.println(catalog);
  }
}
