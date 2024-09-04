import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DriverProgram {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Prestamo prestamo = new Prestamo();
        
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
        ArrayList<Sucursal> sucursales = new ArrayList<>();
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
                
                Libro libro = new Libro(isbn, titulo, autor, año, genero);
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
                sucursal.agregarLibroD(libro);
            }
            
            for (Miembro miembro : miembros) {
                sucursal.agregarMiembro(miembro);
            }
            
            sucursales.add(sucursal);
        }
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Prestar Libro");
            System.out.println("2. Ver Estadísticas de Sucursal");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1:
                    prestarLibro(sucursales);
                    break;
                case 2:
                    verEstadisticas(sucursales);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        scanner.close();
    }
    
    private static void prestarLibro(ArrayList<Sucursal> sucursales) {
        System.out.println("Seleccione la sucursal:");
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println((i + 1) + ". " + sucursales.get(i).getNombre());
        }
        int sucursalIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Sucursal sucursal = sucursales.get(sucursalIndex);
        
        System.out.print("Ingrese el ISBN del libro que desea prestar: ");
        String isbn = scanner.nextLine();
        System.out.print("Ingrese el ID del miembro que solicita el libro: ");
        int miembroId = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese la fecha de prestado (dd/MM/yyyy): ");
        String fechaPrestadoStr = scanner.nextLine();
        System.out.print("Ingrese la fecha de devolución (dd/MM/yyyy): ");
        String fechaDevolucionStr = scanner.nextLine();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaPrestado = sdf.parse(fechaPrestadoStr);
            Date fechaDevolucion = sdf.parse(fechaDevolucionStr);
            Miembro miembro = sucursal.getMiembros().stream().filter(m -> m.getId() == miembroId).findFirst().orElse(null);
            if (miembro != null) {
                boolean prestado = sucursal.prestarLibro(isbn, miembro, fechaPrestado, fechaDevolucion);
                if (prestado) {
                    System.out.println("Libro prestado exitosamente.");
                } else {
                    System.out.println("El libro no está disponible.");
                }
            } else {
                System.out.println("Miembro no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al parsear las fechas.");
        }
    }
    
    private static void verEstadisticas(ArrayList<Sucursal> sucursales) {
        System.out.println("Seleccione la sucursal:");
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println((i + 1) + ". " + sucursales.get(i).getNombre());
        }
        int sucursalIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Sucursal sucursal = sucursales.get(sucursalIndex);
        
        System.out.println("Cantidad de libros prestados: " + sucursal.cantidadLibrosP());
        System.out.println("Género más solicitado: " + sucursal.generosMasSolicitados());
        System.out.println("Libro más prestado: " + sucursal.libroMasPrestado());
    }
}
