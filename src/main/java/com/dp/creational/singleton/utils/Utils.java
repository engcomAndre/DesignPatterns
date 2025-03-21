package com.dp.creational.singleton.utils;

public class Utils {
    public static void configureRacingConditions() {
        try {
            Thread.sleep(100); // Simulating a delay to increase race condition probability
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
