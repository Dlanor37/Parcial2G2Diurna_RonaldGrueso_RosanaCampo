/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_negocio;

/**
 *
 * @author 1110040741
 */
public class Contacto {
    
    // atributos
    private String Nombre;
    private int NumeroTelefono;
    // constructor no parametrizado
    public Contacto() {
    }
    // contructor parametrizado
    public Contacto(String Nombre, int NumeroTelefono) {
        this.Nombre = Nombre;
        this.NumeroTelefono = NumeroTelefono;
    }
    // setters y getters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(int NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    
}
