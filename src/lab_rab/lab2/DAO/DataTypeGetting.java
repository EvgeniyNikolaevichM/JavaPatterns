package lab_rab.lab2.DAO;

import lab_rab.lab2.interfaces.IVehicle;

import java.io.IOException;
public interface DataTypeGetting {
    void set (IVehicle vehicle);
    void get() throws IOException;
    void print();
}
