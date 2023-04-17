package lab_rab.lab2.interfaces;

import lab_rab.lab2.Car;
import lab_rab.lab2.Motorcycle;
import lab_rab.lab2.exceptions.NoSuchModelNameException;

//Паттерн, который используется для упрощения каких-то операций над группами объектов

public interface Visitor {
    void visit(Car car);//Метод визит у кара
    void visit(Motorcycle motorcycle) throws NoSuchModelNameException;//Метод визит у мото, см. дальше метод accept у car и moto
}
