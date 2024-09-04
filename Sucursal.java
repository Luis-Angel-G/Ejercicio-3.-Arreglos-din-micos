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
	public void setNombre(String nombre) {
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
	
	public String libroMasPrestado (ArrayList<Libro> librosp) {		
		String libromasprestado = null;
		int libromasp = 0;
		for (Libro libro : librosp) {
			if (libro.getVecesP() > libromasp) {
				libromasp = libro.getVecesP();
				libromasprestado = libro.getTitulo();
			}
		}
		return libromasprestado;
	}
}