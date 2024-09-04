import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Prestamo prestamo = new Prestamo();
		String fecha = "";
        
        // Crear géneros
        Generos generos = new Generos();
        System.out.println("¿Cuántos géneros desea ingresar?");
        int cantidadGeneros = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < cantidadGeneros; i++) {
            System.out.print("Ingrese el nombre del género " + (i + 1) + ": ");
            String genero = scanner.nextLine();
            generos.agregarGenero(genero);
        }
        
        // Crear sucursales
        System.out.println("¿Cuántas sucursales desea crear?");
        int cantidadSucursales = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < cantidadSucursales; i++) {
            System.out.println("Ingrese los detalles de la sucursal " + (i + 1) + ":");
            System.out.print("Nombre de la sucursal: ");
            String nombreSucursal = scanner.nextLine();
            Sucursal sucursal = new Sucursal();
            sucursal.setNombre(nombreSucursal);
            
            // Crear libros
            ArrayList<Libro> libros = new ArrayList<>();
            System.out.println("Ingrese la cantidad de libros para esta sucursal:");
            int cantidadLibros = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < cantidadLibros; j++) {
                System.out.println("Ingrese los detalles del libro " + (j + 1) + ":");
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Año: ");
                int año = Integer.parseInt(scanner.nextLine());
                
                // Mostrar géneros y seleccionar uno por número
                System.out.println("Géneros disponibles:");
                ArrayList<String> listaGeneros = generos.getGeneros();
                for (int k = 0; k < listaGeneros.size(); k++) {
                    System.out.println((k + 1) + ". " + listaGeneros.get(k));
                }
                System.out.print("Seleccione el número del género del libro: ");
                int generoIndex = Integer.parseInt(scanner.nextLine()) - 1;
                String generoSeleccionado = listaGeneros.get(generoIndex);
                Generos genero = new Generos();
                genero.agregarGenero(generoSeleccionado);
                
                System.out.print("Fecha de publicación (dd/MM/yyyy): ");
				fecha = teclado.nextLine();
                try {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        fechap = formato.parse(fecha);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto.");
                        break;
                    }
                System.out.print("Fecha de donación (yyyy-mm-dd): ");
                fecha1 = teclado.nextLine();
                try {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        fechad = formato.parse(fecha1);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto.");
                        break;
                    }
                System.out.print("Veces prestado: ");
                int vecesp = Integer.parseInt(scanner.nextLine());
                
                Libro libro = new Libro(isbn, titulo, autor, año, genero, fechap, fechad, vecesp);
                libros.add(libro);
            }
            
            // Crear miembros
            ArrayList<Miembro> miembros = new ArrayList<>();
            System.out.println("Ingrese la cantidad de miembros para esta sucursal:");
            int cantidadMiembros = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < cantidadMiembros; j++) {
                System.out.println("Ingrese los detalles del miembro " + (j + 1) + ":");
                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                
                Miembro miembro = new Miembro();
                miembro.setId(id);
                miembro.setNombre(nombre);
                miembros.add(miembro);
            }
            
            // Agregar libros y miembros a la sucursal
            for (Libro libro : libros) {
                sucursal.agregarLibro(libro);
            }
            
            for (Miembro miembro : miembros) {
                sucursal.agregarMiembro(miembro);
            }
            
            prestamo.agregarSucursal(sucursal);
        }
        
        // Menú de opciones
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Generar reporte de libros prestados");
            System.out.println("2. Generar reporte de géneros más solicitados");
            System.out.println("3. Generar reporte del libro más prestado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1:
                    for (Sucursal sucursal : prestamo.getSucursales()) {
                        int cantidadLibrosPrestados = sucursal.cantidadLibrosP(sucursal.getLibrosP());
                        System.out.println("Sucursal: " + sucursal.getNombre() + " - Cantidad de libros prestados: " + cantidadLibrosPrestados);
                    }
                    break;
                case 2:
                    for (Sucursal sucursal : prestamo.getSucursales()) {
                        String generoMasSolicitado = sucursal.generosMasSolicitados(sucursal.getLibrosP());
                        System.out.println("Sucursal: " + sucursal.getNombre() + " - Género más solicitado: " + generoMasSolicitado);
                    }
                    break;
                case 3:
                    for (Sucursal sucursal : prestamo.getSucursales()) {
                        String libroMasPrestado = sucursal.libroMasPrestado(sucursal.getLibrosP());
                        System.out.println("Sucursal: " + sucursal.getNombre() + " - Libro más prestado: " + libroMasPrestado);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
        
        scanner.close();
    }
}
