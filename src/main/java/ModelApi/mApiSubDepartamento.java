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
public class mApiSubDepartamento {
     private long idSudDepartamento;
    private String descricao;
    private long idDepartamento;

    public long getIdSudDepartamento() {
        return idSudDepartamento;
    }

    public void setIdSudDepartamento(long idSudDepartamento) {
        this.idSudDepartamento = idSudDepartamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
