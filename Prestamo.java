import java.util.ArrayList;

public class Prestamo {
	ArrayList<Sucursal> sucursales = new ArrayList<>();
	
	public Prestamo() {
		
	}
	
	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}
	public void agregarSucursal(Sucursal sucursal) {
		this.sucursales.add(sucursal);
	}
}