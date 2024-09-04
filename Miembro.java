import java.util.ArrayList;

public class Miembro {
    private int id;
    private String nombre;
    private ArrayList<Libro> librospm = new ArrayList<>();
    
    public Miembro() {
        
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Libro> getLibrosPM() {
        return librospm;
    }
    
    public void agregarLibro(Libro libro) {
        this.librospm.add(libro);
    }
}
