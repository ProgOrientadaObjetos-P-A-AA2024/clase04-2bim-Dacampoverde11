/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import static java.util.Locale.US;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(US);

        String nombreCentroComercial, nombreArrendatario;
        double cuotaBase;
        int num, seleccion;

        System.out.println("Ingrese el nombre del centro comercial:  ");
        nombreCentroComercial = sc.nextLine();

        System.out.println("Ingrese la canttidad de centros comerciales a agregar:  ");
        num = sc.nextInt();
        sc.nextLine();
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("\n1) Arriendo local comida");
            System.out.println("2) Arriendo local comercial");
            System.out.println("3) Arriendo local sesiones");
            System.out.println("Ingrese el numero del local a agregar: ");
            seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion != 1 && seleccion != 2 && seleccion != 3) {
                System.out.println("Error, opcion no valida!\n");
                return;
            }

            System.out.println("Ingrese el nombre del arrendatario:");
            nombreArrendatario = sc.nextLine();
            System.out.println("Ingrese el valor de la cuota base: ");
            cuotaBase = sc.nextDouble();

            if (seleccion == 1) {
                ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                        nombreArrendatario, cuotaBase);
                System.out.println("Ingrese el porcentaje del iva: ");
                double iva = sc.nextDouble();
                arriendoComida.establecerIva(iva); // en porcentaje

                System.out.println("Ingrese el valor a pagar del agua: ");
                double valorAgua = sc.nextDouble();
                arriendoComida.establecerValorAgua(valorAgua); // en $

                System.out.println("Ingrese el valor a pagar de Luz: ");
                double valorLuz = sc.nextDouble();
                arriendoComida.establecerValorLuz(valorLuz); // en $

                listaArriendos.add(arriendoComida);

            } else if (seleccion == 2) {
                ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                        nombreArrendatario, cuotaBase);
                System.out.println("Ingrese el valor adicional fijo: ");
                double valorFijo = sc.nextDouble();
                arriendoComercial.establecerNombreArrendatario(nombreArrendatario);
                arriendoComercial.establecerValorAdicionalFijo(valorFijo); // en $

                listaArriendos.add(arriendoComercial);
                
            } else if (seleccion == 3) {
                ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                        nombreArrendatario, cuotaBase);
                System.out.println("Ingrese el valor a pagar de las sillas: ");
                double valorSillas = sc.nextDouble();
                arriendoSesiones.establecerValorSillas(valorSillas); // en $
                
                System.out.println("Ingrese el valor a pagar de la amplificacion: ");
                double valorAmplificacion = sc.nextDouble();
                arriendoSesiones.establecerValorAmplificacion(valorAmplificacion); // en $

                listaArriendos.add(arriendoSesiones);
            }
        }




        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial(nombreCentroComercial,
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
