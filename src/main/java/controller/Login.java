/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ModelApi.mApiMcRetorno;
import ModelApi.mApiUsuario;
import ModelApi.mHeaders;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.lang.reflect.Type;

/**
 *
 * @author big
 */
@ManagedBean(name = "BeanLogin")
@ViewScoped
public class Login implements Serializable
{
   private String User;
   private String Pass;
   private String RedirePage;
    @PostConstruct
    public void init() {
    
    }
    
    public String teste()
    {
        return RedirePage;
    }
    
    public void autenticar() throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
     
      try {
           List<mHeaders> hd = new ArrayList<mHeaders>();
           mHeaders h = new mHeaders();
           h.setKey("user");
           h.setValue(User);
           hd.add(h);
           h = new mHeaders();
           h.setKey("bak");
           h.setValue(Pass);
           hd.add(h);
           h = new mHeaders();
           h.setKey("bek");
           h.setValue(GetTokenUser());
           hd.add(h);
           
           mApiMcRetorno objRetorno = new ChamarApi().GetResquest_Api(new Auxiliar().getParameterWebConfig("apidefault"), hd, "/auth");
           
           if(objRetorno.getStatus() == 200)
           {
               //FacesContext.getCurrentInstance().getExternalContext().redirect("/dashboard.xhtml");
               RedirePage = "/dashboard.xhtml?faces-redirect=true";
               Gson gson = new Gson();
               Type founderListType = new TypeToken<mApiUsuario>(){}.getType();
               mApiUsuario obj_ = gson.fromJson(objRetorno.getJsonmc(),founderListType);
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AtivoID", obj_.getIdusuario());
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Token", obj_.getToken());

           }else{
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "401 - Não autorizado"));
           }
           Pass="";
       } catch (IOException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
    
    public String GetTokenUser() throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        StringBuilder sGuid = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("14dd10MMyyyyHH2020"); 
	Date date = new Date(); 
        sGuid.append(dateFormat.format(date));
        

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(sGuid.toString().getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString().toUpperCase();
        
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

  

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getRedirePage() {
        return RedirePage;
    }

    public void setRedirePage(String RedirePage) {
        this.RedirePage = RedirePage;
    }

   
  
    
  
}
