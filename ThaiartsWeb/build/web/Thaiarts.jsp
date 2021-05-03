<%-- 
    Document   : Thaiarts
    Created on : 03-May-2021, 18:19:43
    Author     : Oom
--%>

<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thaiarts Data</title>
    </head>
    <body>
       <%   JSONObject dat= (JSONObject)request.getAttribute("Thaiarts");
            JSONArray jArrDat =  dat.getJSONArray("data");
        %>
        <table border="1">
     <thread>
          <tr>
            <th>ลำดับ</th>
            <th>Title</th>
            <th>Subject</th>
            <th>Description</th>
            <th>Spatial</th>
            <th>Type</th>
            <th>Rights</th>
          </tr></thread>
          <%for (int i=0;i<jArrDat.length();i++){%>
          <tr>
          <form name="AddToCart"action="AddToCart" method="POST">
              <td><%= jArrDat .getJSONObject(i).getString("ลำดับ") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("title") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("subject") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("type") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("spatial") %></td>
               <td><%= jArrDat .getJSONObject(i).getString("description") %></td>
               <td><%= jArrDat .getJSONObject(i).getString("rights") %></td>
          </form>
          </tr>
          <%
               }
          %>
    </table>
    </body>
</html>
