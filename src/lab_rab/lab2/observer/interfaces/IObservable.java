package lab_rab.lab2.observer.interfaces;


import lab_rab.lab2.observer.ControlRole;

//Объект, он добавляет себе IObserver, тот объект, который должен быть подписан  и уведомляет его об изменениях:

public interface IObservable {
    void addObserver(IObserver observer);//Добавление наблюдателя
    void notify(ControlRole role);//Уведомление наблюдателя
}
