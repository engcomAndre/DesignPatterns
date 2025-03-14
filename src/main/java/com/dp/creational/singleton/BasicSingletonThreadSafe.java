package com.dp.creational.singleton;

/*
* This is a simple aproach to solve the problem of BasicSingleton.java, this implementation is thread safe, but it has a performance issue,
* because the synchronized block
*
* */
public class BasicSingletonThreadSafe {
    private static BasicSingletonThreadSafe instance = null;

    private BasicSingletonThreadSafe() {
    }

    public static synchronized BasicSingletonThreadSafe getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000); // Simulating a delay to increase race condition probability
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new BasicSingletonThreadSafe();
        }
        return instance;
    }
}
