import Dao.OperationDao;
import Dao.implementations.OperationImpDaoH2;
import Entities.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);






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
                    double amount = pedirMonto(scanner);
                    scanner.nextLine();
                    String date = pedirFecha(scanner);
                    String category = pedirCategoria(scanner);
                    String type = "EXPENSE";

                    OperationDao expensedao = new OperationImpDaoH2();

                    Operation gasto1 = new Operation(amount,date,category,type);

                    expensedao.insert(gasto1);
                    System.out.println("Agregado exitosamente!");
                }
                case 2 -> {
                    double amount = pedirMonto(scanner);
                    scanner.nextLine();
                    String date = pedirFecha(scanner);
                    String category = pedirCategoria(scanner);
                    String type = "INCOME";

                    OperationDao expensedao = new OperationImpDaoH2();

                    Operation gasto1 = new Operation(amount,date,category,type);

                    expensedao.insert(gasto1);
                    System.out.println("Agregado exitosamente!");

                }
                case 3 -> {
                    OperationImpDaoH2 dao = new OperationImpDaoH2();
                    double balance = dao.getBalance();
                    System.out.println("Balance actual: " + balance);

                }
                case 4 -> {
                    OperationImpDaoH2 dao = new OperationImpDaoH2();
                    System.out.println("GASTOS:");
                    dao.showExpenses();


                }
                case 5 -> {
                    OperationImpDaoH2 dao = new OperationImpDaoH2();
                    System.out.println("\nINGRESOS:");
                    dao.showIncomes();

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
        System.out.println("Ingrese monto:");
        return scanner.nextDouble();
    }

    private static String pedirFecha(Scanner scanner) {
        System.out.print("Ingrese la fecha (formato YYYY-MM-DD): ");
        return scanner.nextLine();
    }

    private static String pedirCategoria(Scanner scanner) {
        System.out.println("Ingrese categoria:");
        return scanner.nextLine();
    }
}
