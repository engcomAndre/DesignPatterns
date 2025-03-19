package com.dp.creational.factory.playground;

import org.springframework.stereotype.Component;

@Component
public class FactorySomeThingFirst implements Factory {

    @Override
    public String doSomething() {
        final var result = "FactorySomeThingFirst doSomething";
        System.out.println(result);
        return result;
    }
}


