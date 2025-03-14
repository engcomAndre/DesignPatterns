package com.dp.creational.singleton;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;


class SingletonTest {

    @Test
    void shouldBeSameInstance() {
        BasicSingleton instance1 = BasicSingleton.getInstance();
        BasicSingleton instance2 = BasicSingleton.getInstance();
        assert(instance1 == instance2);
    }

    /*
    * This evaluates the unsafeness of the BasicSingleton implementation the Set instances should have more than one instance of same object
    * but the expected result is that the Set instances should have only one instance of the same object this is fail because the BasicSingleton is not thread safe
    * and the getInstance method is not synchronized, so the threads can instantiate more than one instance of the singleton class
    * */
    @Test
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


    /*
     * This evaluates the safeness of the BasicSingleton implementation the Set instances should have same instance of same class
     * but this approach is thread safe, because the getInstance method is synchronized, so the threads can instantiate only one instance of the singleton class
     * this increase a performance issue, because the synchronized block is a bottleneck
     * */
    @Test
    void testSafenessBasicSingleton() throws InterruptedException {
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
}