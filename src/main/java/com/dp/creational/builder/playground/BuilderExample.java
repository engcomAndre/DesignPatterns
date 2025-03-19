package com.dp.creational.builder.playground;

public class BuilderExample {
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

    BuilderExample(String param1) {
        this.param1 = param1;
    }

    BuilderExample(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    BuilderExample(String param1, String param2, String param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    BuilderExample(String param1, String param2, String param3, String param4) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }

    BuilderExample(String param1, String param2, String param3, String param4, String param5) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
    }
}
