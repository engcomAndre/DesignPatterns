package com.dp.creational.factory.playground;

public class FactorySomeThingAny implements Factory {

    @Override
    public String doSomething(){
        final var result = "FactorySomeThingAny doSomething";
        System.out.println(result);
        return result;
    }
}


