package com.example.lab10.Servelts;
import com.example.lab10.beans.Estadio;
import com.example.lab10.beans.Seleccion;
import com.example.lab10.daos.EstadioDao;
import com.example.lab10.daos.SeleccionDao;
import com.example.lab10.daos.JugadorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet(name = "EstadioServlet", value = "/EstadioServlet")
public class EstadioServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        EstadioDao estadioDao = new EstadioDao();

        switch (action){
            case "lista":
                //saca del modelo
                ArrayList<Estadio> list = estadioDao.listarEstadios();

                //mandar la lista a la vista -> job/lista.jsp
                request.setAttribute("lista",list);
                RequestDispatcher rd = request.getRequestDispatcher("listaEstadios.jsp");
                rd.forward(request,response);
                break;
            case "new":
                request.getRequestDispatcher("agregarEstadio.jsp").forward(request,response);
                break;
            case "del":
                String id1 = request.getParameter("id");
                try {
                    estadioDao.borrarEstadio(Integer.parseInt(id1));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect(request.getContextPath() + "/EstadioServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


        EstadioDao estadioDao = new EstadioDao();

        String action = request.getParameter("action") == null ? "otro" : request.getParameter("action");

        switch (action){
            case "crear"://voy a crear un nuevo estadio
                String nombre=request.getParameter("nombre");
                String provincia = request.getParameter("provincia");
                String club = request.getParameter("club");

                estadioDao.crearEstadio(nombre,provincia,club);
                response.sendRedirect(request.getContextPath() + "/EstadioServlet");
                break;

        }
    }
}
