package com.example.lab10.beans;

public class Jugador {
    private int idJugador;
    private String nombre;
    private int edad;
    private String posicion;
    private String club;
    private int sn_idSelecion;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getSn_idSelecion() {
        return sn_idSelecion;
    }

    public void setSn_idSelecion(int sn_idSelecion) {
        this.sn_idSelecion = sn_idSelecion;
    }
}
