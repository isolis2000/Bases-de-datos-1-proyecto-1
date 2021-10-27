package pojo;

public class AccountStatement {
    private String fechaInicio, fechaFinal;
    private int saldoMinimo, saldoInicio, saldoFinal, operacionesEnATM, operacionEnCajeroHumano;

    public AccountStatement() {
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

    public int getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(int saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public int getSaldoInicio() {
        return saldoInicio;
    }

    public void setSaldoInicio(int saldoInicio) {
        this.saldoInicio = saldoInicio;
    }

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public int getOperacionesEnATM() {
        return operacionesEnATM;
    }

    public void setOperacionesEnATM(int operacionesEnATM) {
        this.operacionesEnATM = operacionesEnATM;
    }

    public int getOperacionEnCajeroHumano() {
        return operacionEnCajeroHumano;
    }

    public void setOperacionEnCajeroHumano(int operacionEnCajeroHumano) {
        this.operacionEnCajeroHumano = operacionEnCajeroHumano;
    }
}
