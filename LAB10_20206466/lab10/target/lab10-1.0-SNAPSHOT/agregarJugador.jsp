<%@ page import="com.example.lab10.beans.Seleccion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.awt.image.AreaAveragingScaleFilter" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    ArrayList<Seleccion> listaSeleccion=(ArrayList<Seleccion>) request.getAttribute("listaSeleccion");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <title>Fichaje</title>
    </head>
    <body>
        <div class='container'>
            <h1 class='mb-3'>Fichar Jugador</h1>
            <form method="post" action="<%=request.getContextPath()%>/JugadorServlet?action=crear">
                <div class="mb-3">
                    <label>Nombre del jugador</label>
                    <input type="text" class="form-control" name="nombre">
                </div>
                <div class="mb-3">
                    <label>Edad del jugador</label>
                    <input type="text" class="form-control" name="edad">
                </div>
                <div class="mb-3">
                    <label>Posicion</label>
                    <input type="text" class="form-control" name="posicion">
                </div>
                <div class="mb-3">
                    <label>Club</label>
                    <input type="text" class="form-control" name="club">
                </div>
                <div class="mb-3">
                    <label for="idSeleccion">Seleccion</label>
                    <select name="idSeleccion" id="idSeleccion" class="form-control">
                        <option value="sin-seleccion">--sin-seleccion--</option>
                        <% for (Seleccion seleccion : listaSeleccion) { %>
                        <option value="<%= seleccion.getIdSeleccion() %>"><%= seleccion.getNombre() %></option>
                        <% } %>
                    </select>
                </div>
                <a href="<%=request.getContextPath()%>/JugadorServlet" class="btn btn-danger">Regresar</a>
                <button type="submit" class="btn btn-primary">Aceptar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
    </body>
</html>