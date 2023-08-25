package Dao;

import Entities.Operation;

public interface OperationDao {
    void insert (Operation operation);
    void read();
    void update();
    void delete();
}
