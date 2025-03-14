package com.dp.creational.singleton;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SingletonTest {

    @ParameterizedTest
    @Order(10)
    @ValueSource(classes = {BasicSingleton.class, BasicSingletonThreadSafe.class, BasicSingletonThreadSafeOptimized.class, EnumSingleton.class, BasicSingletonEagerLoad.class, BasicSingletonBillPugh.class})
    void shouldBeSameInstance(Class clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object instance1 = clazz.getMethod("getInstance").invoke(clazz);
        Object instance2 =  clazz.getMethod("getInstance").invoke(clazz);
        assertThat(instance1).isEqualTo(instance2);
    }


    @Test
    @Order(1)
    void testUnsafenessBasicSingleton() throws InterruptedException {
        Set<BasicSingleton> instances = new HashSet<>();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // Ensures all threads start at the same time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BasicSingleton instance = BasicSingleton.getInstance();
            synchronized (instances) {
                instances.add(instance);
            }
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.countDown(); // Release all threads at the same time

        for (Thread thread : threads) {
            thread.join();
        }

        assertThat(instances).hasSizeGreaterThan(1);
    }

    @Test
    @Order(1)
    void testSafenessBasicSingletonThreadSafe() throws InterruptedException {
        Set<BasicSingletonThreadSafe> instances = new HashSet<>();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // Ensures all threads start at the same time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BasicSingletonThreadSafe instance = BasicSingletonThreadSafe.getInstance();
            synchronized (instances) {
                instances.add(instance);
            }
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.countDown(); // Release all threads at the same time

        for (Thread thread : threads) {
            thread.join();
        }
        assertThat(instances).hasSize(1);
    }

    @Test
    @Order(10)
    void testSafenessBasicSingletonThreadSafeOptimized() throws InterruptedException {
        Set<BasicSingletonThreadSafeOptimized> instances = new HashSet<>();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // Ensures all threads start at the same time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BasicSingletonThreadSafeOptimized instance = BasicSingletonThreadSafeOptimized.getInstance();
            synchronized (instances) {
                instances.add(instance);
            }
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.countDown(); // Release all threads at the same time

        for (Thread thread : threads) {
            thread.join();
        }
        assertThat(instances).hasSize(1);
    }

    @Test
    @Order(1)
    void testSafenessEnumSingleton() throws InterruptedException {
        Set<EnumSingleton> instances = new HashSet<>();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // Ensures all threads start at the same time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EnumSingleton instance = EnumSingleton.INSTANCE;
            synchronized (instances) {
                instances.add(instance);
            }
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.countDown(); // Release all threads at the same time

        for (Thread thread : threads) {
            thread.join();
        }
        assertThat(instances).hasSize(1);
    }

    @Test
    @Order(1)
    void testSafenessBasicSingletonEagerLoad() throws InterruptedException {
        Set<BasicSingletonEagerLoad> instances = new HashSet<>();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // Ensures all threads start at the same time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BasicSingletonEagerLoad instance = BasicSingletonEagerLoad.getInstance();
            synchronized (instances) {
                instances.add(instance);
            }
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.countDown(); // Release all threads at the same time

        for (Thread thread : threads) {
            thread.join();
        }
        assertThat(instances).hasSize(1);
    }

    @Test
    @Order(1)
    void testSafenessBasicSingletonBillPugh() throws InterruptedException {
        Set<BasicSingletonBillPugh> instances = new HashSet<>();
        int threadCount = 1000;
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                latch.await(); // Ensures all threads start at the same time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BasicSingletonBillPugh instance = BasicSingletonBillPugh.getInstance();
            synchronized (instances) {
                instances.add(instance);
            }
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.countDown(); // Release all threads at the same time

        for (Thread thread : threads) {
            thread.join();
        }
        assertThat(instances).hasSize(1);
    }
}