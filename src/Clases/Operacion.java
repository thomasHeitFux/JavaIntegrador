package Clases;

public abstract class Operacion {
    private double monto;
    private String fecha;

    public Operacion() {
    }

    public Operacion(double monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
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
}
