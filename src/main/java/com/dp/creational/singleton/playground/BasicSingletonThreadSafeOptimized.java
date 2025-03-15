package com.dp.creational.singleton.playground;

import static com.dp.creational.singleton.utils.Utils.configureRacingConditions;

/*
 * This is a simple approach to solve the problem of BasicSingleton.java,
 * beyond thread safe, this increase a performance because the synchronized block are accessed
 * only one time when instance is null, and the others thread are blocked until the instance is created.
 * */
public class BasicSingletonThreadSafeOptimized {
    private static volatile BasicSingletonThreadSafeOptimized instance;

    private BasicSingletonThreadSafeOptimized() {
    }

    public static synchronized BasicSingletonThreadSafeOptimized getInstance() {
        if (instance == null) {
            configureRacingConditions();
            synchronized (BasicSingletonThreadSafeOptimized.class) {
                if (instance == null) {
                    instance = new BasicSingletonThreadSafeOptimized();
                }
            }
        }
        return instance;
    }
}
