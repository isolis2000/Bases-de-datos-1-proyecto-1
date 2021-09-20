package pojo;

public class Beneficiary {
    private int cuentaAsociada, porcentaje;
    private String nombre, parentezco;

    public int getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void setCuentaAsociada(int cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }
}
