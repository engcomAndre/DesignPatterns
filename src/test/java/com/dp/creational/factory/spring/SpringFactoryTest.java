package com.dp.creational.factory.spring;


import com.dp.creational.factory.spring.factory.DefaultNotificationFactory;
import com.dp.creational.factory.spring.factory.EmailNotificationFactory;
import com.dp.creational.factory.spring.factory.SMSNotificationFactory;
import com.dp.creational.factory.spring.notification.DefaultNotification;
import com.dp.creational.factory.spring.notification.EmailNotification;
import com.dp.creational.factory.spring.notification.SMSNotification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = {
    DefaultNotification.class,
    SMSNotification.class,
    EmailNotification.class,
    ContextNotificationFactory.class,
    DefaultNotificationFactory.class,
    EmailNotificationFactory.class,
    SMSNotificationFactory.class
})
public class SpringFactoryTest {

    @Autowired
    private DefaultNotification defaultNotification;

    @Autowired
    private SMSNotification smsNotification;

    @Autowired
    private EmailNotification emailNotification;

    @Autowired
    private ContextNotificationFactory contextNotificationFactory;

    @Test
    void testSpringFactory() {
        assertThat(defaultNotification).isNotSameAs(smsNotification);
        assertThat(defaultNotification).isNotSameAs(emailNotification);
        assertThat(smsNotification).isNotSameAs(emailNotification);

        assertThat(defaultNotification).isInstanceOf(Notification.class);
        assertThat(emailNotification).isInstanceOf(Notification.class);
        assertThat(smsNotification).isInstanceOf(Notification.class);
    }

    @Test
    void testDefaultNotification() {
        assertThat(defaultNotification.notifyUser()).isEqualTo("Default Notification");
    }

    @Test
    void testSMSNotification() {
        assertThat(smsNotification.notifyUser()).isEqualTo("SMS Notification");
    }

    @Test
    void testEmailNotification() {
        assertThat(emailNotification.notifyUser()).isEqualTo("Email Notification");
    }

    @Test
    void testNotificationFactory(){
        assertThat(new DefaultNotificationFactory().createNotification()).isInstanceOf(DefaultNotification.class);
        assertThat(new EmailNotificationFactory().createNotification()).isInstanceOf(EmailNotification.class);
        assertThat(new SMSNotificationFactory().createNotification()).isInstanceOf(SMSNotification.class);
    }

    @Test
    void testContextNotificationFactory() {
        assertThat(contextNotificationFactory.getNotification("SMS")).isInstanceOf(SMSNotification.class);
        assertThat(contextNotificationFactory.getNotification("EMAIL")).isInstanceOf(EmailNotification.class);
        assertThat(contextNotificationFactory.getNotification("DEFAULT")).isInstanceOf(DefaultNotification.class);
    }
}
