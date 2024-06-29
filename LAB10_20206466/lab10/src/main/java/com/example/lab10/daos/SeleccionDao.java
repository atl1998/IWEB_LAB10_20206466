package com.example.lab10.daos;


import com.example.lab10.beans.Estadio;
import com.example.lab10.beans.Jugador;
import com.example.lab10.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionDao {
    public ArrayList<Seleccion> listarSeleccion(){

        ArrayList<Seleccion> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "select * from seleccion";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seleccion sele = new Seleccion();
                sele.setIdSeleccion(rs.getInt(1));
                sele.setNombre(rs.getString(2));

                lista.add(sele);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

}
