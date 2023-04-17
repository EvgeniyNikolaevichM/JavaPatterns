package lab_rab.lab2.DAO;

//Можем менять тип файлов с которым мы работаем и использовать тот класс
//в зависимости от того типа файла с которого нам нужно получить информацию или записать ее
//Объявляем интерфейс и под интерфейс пишем конечные классы под каждый тип файлов или тип данных
//У нас символьный и байтовый класс

import lab_rab.lab2.interfaces.IVehicle;

import java.io.IOException;
public interface DataTypeGetting {
    void write(IVehicle vehicle);//Записываем
    void read() throws IOException;//Читаем
    void print();//Получаем
}
