package com.dp.creational.singleton.playground;

/*
 * This implementation is based on the Bill Pugh Singleton Design Pattern, this implementation is thread safe,
 * and it is recommended to use this implementation because it is thread safe, and it is not necessary to use synchronized block
 * are a more used implementation in the Java world.
 * */
public class BasicSingletonBillPugh {
    private BasicSingletonBillPugh() {
    }

    private static class SingletonHelper {
        private static final BasicSingletonBillPugh INSTANCE = new BasicSingletonBillPugh();
    }

    public static BasicSingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}