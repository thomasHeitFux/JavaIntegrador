import Dao.implementations.OperationImpDaoH2;
import Entities.Operation;
import config.JdbcConfig;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
try {
    Connection connection = JdbcConfig.getDBConnection();
    OperationImpDaoH2 operationDao = new OperationImpDaoH2(connection);
    boolean salir = false;
    while (!salir) {
        System.out.println("Elige una operacion:");
        System.out.println("1. Agregar gasto.");
        System.out.println("2. Agregar ingreso.");
        System.out.println("3. Ver balance.");
        System.out.println("4. Ver Gastos.");
        System.out.println("5. Ver ingresos.");
        System.out.println("0. Salir.");

        int opcion;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            scanner.nextLine(); // Limpiar el búfer de entrada
            continue; // Volver al inicio del bucle
        }

        switch (opcion) {
            case 1 -> {
                double amount = pedirMonto(scanner);
                scanner.nextLine();
                String date = pedirFecha(scanner);
                String category = pedirCategoria(scanner);
                String type = "EXPENSE";



                Operation gasto1 = new Operation(amount, date, category, type);

                operationDao.insert(gasto1);
                System.out.println("Agregado exitosamente!");
            }
            case 2 -> {
                double amount = pedirMonto(scanner);
                scanner.nextLine();
                String date = pedirFecha(scanner);
                String category = pedirCategoria(scanner);
                String type = "INCOME";



                Operation gasto1 = new Operation(amount, date, category, type);

                operationDao.insert(gasto1);
                System.out.println("Agregado exitosamente!");

            }
            case 3 -> {

                double balance = operationDao.getBalance();
                System.out.println("Balance actual: " + balance);

            }
            case 4 -> {

                System.out.println("GASTOS:");
                operationDao.showExpenses();


            }
            case 5 -> {

                System.out.println("\nINGRESOS:");
                operationDao.showIncomes();
            }
            case 0 -> {
                System.out.println("Saliendo del programa...");
                salir = true;

            }
            default -> System.out.println("Opción inválida.");
        }


    }
    scanner.close();

}catch (Exception e){
    e.printStackTrace();
}


    }
    private static double pedirMonto(Scanner scanner) {
     while (true){
         try {
             System.out.println("Ingrese monto:");
             return scanner.nextDouble();
         }catch (InputMismatchException e){
             System.out.println("Error: Ingrese un monto valido.");
             scanner.nextLine();
         }
     }
    }

    private static String pedirFecha(Scanner scanner) {
        Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        while (true){
            try {
                System.out.print("Ingrese la fecha (formato YYYY-MM-DD): ");
                String date = scanner.nextLine();
                Matcher matcher = datePattern.matcher(date);
                if(matcher.matches()){
                    return date;
                }else {
                    System.out.println("Error: formato de fecha incorrecto");
                }
            }catch (InputMismatchException e){
                System.out.println("Error: Ingrese una fecha valida");
                scanner.nextLine();
            }
        }
    }

    private static String pedirCategoria(Scanner scanner) {
       while (true){
           try {
               System.out.println("Ingrese categoria :");
               return scanner.nextLine();
           }catch (InputMismatchException e){
               System.out.println("Error: Ingrese categoria valida");
               scanner.nextLine();
           }
       }
    }
}
