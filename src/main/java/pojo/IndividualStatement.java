package pojo;

public class IndividualStatement {
    private String descripcion, moneda, fecha;
    private int operacion, venta, compra, montoMonedaMovimiento, montoMonedaCuenta, nuevoSaldo;

    public IndividualStatement() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getMontoMonedaMovimiento() {
        return montoMonedaMovimiento;
    }

    public void setMontoMonedaMovimiento(int montoMonedaMovimiento) {
        this.montoMonedaMovimiento = montoMonedaMovimiento;
    }

    public int getMontoMonedaCuenta() {
        return montoMonedaCuenta;
    }

    public void setMontoMonedaCuenta(int montoMonedaCuenta) {
        this.montoMonedaCuenta = montoMonedaCuenta;
    }

    public int getNuevoSaldo() {
        return nuevoSaldo;
    }

    public void setNuevoSaldo(int nuevoSaldo) {
        this.nuevoSaldo = nuevoSaldo;
    }
}
