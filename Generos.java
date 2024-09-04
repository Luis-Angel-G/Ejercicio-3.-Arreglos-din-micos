import java.util.ArrayList;

public class Generos {
	ArrayList<String> generos = new ArrayList<>();
	
	public ArrayList<String> getGeneros() {
		return generos;
	}
	public void agregarGenero(String genero) {
		this.generos.add(genero);
	}
}