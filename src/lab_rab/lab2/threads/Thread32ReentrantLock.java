package lab_rab.lab2.threads;

import lab_rab.lab2.interfaces.IVehicle;

import java.util.concurrent.locks.ReentrantLock;

public class Thread32ReentrantLock implements Runnable {
    private IVehicle transport;
    private ReentrantLock reentrantLock;

    public Thread32ReentrantLock (IVehicle transport, ReentrantLock reentrantLock) {
        this.transport = transport;
        this.reentrantLock = reentrantLock;
    }

    public void run() {
        reentrantLock.lock();
        try {
            double[] arr = transport.getAllModelsPrices();
            for(int i=0; i < arr.length; i++){
                System.out.println(arr[i]);
            }
        }
        finally {
            reentrantLock.unlock();
        }
    }
}
