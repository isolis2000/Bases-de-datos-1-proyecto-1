package pojo;

public class SavingsAccountView {
    private int numeroCuentaAhorro, activado;
    private String descripcion, fechaInicio, fechaFin;

    public SavingsAccountView() {
    }

    public int getNumeroCuentaAhorro() {
        return numeroCuentaAhorro;
    }

    public void setNumeroCuentaAhorro(int numeroCuentaAhorro) {
        this.numeroCuentaAhorro = numeroCuentaAhorro;
    }

    public int getActivado() {
        return activado;
    }

    public void setActivado(int activado) {
        this.activado = activado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
