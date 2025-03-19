package com.dp.creational.factory;

import com.dp.creational.factory.playground.Factory;
import com.dp.creational.factory.playground.FactorySomeThingFirst;
import com.dp.creational.factory.playground.FactorySomeThingSecond;
import com.dp.creational.factory.playground.ParameterizedFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FactoryTest {

    @Test
    void testFactory() {
        final Factory factoryFirst = new FactorySomeThingFirst();
        final Factory factorySecond = new FactorySomeThingSecond();

        assertThat(factoryFirst).isNotSameAs(factorySecond);
        assertThat(factoryFirst.doSomething()).isEqualTo("FactorySomeThingFirst doSomething");
        assertThat(factorySecond.doSomething()).isEqualTo("FactorySomeThingSecond doSomething");
    }

    @Test
    void testFactoryWithParameterizedFactory() {
        final Factory factoryFirst = ParameterizedFactory.createFactory("FactorySomeThingFirst");
        final Factory factorySecond = ParameterizedFactory.createFactory("FactorySomeThingSecond");

        assertThat(factoryFirst).isNotSameAs(factorySecond);
        assertThat(factoryFirst.doSomething()).isEqualTo("FactorySomeThingFirst doSomething");
        assertThat(factorySecond.doSomething()).isEqualTo("FactorySomeThingSecond doSomething");
    }

    @Test
    void testFactoryWithParameterizedFactoryNotExists() {
        assertThat(ParameterizedFactory.createFactory("Not exists")).isNull();
    }

}
