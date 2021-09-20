package pojo;

public class Account {
    private String usuario, pass;
    private int valorDocumentoIdentidad, esAdministrador;

    public Account() {
    }

    public Account(String usuario, String pass, int valorDocumentoIdentidad, int esAdministrador) {
        this.usuario = usuario;
        this.pass = pass;
        this.valorDocumentoIdentidad = valorDocumentoIdentidad;
        this.esAdministrador = esAdministrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getValorDocumentoIdentidad() {
        return valorDocumentoIdentidad;
    }

    public void setValorDocumentoIdentidad(int valorDocumentoIdentidad) {
        this.valorDocumentoIdentidad = valorDocumentoIdentidad;
    }

    public int getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(int esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
}
