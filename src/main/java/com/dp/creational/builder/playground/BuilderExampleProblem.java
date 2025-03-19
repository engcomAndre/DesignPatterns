package com.dp.creational.builder.playground;

public class BuilderExampleProblem {
    private  String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

    BuilderExampleProblem withParam1(String param1) {
        this.param1 = param1;
        return this;
    }

    BuilderExampleProblem withParam2(String param2) {
        this.param2 = param2;
        return this;
    }

    BuilderExampleProblem withParam3(String param3) {
        this.param3 = param3;
        return this;
    }

    BuilderExampleProblem withParam4(String param4) {
        this.param4 = param4;
        return this;
    }

    BuilderExampleProblem withParam5(String param5) {
        this.param5 = param5;
        return this;
    }

    BuilderExampleProblem withParam6(String param6) {
        this.param6 = param6;
        return this;
    }
}
