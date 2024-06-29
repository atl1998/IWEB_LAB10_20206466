package com.example.lab10.Servelts;
import com.example.lab10.beans.Jugador;
import com.example.lab10.beans.Seleccion;
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
@WebServlet(name = "JugadorServlet", value = "/JugadorServlet")
public class JugadorServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        switch (action){
            case "lista":
                //saca del modelo
                ArrayList<Jugador> list = jugadorDao.listarJugadores();

                //mandar la lista a la vista -> job/lista.jsp
                request.setAttribute("lista",list);
                RequestDispatcher rd = request.getRequestDispatcher("listaJugadores.jsp");
                rd.forward(request,response);
                break;
            case "new":
                ArrayList<Seleccion> list1 = seleccionDao.listarSeleccion();
                request.setAttribute("listaSeleccion",list1);
                request.getRequestDispatcher("agregarJugador.jsp").forward(request,response);
                break;
            case "del":
                String id1 = request.getParameter("id");
                JugadorDao jugador1 = jugadorDao;

                if(jugador1 != null){
                    try {
                        jugadorDao.borrar(Integer.parseInt(id1));
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/JugadorServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


        JugadorDao jugadorDao = new JugadorDao();

        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        switch (action){
            case "crear"://voy a crear un nuevo trabajo
                String nombreJugador=request.getParameter("nombre");
                String edadJugador = request.getParameter("edad");
                String posicionJugador= request.getParameter("posicion");
                String clubJugador = request.getParameter("club");
                String seleccion = request.getParameter("idSeleccion");

                jugadorDao.crearJugador(nombreJugador,Integer.parseInt(edadJugador),posicionJugador,clubJugador, Integer.parseInt(seleccion));
                response.sendRedirect(request.getContextPath() + "/JugadorServlet");
                break;
            case "e": //voy a actualizar
                String id2=request.getParameter("id");
                String nombre2 = request.getParameter("nombre");
                String edad2 = request.getParameter("edad");
                String posicion2 = request.getParameter("posicion");
                String club2 = request.getParameter("club");
                String seleccion2 = request.getParameter("seleccion");

                boolean isAllValid2 = true;

                if(isAllValid2){
                    Jugador player = new Jugador();
                    player.setNombre(nombre2);
                    player.setEdad(Integer.parseInt(edad2));
                    player.setPosicion(posicion2);
                    player.setClub(club2);
                    player.setSn_idSelecion(Integer.parseInt(seleccion2));

                    jugadorDao.actualizar(player);
                    response.sendRedirect(request.getContextPath() + "/JugadorServlet");
                }else{
                    request.setAttribute("jugador",jugadorDao.buscarPorId(Integer.parseInt(id2)));
                    request.getRequestDispatcher("agregarJugador.jsp").forward(request,response);
                }
                break;
        }
    }
}
