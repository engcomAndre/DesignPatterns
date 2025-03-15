package com.dp.creational.singleton.spring;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = { BasicSingletonService.class, BasicScopedSingletonService.class })
class BasicSingletonServiceTest {

    @Nested
    class SameSingletonServiceTest {

        @Autowired
        private BasicSingletonService basicSingletonService1;

        @Autowired
        private BasicSingletonService basicSingletonService2;

        @Test
        void testSameBasicSingletonService() {
            assertThat(basicSingletonService1).isSameAs(basicSingletonService2);
        }
    }

    @Nested
    class NotSameSingletonServiceTest {

        @Autowired
        private BasicScopedSingletonService basicSingletonService1;

        @Autowired
        private BasicScopedSingletonService basicSingletonService2;

        @Test
        void testNotSameBasicSingletonService() {
            assertThat(basicSingletonService1).isNotSameAs(basicSingletonService2);
        }
    }

}