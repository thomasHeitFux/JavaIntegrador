package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        double saldoInicial = 0.0;
        double saldoActual = saldoInicial;

        List<Gasto> listaGastos = new ArrayList<>();
        List<Ingreso> listaIngresos = new ArrayList<>();

        boolean salir = false;
        while (!salir) {
            System.out.println("Elige una operacion:");
            System.out.println("1. Agregar gasto.");
            System.out.println("2. Agregar ingreso.");
            System.out.println("3. Ver balance.");
            System.out.println("4. Ver Gastos.");
            System.out.println("5. Ver ingresos.");
            System.out.println("0. Salir.");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 ->{
                    double monto = pedirMonto(scanner);
                    scanner.nextLine();
                    String fecha = pedirFecha(scanner);
                    String categoria = pedirCategoria(scanner);

                    Gasto gasto1 = new Gasto(monto,fecha,categoria);
                    saldoActual -= gasto1.getMonto();
                    listaGastos.add(gasto1);

                    System.out.println("El gasto es de : " + gasto1.getMonto() );
                    System.out.println("La fecha es : " + gasto1.getFecha() );
                    System.out.println("La categoria es : " + gasto1.getCategoria());

                }
                case 2 -> {
                    double monto = pedirMonto(scanner);
                    scanner.nextLine();
                    String fecha = pedirFecha(scanner);
                    String categoria = pedirCategoria(scanner);

                    Ingreso ingreso1 = new Ingreso(monto,fecha,categoria);
                    saldoActual += ingreso1.getMonto();
                    listaIngresos.add(ingreso1);

                    System.out.println("El ingreso es de : " + ingreso1.getMonto() );
                    System.out.println("La fecha es : " + ingreso1.getFecha() );
                    System.out.println("La categoria es : " + ingreso1.getCategoria());

                }
                case 3 -> {

                    System.out.println("saldo actual : " +saldoActual);
                }
                case 4 -> {
                    System.out.println("Lista de gastos:");
                    for (Gasto gasto : listaGastos) {
                        System.out.println("Monto: " + gasto.getMonto());
                        System.out.println("Fecha: " + gasto.getFecha());
                        System.out.println("Categoria: " + gasto.getCategoria());
                        System.out.println();
                    }
                }
                case 5 -> {
                    System.out.println("Lista de ingresos:");
                    for (Ingreso ingreso : listaIngresos) {
                        System.out.println("Monto: " + ingreso.getMonto());
                        System.out.println("Fecha: " + ingreso.getFecha());
                        System.out.println("Categoria: " + ingreso.getCategoria());
                        System.out.println();
                    }
                }
                case 0 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;

                }
                default -> System.out.println("Opción inválida.");
            }


        }
        scanner.close();

    }
    private static double pedirMonto(Scanner scanner) {
        System.out.println("Ingresa monto:");
        return scanner.nextDouble();
    }

    private static String pedirFecha(Scanner scanner) {
        System.out.println("Ingresa fecha:");
        return scanner.nextLine();
    }

    private static String pedirCategoria(Scanner scanner) {
        System.out.println("Ingresa categoria:");
        return scanner.nextLine();
    }
}
