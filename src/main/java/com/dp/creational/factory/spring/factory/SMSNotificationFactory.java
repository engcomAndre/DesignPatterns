package com.dp.creational.factory.spring.factory;

import com.dp.creational.factory.spring.NotificationFactory;
import com.dp.creational.factory.spring.notification.SMSNotification;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SMSNotificationFactory extends NotificationFactory {

    @Override
    public SMSNotification createNotification() {
        return new SMSNotification();
    }
}
