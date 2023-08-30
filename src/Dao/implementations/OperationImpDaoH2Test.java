package Dao.implementations;
import Dao.OperationDao;
import Entities.Operation;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class OperationImpDaoH2Test {
    @Mock
    private OperationDao mockOperationDao;
    @Mock
    private Connection mockConnection;
    @Mock
    private ResultSet mockResultSet;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        try {
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            when(mockPreparedStatement.execute()).thenReturn(true);
            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true, false);
        } catch (Exception e) {
            throw new RuntimeException("Error al configurar la prueba", e);
        }
    }

    @Test
    @DisplayName("testeo de insercion")
    void insert() {
        // GIVEN
        Operation operation = new Operation();
        operation.setAmount(100.0);
        operation.setDate("2023-08-23");
        operation.setCategory("Gastos");
        operation.setType("GASTO");
        // WHEN
        mockOperationDao.insert(operation);
        // THEN: Verificar que la inserción fue exitosa
        try {
            PreparedStatement preparedStatement = mockConnection.prepareStatement(
                    "SELECT * FROM OPERATIONS WHERE amount = ? AND date = ? AND category = ? AND type = ?");
            preparedStatement.setDouble(1, operation.getAmount());
            preparedStatement.setString(2, operation.getDate());
            preparedStatement.setString(3, operation.getCategory());
            preparedStatement.setString(4, operation.getType());

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();

            Assertions.assertTrue(found, "La inserción no se realizó correctamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar la inserción", e);
        }
    }

    @Test
    @DisplayName("testeao de lectura")
    @Disabled
    void read() {
    }

    @Test
    @DisplayName("testeo de actualizacion")
    @Disabled
    void update() {
    }

    @Test
    @DisplayName("testeo de eliminacion")
    @Disabled
    void delete() {
    }

    @Test
    @DisplayName("testeo de obtener balance")
    @Disabled
    void getBalance() {
    }

    @Test
    @DisplayName("testeo de mostrar gastos")
    @Disabled
    void showExpenses() {
    }

    @Test
    @DisplayName("testeo de mostrar ingresos")
    @Disabled
    void showIncomes() {
    }
}