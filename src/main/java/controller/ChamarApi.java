/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ModelApi.mApiMcRetorno;
import ModelApi.mHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
/**
 *
 * @author big
 */
public class ChamarApi {
    public mApiMcRetorno GetResquest_Api(String sUrl, List<mHeaders> Parametros, String sMetodo)
    {
       mApiMcRetorno ret = new mApiMcRetorno();
       StringBuilder Retorno= new StringBuilder();
        try {
            URL url = new URL(sUrl+sMetodo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            Parametros.forEach(v->
                {
                    conn.setRequestProperty(v.getKey(), v.getValue());
                });

            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() != 200) {
                ret.setStatus(conn.getResponseCode());
                conn.disconnect();
               /* throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());*/
            }
            ret.setStatus(conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            
            String output;
            
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                Retorno.append(output);
            }
            
            conn.disconnect();
            ret.setJsonmc(Retorno.toString());
        } catch (MalformedURLException ex) {
            //Logger.getLogger(ChamarApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            //Logger.getLogger(ChamarApi.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            //Logger.getLogger(ChamarApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Logger.getLogger(ChamarApi.class.getName()).log(Level.SEVERE, null, ex);
        return ret;
    }
    
}
