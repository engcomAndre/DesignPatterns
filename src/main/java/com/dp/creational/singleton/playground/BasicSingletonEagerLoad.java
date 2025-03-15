package com.dp.creational.singleton.playground;

import static com.dp.creational.singleton.utils.Utils.configureRacingConditions;

/*
 * This is a simple approach to solve the problem of BasicSingleton.java,
 * beyond thread safe, this increase a performance because the synchronization are not necessary
 * and the singleton are initialized when class is loaded, so it is guaranteed that only one instance will be created before runtime execution
 * however this behavior can be unnecessary if then instance not be used.
 * */
public class BasicSingletonEagerLoad {
    private static final BasicSingletonEagerLoad instance = new BasicSingletonEagerLoad();

    private BasicSingletonEagerLoad() {
    }

    public static BasicSingletonEagerLoad getInstance() {
        configureRacingConditions();
        return instance;
    }
}
