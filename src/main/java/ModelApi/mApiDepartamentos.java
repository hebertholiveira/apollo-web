/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelApi;

import java.util.List;

/**
 *
 * @author big
 */
public class mApiDepartamentos {
     private long idDepartamentos;
    private String descricao;
    private List<mApiSubDepartamento> SubDepartamento;

    public long getIdDepartamentos() {
        return idDepartamentos;
    }

    public void setIdDepartamentos(long idDepartamentos) {
        this.idDepartamentos = idDepartamentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<mApiSubDepartamento> getSubDepartamento() {
        return SubDepartamento;
    }

    public void setSubDepartamento(List<mApiSubDepartamento> SubDepartamento) {
        this.SubDepartamento = SubDepartamento;
    }
}
