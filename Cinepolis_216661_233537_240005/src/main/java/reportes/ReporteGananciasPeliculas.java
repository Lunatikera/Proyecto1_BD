package reportes;

public class ReporteGananciasPeliculas {
    private String ciudad;
    private String pelicula;
    private String genero;
    private String fecha;
    private double totalGananciaPorFecha;

    public ReporteGananciasPeliculas(String ciudad, String pelicula, String genero, String fecha, double totalGananciaPorFecha) {
        this.ciudad = ciudad;
        this.pelicula = pelicula;
        this.genero = genero;
        this.fecha = fecha;
        this.totalGananciaPorFecha = totalGananciaPorFecha;
    }

    // Getters y Setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalGananciaPorFecha() {
        return totalGananciaPorFecha;
    }

    public void setTotalGananciaPorFecha(double totalGananciaPorFecha) {
        this.totalGananciaPorFecha = totalGananciaPorFecha;
    }
}
