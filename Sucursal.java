import java.util.ArrayList;
import java.util.Date;

public class Sucursal {
    private String nombre;
    private ArrayList<Libro> librosd = new ArrayList<>();
    private ArrayList<Miembro> miembros = new ArrayList<>();
    private ArrayList<Libro> librosp = new ArrayList<>();
    
    public Sucursal() {}
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Libro> getLibrosD() {
        return librosd;
    }
    public void agregarLibroD(Libro libro) {
        this.librosd.add(libro);
    }
    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }
    public void agregarMiembro(Miembro miembro) {
        this.miembros.add(miembro);
    }
    public ArrayList<Libro> getLibrosP() {
        return librosp;
    }
    public void agregarLibroP(Libro libro) {
        this.librosp.add(libro);
    }
    
    public int cantidadLibrosP() {
        return librosp.size();
    }
    
    public String generosMasSolicitados() {
        ArrayList<String> generosUnicos = new ArrayList<>();
        ArrayList<Integer> conteoSolicitudes = new ArrayList<>();
        
        for (Libro libro : librosp) {
            for (String genero : libro.getGenero().getGeneros()) {
                if (generosUnicos.contains(genero)) {
                    int index = generosUnicos.indexOf(genero);
                    conteoSolicitudes.set(index, conteoSolicitudes.get(index) + 1);
                } else {
                    generosUnicos.add(genero);
                    conteoSolicitudes.add(1);
                }
            }
        }
        
        String generoMasSolicitado = null;
        int maxSolicitudes = 0;
        
        for (int i = 0; i < conteoSolicitudes.size(); i++) {
            if (conteoSolicitudes.get(i) > maxSolicitudes) {
                maxSolicitudes = conteoSolicitudes.get(i);
                generoMasSolicitado = generosUnicos.get(i);
            }
        }
        
        return generoMasSolicitado;
    }
    
    public String libroMasPrestado() {
        String libroMasPrestado = null;
        int maxVecesPrestado = 0;
        for (Libro libro : librosp) {
            if (libro.getVecesP() > maxVecesPrestado) {
                maxVecesPrestado = libro.getVecesP();
                libroMasPrestado = libro.getTitulo();
            }
        }
        return libroMasPrestado;
    }
    
    public boolean prestarLibro(String isbn, Miembro miembro, Date fechaPrestado, Date fechaDevolucion) {
        Libro libro = null;
        for (Libro l : librosd) {
            if (l.getIsbn().equals(isbn)) {
                libro = l;
                break;
            }
        }
        if (libro != null) {
            librosd.remove(libro);
            librosp.add(libro);
            libro.setFechaP(fechaPrestado);
            libro.setFechaD(fechaDevolucion);
            libro.incrementarVecesP = libro.getVecesP() + 1;
            miembro.agregarLibro(libro);
            return true;
        }
        return false;
    }
}
