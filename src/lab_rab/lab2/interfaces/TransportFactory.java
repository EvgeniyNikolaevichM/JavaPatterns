package lab_rab.lab2.interfaces;

public interface TransportFactory {
    IVehicle createInstance(String brand, int modelsSize);
}

//Фабричный метод-фабрика, для создания объектов, в данном случае абстрактная
//Фабрика фабрик, он будет реализовани в авто фактори и мото фактори
//Они производят экз заранее известного класса и интерфейса