import java.util.Date;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int año;
    private Generos genero;
    private Date fechap;
    private Date fechad;
    private int vecesp = 0;
    
    public Libro() {
        
    }
    
    public Libro(String isbn, String titulo, String autor, int año, Generos genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.genero = genero;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getAño() {
        return año;
    }
    
    public void setAño(int año) {
        this.año = año;
    }
    
    public Generos getGenero() {
        return genero;
    }
    
    public void setGenero(Generos genero) {
        this.genero = genero;
    }
    
    public Date getFechaP() {
        return fechap;
    }
    
    public void setFechaP(Date fechap) {
        this.fechap = fechap;
    }
    
    public Date getFechaD() {
        return fechad;
    }
    
    public void setFechaD(Date fechad) {
        this.fechad = fechad;
    }
    
    public int getVecesP() {
        return vecesp;
    }
    
    public void incrementarVecesP() {
        this.vecesp++;
    }
}
