package com.dp.creational.factory.spring.factory;

import com.dp.creational.factory.spring.Notification;
import com.dp.creational.factory.spring.NotificationFactory;
import com.dp.creational.factory.spring.notification.DefaultNotification;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new DefaultNotification();
    }
}
