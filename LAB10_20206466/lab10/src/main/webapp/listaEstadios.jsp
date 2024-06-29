<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab10.beans.Estadio" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" scope="request" type="ArrayList<com.example.lab10.beans.Estadio>"/>
<html>
    <head>
        <title>Jugadores</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="clearfix mt-3 mt-2">
                <a href="<%=request.getContextPath()%>/EstadioServlet">
                    <h1 class="float-start link-dark">Lista de Estadios</h1>
                </a>
                <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/EstadioServlet?action=new">Crear estadio</a>
            </div>
            <hr/>
            <table class="table table-striped mt-3">
                <tr class="table-primary">
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Provincia</th>
                    <th>Club</th>
                </tr>
                <% for (Estadio estadio : lista) { %>
                <tr>
                    <td><%=estadio.getIdEstadio() %>
                    </td>
                    <td><%=estadio.getNombre()%>
                    </td>
                    <td><%=estadio.getProvincia()%>
                    </td>
                    <td><%=estadio.getClub()%>
                    </td>
                    <td><a onclick="return confirm('¿Esta seguro de borrar?')" class="btn btn-danger" href="<%=request.getContextPath()%>/EstadioServlet?action=del&id=<%=estadio.getIdEstadio() %>">Borrar</a></td>
                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>
