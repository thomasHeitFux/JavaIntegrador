package Clases;

public abstract class Operacion {
    private double monto;
    private String fecha;

    private String categoria;

    public Operacion() {
    }

    public Operacion(double monto, String fecha, String categoria) {
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
