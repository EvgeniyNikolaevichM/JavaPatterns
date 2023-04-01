package lab_rab.lab2;

import lab_rab.lab2.interfaces.ChainOfResponsibility;
import lab_rab.lab2.interfaces.IVehicle;

import java.io.FileWriter;
import java.io.IOException;

public class RowChain implements ChainOfResponsibility {
    private ChainOfResponsibility nextChain;
    @Override
    public void writeVehicle(IVehicle vehicle) throws IOException {//Запись вехикл
        if (vehicle.getModelsSize()<=3){//Если верно, то записываем файлик RowChain
            FileWriter outputStream = new FileWriter("RowChain");
            for (String string : vehicle.getAllModelsNames()){//Получаем имя
                outputStream.write(string + " ");//Записываем строчку
            }
            outputStream.close();
        }
    }
//Устанавливает для этой чины очередь, какая чина будет следовать после нее, если не выполнится определенное условие
    @Override
    public void setNextChain(ChainOfResponsibility next_chain) {
        this.nextChain=nextChain;
    }
}
    