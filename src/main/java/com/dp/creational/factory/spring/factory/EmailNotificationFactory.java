package com.dp.creational.factory.spring.factory;

import com.dp.creational.factory.spring.Notification;
import com.dp.creational.factory.spring.NotificationFactory;
import com.dp.creational.factory.spring.notification.EmailNotification;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
