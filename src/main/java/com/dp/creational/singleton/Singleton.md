## Creation Patterns

This is little personal study and analysis of Singleton Pattern, this pattern is a creational
pattern, and is used to ensure that a class has only one instance and provides a global point of access to it.

### Singleton

- Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the
  java virtual machine.
- Only one instance of the class is created and reusable for the system lifecycle.
- Single instance of a class for ex: logs, connections, beans...
- Responsible for creating its own instance and managing it.
- Provides a way to access its only instance.

### Singleton Pattern

## Basic Singleton (Naive)

```java
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```

This implementation is not thread-safe. If multiple threads access the `getInstance()` method at the same time, it can
create
different instances of the Singleton class this is incorrect ways and can be disastrous behavior in critical systems
like multiple
connections in database exploding a connection pull for example.

## Thread Safe Singleton

```java
public class BasicSingletonThreadSafe {
    private static BasicSingletonThreadSafe instance = null;

    private BasicSingletonThreadSafe() {
    }

    public static synchronized BasicSingletonThreadSafe getInstance() {
        if (instance == null) {
            configureRacingConditions();
            instance = new BasicSingletonThreadSafe();
        }
        return instance;
    }
}
```

This implementation is thread-safe, but it is not efficient. Because of the synchronized method, it will have a
performance hit.
Because synchronized key work in the method level work like a lock, permitting only one thread access a resource, this
is secure but increases
the time of execution degrading a performance and can stop a parallel execution this behavior can be unliked in resume
synchronized block are bottleneck for threads.

## Double Checked Locking Singleton

```java
public class BasicSingletonThreadSafeOptimized {
    private static volatile BasicSingletonThreadSafeOptimized instance;

    private BasicSingletonThreadSafeOptimized() {
    }

    public static synchronized BasicSingletonThreadSafeOptimized getInstance() {
        if (instance == null) {
            configureRacingConditions();
            synchronized (BasicSingletonThreadSafeOptimized.class) {
                if (instance == null) {
                    instance = new BasicSingletonThreadSafeOptimized();
                }
            }
        }
        return instance;
    }
}
```

This is one approach to minimize bottleneck behavior for threads, using the double-checked locking pattern. This pattern
is used to reduce the overhead of acquiring a lock every time the method is called. The volatile keyword ensures that
multiple threads handle the instance variable correctly when it is being initialized to the Singleton instance, only
first time, while instance is null, the synchronized block is executed and the instance is created. This implementation
increases performance, principally execution time. All the showed implementation has a lazy behavior and this needs
complex solution,
see the singleton pattern are very simply code and complexity increasing in race conditions and this can be
dangerous.See the next example for a better approach.

## Eager Loading Singleton

```java
public class BasicSingletonEagerLoad {
    private static final BasicSingletonEagerLoad instance = new BasicSingletonEagerLoad();

    private BasicSingletonEagerLoad() {
    }

    public static BasicSingletonEagerLoad getInstance() {
        configureRacingConditions();
        return instance;
    }
}
```

This is a simple way to create a singleton, this is a eager loading singleton, this is a way to create a singleton
beyond thread safe, this increase a performance because the synchronization are not necessary
and the singleton are initialized when class is loaded, so it is guaranteed that only one instance will be created
before runtime execution
however this behavior can be unnecessary if instance will not be used.

## Enum Singleton

```java
enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        configureRacingConditions();
        return INSTANCE;
    }
}
```

This implementation based in enum used the behavior to create a singleton instance, this implementation is thread safe,
and more performant than other BasicSingletonThreadSafe.java and singleton are loaded by the JVM when the class is
loaded,
so it is guaranteed that only one instance will be created before runtime execution, but can be unliked if singleton not
used.
this is recommended in Effective Java by Joshua Bloch.

## Bill Pugh Singleton

```java
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
```

This implementation is based on the Bill Pugh Singleton Design Pattern,
and it is recommended to use this implementation because it is thread safe, and it is not necessary to use synchronized
block, performance is better than the synchronized block, and it is a lazy loading implementation.
are a more used implementation in the Java world.

## How Singleton works in Spring Boot

Spring boot uses default singleton pattern to manager bean injection, this guarantees same bean usage in the
application.
Annotation like @Component, @Service, @Repository, @Controller, @Configuration, @Bean, @Scope are used to manager beans
in
the spring boot application, and the default scope is singleton, this is a good way to manager beans in the application,
and the
spring boot uses the Bill Pugh Singleton Design Pattern to manager beans in the application.

```java
public class BasicSingletonBillPugh {
    @Component
    public class BasicSingletonService {
    }
}
```
Off course if you want different instances of a bean can use @Scope annotation with "prototype" value e and framework 
injection mechanism will provide a new instances of object for each injection point.  

## Resume

In this way can consider a singleton pattern a simple pattern but can be dangerous if not implemented correctly, the
singleton pattern is a creational pattern
and is used to ensure that a class has only one instance and provides a global point of access to it,  
the singleton pattern is used to restrict the instantiation of a class and ensures that only one instance of the class
exists in the JVM. This pattern help
day to day systems to manager resources like logs, database connections, beans and has present in the Java world in many
libraries and frameworks like spring boot, and understand how it works are very usefully. Spring framework default work with the singleton
pattern no provides injection os managed beans, but if you want different instances of a bean can use @Scope annotation.
Dependent of scenario, SOLID and YAGNY principles can be not respected decreasing testability and maintainability, in this case
dependency injection can be appropriated way.

## Bibliography

- Effective Java by Joshua Bloch
- Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson, John
  Vlissides
- Head First Design Patterns by Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra
- GOF Design Patterns Reference
- https://www.baeldung.com/java-bill-pugh-singleton-implementation
- https://www.baeldung.com/java-singleton


