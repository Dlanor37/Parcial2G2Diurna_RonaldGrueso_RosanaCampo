/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_negocio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1110040741
 */

public class Principal {

    /**
     * @param args the command line arguments
     */
    
    // creacion de array y scanner
   private ArrayList<Contacto> listaContactos;
    private Scanner scanner;
// contructor 
    public Principal() {
        listaContactos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Principal app = new Principal();
        app.mostrarMenu();
    }

    public void mostrarMenu() {
        
        // creación de menu
        int opcion;
        do {
            System.out.println("****** Zona Virtual S.A.********");
            System.out.println("******* Aplicación de Lista de Contactos ********");
            System.out.println("1. Agregar un Nuevo Contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja a partir de los nombres");
            System.out.println("5. Ordenar por Inserción a partir de los números Telefónicos");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarListaContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    ordenarBurbujaNombres();
                    break;
                case 5:
                    ordenarInsercionNumeros();
                    break;
                case 6:
                    System.out.println("cerrando..");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion!= 6);
    }
    // metodo para agregar contactos
    public void agregarContacto() {
        System.out.println("Ingrese el nombre del contacto:");
        scanner.nextLine(); 
        String nombre =scanner.nextLine();
        System.out.println("Ingrese el número de teléfono:");
        int numeroTelefono=scanner.nextInt();

        Contacto contacto =new Contacto(nombre, numeroTelefono);
        listaContactos.add(contacto);
        System.out.println("Contacto agregado correctamente");
    }
    //metodo para mostar la lista de contactos
    public void mostrarListaContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía");
        } else {
            System.out.println("Lista de Contactos:");
            for (Contacto contacto:listaContactos) {
                System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getNumeroTelefono());
            }
        }
    }
    // metodo para buscar contacto por nombre
    public void buscarContacto() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía");
            return;
        }
        System.out.println("Ingrese el nombre del contacto a buscar:");
        scanner.nextLine(); 
        String nombre = scanner.nextLine();

        boolean encontrado =false;
        for (Contacto contacto: listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:");
                System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getNumeroTelefono());
                encontrado= true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("El contacto no se encuentra en la lista");
        }
    }
// ordenar por burbuja a partir de nombres
    public void ordenarBurbujaNombres(){
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía");
            return;
        }
        for (int i = 0; i <listaContactos.size()- 1; i++) {
            for (int j = 0; j< listaContactos.size()- i- 1;j++){
                if (listaContactos.get(j).getNombre().compareToIgnoreCase(listaContactos.get(j+1).getNombre()) > 0) {
                    Contacto temp = listaContactos.get(j);
                    listaContactos.set(j,listaContactos.get(j +1));
                    listaContactos.set(j +1,temp);
                }
            }
        }
        System.out.println("Lista de contactos ordenada por nombre, burbuja");
        mostrarListaContactos();
    }
     //ordenar por insercion a partir de numeros telefonicos 
    public void ordenarInsercionNumeros() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía");
            return;
        }
        for (int i =1; i <listaContactos.size();i++) {
            Contacto clave=listaContactos.get(i);
            int j =i-1;
            while (j>= 0 && listaContactos.get(j).getNumeroTelefono()>clave.getNumeroTelefono()){
                listaContactos.set(j+1,listaContactos.get(j));
                j=j -1;
            }
            listaContactos.set(j+1,clave);
        }
        System.out.println("Lista de contactos ordenada por número de teléfono, inserción");
        mostrarListaContactos();
    }
   
}