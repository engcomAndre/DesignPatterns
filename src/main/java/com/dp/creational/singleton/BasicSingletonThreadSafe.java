package com.dp.creational.singleton;

import static com.dp.creational.singleton.utils.Utils.configureRacingConditions;

/*
* This is a simple approach to solve the problem of BasicSingleton.java, this implementation is thread safe, but it has a performance issue,
* because the synchronized block is a bottleneck, the threads can instantiate only one instance of the singleton class*
* */
public class BasicSingletonThreadSafe {
    private static BasicSingletonThreadSafe instance = null;

    private BasicSingletonThreadSafe() {
    }

    public static synchronized BasicSingletonThreadSafe getInstance() {
        if (instance == null) {
            configureRacingConditions();
            instance = new BasicSingletonThreadSafe();
        }
        return instance;
    }
}
