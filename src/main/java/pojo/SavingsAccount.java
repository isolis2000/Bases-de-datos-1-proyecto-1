package pojo;

public class SavingsAccount {
    private int numeroCuenta, numeroCuentaAhorro, activado;
    private String descripcion, fechaInicio, fechaFinal;

    public SavingsAccount() {
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
