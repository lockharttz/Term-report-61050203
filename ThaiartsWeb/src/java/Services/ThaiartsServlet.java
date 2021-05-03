/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Oom
 */
public class ThaiartsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
            URL url = new URL("https://opend.data.go.th/opend-search/vir_9395_1609461035/query?dsname=vir_9395_1609461035&path=vir_9395_1609461035&path=vir_9395_1609461035&loadAll=1&type=json&limit=100&offset=0");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            
            //adding header
            httpURLConnection.setRequestProperty("type", "json");
            httpURLConnection.setRequestProperty("api-key","4vho8iA94poqDREjjrW1TIhSxPSBQTaF");

            String line="";
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder hey=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                hey.append(line);
          
          
            }
            bufferedReader.close();
            
            System.out.println("Response : "+hey.toString());
            JSONObject jsonArray=new JSONObject(hey.toString());
            System.out.println(jsonArray.toString(4));
            
          

            request.setAttribute("Thaiarts", jsonArray);
            request.getRequestDispatcher("Thaiarts.jsp").forward(request, response);
           
        }
        catch (Exception e){
         
           System.out.println("Error in Making Get Request");
            
      
            request.setAttribute("Thaiarts", "Error in Making Get Request");
            request.getRequestDispatcher("Thaiarts.jsp").forward(request, response);
    }
       
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
