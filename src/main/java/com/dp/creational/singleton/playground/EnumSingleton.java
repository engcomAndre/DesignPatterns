package com.dp.creational.singleton.playground;

import static com.dp.creational.singleton.utils.Utils.configureRacingConditions;

/*
* This implementation based in enum used the behavior to create a singleton instance, this implementation is thread safe,
* and more performant than other BasicSingletonThreadSafe.java and singleton are loaded by the JVM when the class is loaded,
* so it is guaranteed that only one instance will be created before runtime execution, but can be unliked if singleton not used.
* Recommended in Effective Java by Joshua Bloch
* */
public enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {    }

    public static EnumSingleton getInstance() {
        configureRacingConditions();
        return INSTANCE;
    }
}
