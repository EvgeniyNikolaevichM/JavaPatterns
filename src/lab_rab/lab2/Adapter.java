package lab_rab.lab2;

import java.io.*;
//Совместимость компанентов (адаптируем) переводит форматы как Китайская и Европейская розетка:
public class Adapter {//принимает в качестве параметра массив строк и записывает их по очереди в выходной байтовый поток (OutputStream), который он «адаптирует»
    public void writeOutputStream(String...strings) throws IOException {
        OutputStream outputStream = new FileOutputStream("Adapter.txt");
        try {
            for (String str : strings) {
                str += " ";
                byte[] buffer = str.getBytes();
                outputStream.write(buffer);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
    