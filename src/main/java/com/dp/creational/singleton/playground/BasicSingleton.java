package com.dp.creational.singleton.playground;

import static com.dp.creational.singleton.utils.Utils.configureRacingConditions;

/*
* Naive basic implementation of singleton design pattern, provides a one instance of resource, class or object, Spring boot for ex used this pattern to manager beans
* PS: Not Thread safe implementation, thread can instantiate, more than one instances of the singleton class, this can create a problem in multi-threaded environment
* ex: not usefully database connection, file system, etc, and memory leak
* How to solve this problem, see SingletonThreadSafe.java
* */
public class BasicSingleton {
    private static BasicSingleton instance = null;

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        if (instance == null) {
            configureRacingConditions();
            instance = new BasicSingleton();
        }
        return instance;
    }

}
