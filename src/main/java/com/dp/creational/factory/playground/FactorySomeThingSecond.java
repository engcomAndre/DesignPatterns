package com.dp.creational.factory.playground;


public class FactorySomeThingSecond implements Factory {

    @Override
    public String doSomething(){
        final var result = "FactorySomeThingSecond doSomething";
        System.out.println(result);
        return result;
    }
}


