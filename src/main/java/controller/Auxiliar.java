/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.context.FacesContext;

/**
 *
 * @author big
 */
public class Auxiliar 
{
    public String getParameterWebConfig(String sContext_param)
    {
        FacesContext ctx = FacesContext.getCurrentInstance();
        return ctx.getExternalContext().getInitParameter(sContext_param);
    }
}
