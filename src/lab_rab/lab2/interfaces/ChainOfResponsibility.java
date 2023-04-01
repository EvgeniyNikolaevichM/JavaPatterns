package lab_rab.lab2.interfaces;

import java.io.IOException;

//Паттерн, который позволяет запросы передавать последовательно:
//Открыть файлы RowChain и ColumnChain

public interface ChainOfResponsibility {
    void writeVehicle(IVehicle vehicle) throws IOException;//метод для записми
    void setNextChain(ChainOfResponsibility nextChain);//метод для установки след чины
}
