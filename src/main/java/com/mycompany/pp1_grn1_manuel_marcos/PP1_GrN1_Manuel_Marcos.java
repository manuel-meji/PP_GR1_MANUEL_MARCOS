package com.mycompany.pp1_grn1_manuel_marcos;

import java.awt.Menu;
import javax.swing.JOptionPane;

class Cliente {trtyrtrty

    String nombre;
    int servicio[] = new int[3]; //LLENAR
    String marca;
    String MetodoPago; //AGREGAR CONSTRUCTOR
    int cantidadRepuesto;
    float costoRepuestos;
    float costo;
    String placa;

    public Cliente(String nombre, String marca, int cantidadRepuesto, float costoRepuestos, String placa) {
        this.nombre = nombre;
        this.marca = marca;
        this.cantidadRepuesto = cantidadRepuesto;
        this.costoRepuestos = costoRepuestos;
        this.placa = placa;
    }

}

class Servicios {

    String nombre;
    float montoefectivo;
    float montoSINPE;
    float costoServicio;
    float montoTarjeta;
    int vecesUtilizadas;

    public Servicios(String nombre, float montoefectivo, float montoSINPE, float montoTarjeta, int vecesUtilizadas, float costoServicio) {
        this.nombre = nombre;
        this.montoefectivo = montoefectivo;
        this.montoSINPE = montoSINPE;
        this.montoTarjeta = montoTarjeta;
        this.vecesUtilizadas = vecesUtilizadas;
        this.costoServicio = costoServicio;
    }

}

public class PP1_GrN1_Manuel_Marcos {

    static int cantidadSinpe = 0, cantidadTarjeta = 0, cantidadEfectivo = 0;
    static String sinpe = "SINPE:\n", tarjeta = "Tarjeta:\n", efectivo = "Efectivo:\n";

    static int contador = 1;

    public static void main(String[] args) {
        Servicios LUBRI = new Servicios("Lubricentro", 0.0f, 0.0f, 0.0f, 0, 8810);
        Servicios MERA = new Servicios("Mecánica rápida", 0.0f, 0.0f, 0.0f, 0, 9780);
        Servicios ELECT = new Servicios("Electrónica", 0.0f, 0.0f, 0.0f, 0, 15705);
        Cliente clientes[] = new Cliente[10];

        JOptionPane.showMessageDialog(null, "Bienvenido a MecaEléctrica S.A");
        do {
            int op = menu();
            switch (op) {
                case 1: {
                    Ingresar(clientes, LUBRI, MERA, ELECT);
                    break;
                }

                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public static void Ingresar(Cliente[] clientes, Servicios lubri, Servicios mera, Servicios elect) {

        if (contador <= 11) {
            int servicio = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Lubricentro\n2. Mecánica rápida\n3. Electromecánica", "Seleccione un servicio", JOptionPane.DEFAULT_OPTION));
            clientes[contador - 1] = new Cliente(
                    JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:"),
                    JOptionPane.showInputDialog(null, "Ingrese la marca del vehículo:"),
                    // Metodo de pago, se llena mas adelante
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de repuestos:")),
                    Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el costo de los repuestos:")),
                    JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo:")
            );
            clientes[contador - 1].costo = (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);
            int metodo = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Efectivo\n2. Tarjeta\n3. SINPE", "Seleccione una opcion de pago", JOptionPane.DEFAULT_OPTION));
            switch (servicio) {
                case 1: {
                    switch (metodo) {
                        case 1: {
                            efectivo += clientes[contador - 1].nombre + "\n";
                            cantidadEfectivo++;
                            lubri.montoefectivo += lubri.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);

                            break;
                        }
                        case 2: {
                            tarjeta += clientes[contador - 1].nombre + "\n";
                            cantidadTarjeta++;
                            lubri.montoTarjeta += lubri.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);
                            break;
                        }
                        case 3: {
                            sinpe += clientes[contador - 1].nombre + "\n";
                            cantidadSinpe++;
                            lubri.montoSINPE += lubri.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);
                            break;
                        }
                        default:

                            break;
                    }
                    clientes[contador - 1].costo += lubri.costoServicio;
//                    JOptionPane.showMessageDialog(null, efectivo);
                    break;
                }
                case 2: {
                    switch (metodo) {
                        case 1: {
                            efectivo += clientes[contador - 1].nombre + "\n";
                            cantidadEfectivo++;
                            mera.montoefectivo += mera.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);

                            break;
                        }
                        case 2: {
                            tarjeta += clientes[contador - 1].nombre + "\n";
                            cantidadTarjeta++;
                            mera.montoTarjeta += mera.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);
                            break;
                        }
                        case 3: {
                            sinpe += clientes[contador - 1].nombre + "\n";
                            cantidadSinpe++;
                            mera.montoSINPE += mera.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos); //Esta es una prueba
                            break;
                        }
                        default:

                            break;
                    }
                    clientes[contador - 1].costo += mera.costoServicio;
//                    JOptionPane.showMessageDialog(null, efectivo);
                    break;
                }
                case 3: {
                    switch (metodo) {
                        case 1: {
                            efectivo += clientes[contador - 1].nombre + "\n";
                            cantidadEfectivo++;
                            elect.montoefectivo += elect.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);

                            break;
                        }
                        case 2: {
                            tarjeta += clientes[contador - 1].nombre + "\n";
                            cantidadTarjeta++;
                            elect.montoTarjeta += elect.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);
                            break;
                        }
                        case 3: {
                            sinpe += clientes[contador - 1].nombre + "\n";
                            cantidadSinpe++;
                            elect.montoSINPE += elect.costoServicio + (clientes[contador - 1].cantidadRepuesto * clientes[contador - 1].costoRepuestos);
                            break;
                        }
                        default:

                            break;
                    }
                    clientes[contador - 1].costo += elect.costoServicio;
             
                    break;
                }
                default:
                    break;
            }

        } else {JOptionPane.showMessageDialog(null, "Ha ingresado el máximo de clientes permitidos");}
    }
    public static void Buscar(Cliente[] clientes){
        String placa = JOptionPane.showInputDialog(null, "Escriba la placa a buscar: ");
        for(int i = 0; i < contador-1; i++ ){
            if(placa.equals(clientes[i].placa)){
                JOptionPane.showMessageDialog(null, "*** Información del cliente ***\n"
                        + "------------------------------------\n"
                        + "Nombre cliente: " + clientes[i].nombre + "\n"
                                + "Marca vehículo: " + clientes[i]. marca + "\n"
                                        + "");
            }
        }
    }

    public static int menu() {
        String txt = "Seleccione una opción: \n"
                + "1. Ingresar cliente\n"
                + "2. Buscar\n"
                + "3. Visualizar\n"
                + "4. Eliminar\n"
                + "5. Estadísticas de venta\n"
                + "6. Salir";
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, txt, "Menu de opciones", JOptionPane.DEFAULT_OPTION));
        return op;
    }
}
