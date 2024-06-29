package com.example.lab10.daos;

import com.example.lab10.beans.Estadio;
import com.example.lab10.beans.Jugador;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDao {
    public ArrayList<Estadio> listarEstadios(){

        ArrayList<Estadio> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "select * from estadio";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                estadio.setProvincia(rs.getString(3));
                estadio.setClub(rs.getString(4));

                lista.add(estadio);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
    public void crearEstadio(String nombre, String provincia, String club){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "insert into jugador (nombre,provincia,club) values (?,?,?)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,nombre);
            pstmt.setString(2,provincia);
            pstmt.setString(3,club);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrarEstadio(int estadioId) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab7";
        String username = "root";
        String password = "root";

        String sql = "delete from estadio where idEstadio = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setInt(1,estadioId);
            pstmt.executeUpdate();

        }
    }
}
