package lab_rab.lab2.observer.interfaces;


import lab_rab.lab2.observer.ControlRole;

//Паттерн Observer, обхект, который наблюдает
public interface IObserver {
    void update(ControlRole role);//Должен обновлять в зависимости от того, что нужно обновлять у себя
    void subscribe(IObservable provider);//Подписан на действия, которые происходят в объекте IObservable
}
