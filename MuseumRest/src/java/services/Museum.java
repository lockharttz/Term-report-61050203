/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Oom
 */
@Path("museum")
public class Museum {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Museum
     */
    public Museum() {
    }

    /**
     * Retrieves representation of an instance of services.Museum
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
      try {
            URL url = new URL("https://opend.data.go.th/opend-search/vir_9377_1609457599/query?dsname=vir_9377_1609457599&path=vir_9377_1609457599&path=vir_9377_1609457599&loadAll=1&type=json&limit=100&offset=0");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            
            //adding header
            httpURLConnection.setRequestProperty("api-key","4vho8iA94poqDREjjrW1TIhSxPSBQTaF");

            String line="";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder response=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
          
          
            }
            bufferedReader.close();
            
            System.out.println("Response : "+response.toString());
            JSONObject jsonArray=new JSONObject(response.toString());
            System.out.println(jsonArray.toString(4));
            
          

            return jsonArray.toString(4) ;
        }
        catch (Exception e){
         
           System.out.println("Error in Making Get Request");
      
          return "Error im Get Request" ; 
    }
        
      
    }

    /**
     * PUT method for updating or creating an instance of Museum
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
