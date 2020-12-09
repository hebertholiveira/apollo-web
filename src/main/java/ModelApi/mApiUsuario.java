/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelApi;

/**
 *
 * @author big
 */
public class mApiUsuario {
    private long idusuario;
    private String nome;
    private String login;
    private String token;
    private String Clientes;
    private String Departamentos;

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientes() {
        return Clientes;
    }

    public void setClientes(String Clientes) {
        this.Clientes = Clientes;
    }

    public String getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(String Departamentos) {
        this.Departamentos = Departamentos;
    }
    
    
}
