<%-- 
    Document   : Museum
    Created on : 03-May-2021, 17:46:32
    Author     : Oom
--%>

<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Museum</title>
    </head>
    <body>
     <%   JSONObject dat= (JSONObject)request.getAttribute("Museum");
            JSONArray jArrDat =  dat.getJSONArray("data");
        %>
        <table border="1">
     <thread>
          <tr>
            <th>ลำดับ</th>
            <th>Title</th>
            <th>Subject</th>
            <th>Spatial</th>
            <th>Type</th>
          </tr></thread>
          <%for (int i=0;i<jArrDat.length();i++){%>
          <tr>
          <form name="AddToCart"action="AddToCart" method="POST">
              <td><%= jArrDat .getJSONObject(i).getString("ลำดับ") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("title") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("subject") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("type") %></td>
              <td><%= jArrDat .getJSONObject(i).getString("spatial") %></td>
          </form>
          </tr>
          <%
               }
          %>
    </table>
    </body>
</html>
