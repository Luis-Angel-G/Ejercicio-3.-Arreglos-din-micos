import java.util.ArrayList;

public class Generos {
	Arraylist<String> generos = new ArrayList<>();
	
	public ArrayList<String> getGeneros() {
		for (String i : generos) {
            return i;
        }
	}
	public void agregarGenero(String genero) {
		this.generos.add(genero);
	}
}