package Dao.implementations;

import Dao.OperationDao;
import Entities.Operation;

import java.sql.*;

public class OperationImpDaoH2 implements OperationDao {
    private final Connection connection ;
    public OperationImpDaoH2 (Connection connection){this.connection = connection;}

    @Override
    public void insert(Operation operation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO OPERATIONS (amount, date, category, type) values(?,?,?,?)");
            preparedStatement.setDouble(1, operation.getAmount());
            preparedStatement.setString(2, operation.getDate());
            preparedStatement.setString(3, operation.getCategory());
            preparedStatement.setString(4, operation.getType());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM OPERATIONS "
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                String category = resultSet.getString("category");

                System.out.println("REGISTROS - Fecha: " + date + " - Monto: " + amount + " - Categoría: " + category);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
    }
    public double getBalance(){
        double balance = 0.0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT SUM(CASE WHEN type = 'INCOME' THEN amount ELSE -amount END) AS balance FROM OPERATIONS"
            );

            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return balance;
    }
    public void showExpenses() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM OPERATIONS WHERE type = 'EXPENSE'"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                String category = resultSet.getString("category");

                System.out.println("GASTO - Fecha: " + date + " - Monto: " + amount + " - Categoría: " + category);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void showIncomes() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM OPERATIONS WHERE type = 'INCOME'"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                String category = resultSet.getString("category");

                System.out.println("INGRESO - Fecha: " + date + " - Monto: " + amount + " - Categoría: " + category);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
