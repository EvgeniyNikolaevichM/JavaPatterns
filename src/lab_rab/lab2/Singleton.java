package lab_rab.lab2;

import java.io.*;
import java.util.Properties;

public class Singleton {   //Паттерн(пораждющий), гаранитрует создать объект только в одном эклемпляре
    private static volatile Singleton instance;
    static Properties properties;
    public static String email = null;
    public static String path = null;//Как гарантируем?
    private Singleton() {   //1)конструктор приватный
        try {               //не позволяет создание объектов,кроме методов этого класса
            InputStream in = new FileInputStream(new File("config.properties"));
            properties = new Properties();
            properties.load(in);
            email = properties.getProperty("EMAIL");
            path = properties.getProperty("PATH");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static synchronized Singleton getInstance() {//3Метод синхронизирован(Если запустить метод 2 раза объект не создастся из-за 2х потоков)-защита от многопоточности
        if (instance == null) { //2)Проверяем в методе, который создает этот объект, что
            instance = new Singleton(); //он до этого не создавался(в одном экземпляре)
        }
        return instance;
    }

    public static void main (String[] args) throws IOException {
        Singleton propertyReader = Singleton.getInstance();
        String configuration = "Адрес электронной почты "+ email +"\n"+"Путь к файлу "+ path;
        System.out.println(configuration);
    }
}
