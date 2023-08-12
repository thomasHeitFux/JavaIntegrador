package Clases;

public class Ingreso extends Operacion{
    private String categoria;

    public Ingreso(String categoria) {
        this.categoria = categoria;
    }

    public Ingreso(double monto, String fecha, String categoria) {
        super(monto, fecha);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
