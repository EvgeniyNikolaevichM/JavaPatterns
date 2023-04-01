package lab_rab.lab2;

import lab_rab.lab2.interfaces.Command;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

//+
//Чина, которая позволяет простые запросы или операции добавлять в отдельные объекты
//Смотри в Car.java - public void print(FileWriter fileWriter) throws IOException {
//                  -  public void setPrintCommand(Command command)

public class RowCommand implements Command, Serializable {
    @Override
    public void write_to_file(Car car, FileWriter fileWriter) throws IOException {
        if (fileWriter !=null) {
            for (String string: car.getAllModelsNames()){
                fileWriter.write(string + " ");//Запись в строку
            }
            fileWriter.close();
        } else {
            System.out.println("Поток is gone");
        }
    }
}
    