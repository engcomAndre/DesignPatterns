package com.dp.creational.factory.playground;

public class ParameterizedFactory {

    public static Factory createFactory(String factoryType){
        return switch (factoryType) {
            case "FactorySomeThingFirst" -> new FactorySomeThingFirst();
            case "FactorySomeThingSecond" -> new FactorySomeThingSecond();
            default -> null;
        };
    }
}
