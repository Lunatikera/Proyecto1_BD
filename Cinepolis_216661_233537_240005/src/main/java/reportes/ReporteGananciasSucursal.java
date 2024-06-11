package reportes;

public class ReporteGananciasSucursal {
    private String sucursal;
    private String dia;
    private int cantidadFunciones;
    private double totalGananciaPorFecha;

    public ReporteGananciasSucursal(String sucursal, String dia, int cantidadFunciones, double totalGananciaPorFecha) {
        this.sucursal = sucursal;
        this.dia = dia;
        this.cantidadFunciones = cantidadFunciones;
        this.totalGananciaPorFecha = totalGananciaPorFecha;
    }

    public String getSucursal() {
        return sucursal;
    }

    public String getDia() {
        return dia;
    }

    public int getCantidadFunciones() {
        return cantidadFunciones;
    }

    public double getTotalGananciaPorFecha() {
        return totalGananciaPorFecha;
    }
}
