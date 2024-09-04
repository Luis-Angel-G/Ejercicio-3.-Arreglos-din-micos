import java.util.ArrayList;

public class Sucursal {
	private String nombre;
	ArrayList<Libro> libros = new ArrayList<>();
	ArrayList<Miembro> miembros = new ArrayList<>();
	ArrayList<Libro> librosd = new ArrayList<>();
	ArrayList<Libro> librosp = new ArrayList<>();
	
	public Sucursal() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(Sring nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void agregarLibro(Libro libro) {
		this.libros.add(libro);
	}
	public ArrayList<Miembro> getMiembros() {
		return miembros;
	}
	public void agregarMiembro(Miembro miembro) {
		this.miembros.add(miembro);
	}
	public ArrayList<Libro> getLibrosD() {
		return librosd;
	}
	public void agregarLibroD(Libro librod) {
		this.librosd.add(librod);
	}
	public ArrayList<Libro> getLibrosP() {
		return librosp;
	}
	public void agregarLibroP(Libro librop) {
		this.librosp.add(librop);
	}
	
	public int cantidadLibrosP(ArrayList<Libro> librosp) {
		return librosp.size();
	}
	
	public String generosMasSolicitados(ArrayList<Libro> librosp) {
		for (int i = 0; i < librosp.size(); i++) {
			if (librosp.get(i).getGenero().equals())
		}
	}
}