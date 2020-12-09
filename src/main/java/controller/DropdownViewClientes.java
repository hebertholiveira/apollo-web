/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ModelApi.mApiClientes;
import ModelApi.mApiMcRetorno;
import ModelApi.mApiNegocios;
import ModelApi.mApiUsuario;
import ModelApi.mHeaders;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author big
 */
@ManagedBean(name = "BeanDropdownViewClientes")
@ViewScoped
public class DropdownViewClientes implements Serializable {

    private String IdCliente;
    private String idNegocio;
    private Map<String, String> Clientes;
    private Map<String, String> Negocios;
    Auxiliar aux = new Auxiliar();
    @PostConstruct
    public void init() {
        List<mHeaders> hd = new ArrayList<mHeaders>();
        
        mHeaders h = new mHeaders();
        h.setKey("user");
        h.setValue(String.valueOf(aux.GetUserID()));
        hd.add(h);
        h = new mHeaders();
        h.setKey("token");
        h.setValue(String.valueOf(aux.GetTokenSessao()));
        hd.add(h);
        mApiMcRetorno objRetorno = new ChamarApi().GetResquest_Api(new Auxiliar().getParameterWebConfig("apidefault"), hd, "/clientes_autorizado");
        
        if(objRetorno.getStatus() == 200)
        {
            Gson gson = new Gson();
            Type founderListType = new TypeToken<List<mApiClientes>>(){}.getType();
            List<mApiClientes> obj_ = gson.fromJson(objRetorno.getJsonmc(),founderListType);

            Clientes  = new HashMap<String, String>();
            obj_.forEach(v->
            {
                Clientes.put(v.getDescricao(), String.valueOf(v.getClienteID()));
            });
        }
    }

    public void carregarNegocios(String ClienteID)
    {
        List<mHeaders> hd = new ArrayList<mHeaders>();
        String gg=ClienteID;
        mHeaders h = new mHeaders();
        h.setKey("user");
        h.setValue(String.valueOf(aux.GetUserID()));
        hd.add(h);
        h = new mHeaders();
        h.setKey("token");
        h.setValue(String.valueOf(aux.GetTokenSessao()));
        hd.add(h);
        mApiMcRetorno objRetorno = new ChamarApi().GetResquest_Api(
                new Auxiliar().getParameterWebConfig("apidefault"), hd, "/negocios/" + IdCliente);
        
        if(objRetorno.getStatus() == 200)
        {
            Gson gson = new Gson();
            Type founderListType = new TypeToken<List<mApiNegocios>>(){}.getType();
            List<mApiNegocios> obj_ = gson.fromJson(objRetorno.getJsonmc(),founderListType);

            Negocios  = new HashMap<String, String>();
            obj_.forEach(v->
            {
                Negocios.put(v.getDescricao(), String.valueOf(v.getIdNegocio()));
            });
        }
    }

    public Map<String, String> getClientes() {
        return Clientes;
    }

    public Auxiliar getAux() {
        return aux;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Map<String, String> getNegocios() {
        return Negocios;
    }

    public void setNegocios(Map<String, String> Negocios) {
        this.Negocios = Negocios;
    }

    public String getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(String idNegocio) {
        this.idNegocio = idNegocio;
    }
    
    
}
