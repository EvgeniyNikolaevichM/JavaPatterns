package lab_rab.lab2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                System.out.println("Ожидаем подключения");

                Socket socket = serverSocket.accept(); // Принимаем обращение клиента (Ждет пока подключится клиент)
                System.out.println("Подключение прошло успешно");

                try (BufferedReader inputSocketStream = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    try (PrintWriter outputSocketStream = new PrintWriter(socket.getOutputStream())) {
//Получаем данные:
                        ArrayList<Double> doubles = new ArrayList<Double>();
                        String line = inputSocketStream.readLine();//Здесь получили данные от клиента
                        while (line != null && line.length() > 0) {//Если не равны нулю
                            doubles.add(Double.parseDouble(line));//Конвертируем из байтов в дабл, чтобы их перемножить
                            line = inputSocketStream.readLine();//Записали эти числа
                        }

                        System.out.printf("Первое число: %s%nВторое число: %s%n", doubles.get(0), doubles.get(1));
                        double mul = doubles.get(0) * doubles.get(1);// Перемножаем числа
                        System.out.println("Произведение: " + mul);

                        outputSocketStream.write(String.valueOf(mul));//Записываем произведение обратно отправляем
                        outputSocketStream.flush();

                        System.out.println("Соединение закрыто");
                    }
                }
            }
        }
    }
}
