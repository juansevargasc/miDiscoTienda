/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomidiscotienda;

import java.util.*;

/**
 *
 * @author juanvargas
 */
public class Main
{
    public static void main(String[] args) 
    {
        //Creacion de la disco tienda
        miDiscoTienda tiendaJuan = new miDiscoTienda();
        
        //Creacion de un album
        Album parachutes = new Album();
        parachutes.anadirTamanoAlbum(12);
        parachutes.asignarNombre("Parachutes");
        
        //Agregar un album al catalogo
        boolean indicador = tiendaJuan.agregarAlbum(parachutes, 0);
        System.out.println("Album añadido: " + indicador);
        
        //Creación de canción
        Cancion dontPanic = new Cancion();
        //Añadir nombre
        dontPanic.anadirNombre("Don't Panic");
        //Añadir precio en dolares USD
        dontPanic.anadirPrecio(1);
        //Añadir duración
        dontPanic.anadirDuracion("2 minutos 17 segundos ");
        //Añadir tamaño en MB
        dontPanic.anadirTamano(5.4);
        //Añadir calidad en Kbps
        dontPanic.anadirCalidad(256);
        
        //Añadir cancion a album
        indicador = parachutes.anadirCancion(dontPanic, 0);
        System.out.println("Cancion añadida: " + indicador);
        
        //Imprimir información de canción
        //Pide al usuario la informacion de nombre de album y cancion
        System.out.println("\n" + "Digite nombre de album: ");
        Scanner input = new Scanner(System.in);
        String albumUsuario = input.nextLine();
        System.out.println("Digite nombre de cancion: ");
        String cancionUsuario = input.nextLine();
        
        //Información en la base de datos de la disco tienda
        Album[] albumDiscoTienda = tiendaJuan.reqAlbum();
        String albumTienda = albumDiscoTienda[0].reqNombre();
        //System.out.println(albumTienda);
        Cancion[] cancionesAlbum = albumDiscoTienda[0].reqPistas();
        String cancionTienda = cancionesAlbum[0].reqNombreCancion();
        //System.out.println(cancionTienda + "\n");
        
        
        //Si los nombres coinciden, se informa al usuario y se imprime la información de la canción. 
        //Sino, se informa al usuario. 
        
        //Se usa el método de la clase "Objects": Objects.equals() para comparar el contenido
        //de los objetos y no si dos objetos son exactamente los mismos.
        boolean nombres = ( Objects.equals(albumUsuario, albumTienda) ) && ( Objects.equals(cancionUsuario, cancionTienda) );
        if(nombres == true)
        {
            System.out.println("Las canciones están disponibles en la tienda. " + "\n");
            //Imprime la informacion de la cancion obtenida mediante el método para imprimir información
            cancionesAlbum[0].presentarInfCancion();
        }else
        {
            System.out.println("El album y la canción no se encuentran en nuestra base de datos ");
        }
        
    
    }
    
}
