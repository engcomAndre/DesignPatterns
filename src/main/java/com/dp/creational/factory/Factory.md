## Creational Patterns

This is little personal study and analysis of Singleton Pattern, this pattern is a creational
pattern, and is used to ensure that a class has only one instance and provides a global point of access to it.

### Factory Method
- Factory Method is a creational pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.
- Solves the problem of creating product objects without specifying the exact class of object that will be created.
- The background concept is that the calling code does not need to know the exact class of the object it is creating.

### Factory Method Pattern
```java
public interface Factory {
    String doSomething();
}

public class FactorySomeThingFirst implements Factory {

    @Override
    public String doSomething() {
        final var result = "FactorySomeThingFirst doSomething";
        System.out.println(result);
        return result;
    }
}

public class FactorySomeThingSecond implements Factory {

    @Override
    public String doSomething(){
        final var result = "FactorySomeThingSecond doSomething";
        System.out.println(result);
        return result;
    }
}
```
The others class can user factory interface to create other object with the same behavior and continue same method signature to any implemented class.

## Parameterized Factory
```java
public class ParameterizedFactory {

    public static Factory createFactory(String factoryType){
        return switch (factoryType) {
            case "FactorySomeThingFirst" -> new FactorySomeThingFirst();
            case "FactorySomeThingSecond" -> new FactorySomeThingSecond();
            default -> null;
        };
    }
}
```
This implementation permits a factory to create objects based on passed parameter, this can be usefully but has a problem with the number of parameters, if the number of parameters is too large, the method signature will be too large and difficult to maintain and factory has know that classes can instantiate.

## How Factory method works in Spring Boot
- Spring Boot uses the Factory Method Pattern to create beans, the `@Bean` annotation is a Factory Method that creates a bean and returns it to the Spring container.
- The Spring container manages the lifecycle of the bean, and the bean is a singleton by default.
- Is possible use application context to manager desired beans created by factory method.

```java
public class DefaultNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new DefaultNotification();
    }
}

public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

public abstract class NotificationFactory {
    public abstract Notification createNotification();
}

public class NotificationService {

    private final NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void sendNotification(){
        final var notification = notificationFactory.createNotification();
        notification.sendNotification();
    }
}
```
# Resume
The factory methods pattern are useful to creation of objects of the similar behavior, can be combined of the singleton, dependency injection
or others design patterns or even AOP to increases readability and manageability of the code, and the spring boot 
uses this pattern to create beans and provides use in application context included the personalized manager of desired instances.








