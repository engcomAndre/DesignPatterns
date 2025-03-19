## Creational Patterns
### Builder Pattern
The builder allows to create of complex objects step by step. It is a creational pattern used to instantiate objects with many parameters.
It separates this construction of an object its representation and permits to create different representations of same class,
improving reusability, readability and conciseness to specific context.

#### The Problem Builder pattern solves
```java
public class Builder {
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

    Builder(String param1) {
        this.param1 = param1;
    }

    Builder(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    Builder(String param1, String param2, String param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    Builder(String param1, String param2, String param3, String param4) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }

    Builder(String param1, String param2, String param3, String param4, String param5) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
    }
}
```
In this example, we have a class with multiple parameters. The constructor is overloads to allow different combinations of parameters.
This example contains only 6 parameters, but imagine a more complex class with over 10 parameters or a one requiring various parameter combinations.
Managing such scenarios can become highly complex and expensive to maintain. To solve this problem, we can use the Builder pattern.
```java
public class Builder {
    private String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;

    Builder(String param1) {
        this.param1 = param1;
    }

    Builder withParam2(String param2) {
        this.param2 = param2;
        return this;
    }

    Builder withParam3(String param3) {
        this.param3 = param3;
        return this;
    }

    Builder withParam4(String param4) {
        this.param4 = param4;
        return this;
    }

    Builder withParam5(String param5) {
        this.param5 = param5;
        return this;
    }

    Builder withParam6(String param6) {
        this.param6 = param6;
        return this;
    }
}   
```
This implementation allows a more dynamic way instantiate this class:
```java
Builder builder = new Builder("param1")
        .withParam2("param2")
        .withParam3("param3")
        .withParam4("param4")
        .withParam5("param5")
        .withParam6("param6");
```
OR
```java
Builder builder = new Builder("param1")
        .withParam2("param2")
        .withParam3("param3");
```
This approach allows any desired combination of parameters, making object instantiation more straightforward and readable.

### In time can be used with lombok
```java 
@Builder
public class BuilderExampleLombok {
    private  String param1;
    private String param2;
    private String param3;
    private String param4;
    private String param5;
    private String param6;
}
```
The ```@Builder```  annotation from Lombok generates builder class, reducing boilerplate code. This is a great way to use the Builder pattern while minimizing manual implementation. However, it's essential to evaluate the trade-offs before using Lombok in your project.

### Advantages of the Builder Pattern
- More readable code.
- More maintainable code.
- More flexible code.
- More reusable code.
- More testable code.
- More extensible code.
- More decoupled code.
- More encapsulated code.
- More cohesive code.

#### When to use Builder Pattern
- When you have a class with many parameters.
- When you have a class with many combinations of parameters.
- When you have a class with many optional parameters.
- When you have a class with many required parameters.

### When no to use Builder Pattern
- When you have a class with few parameters.
- When you have a class with few combinations of parameters.
- When you have a class with few optional parameters.
- When you have a class with few required parameters.

### Conclusion
The builder pattern is a creational pattern that simplifies the construction of objects with many parameters. 
It helps improve readability and maintainability of code.
However, like any design pattern, it is not a silver bullet, it should be used only when necessary after evaluating its trade-offs.


