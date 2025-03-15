package com.dp.creational.factory.spring;

import com.dp.creational.factory.spring.notification.DefaultNotification;
import com.dp.creational.factory.spring.notification.EmailNotification;
import com.dp.creational.factory.spring.notification.SMSNotification;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextNotificationFactory {

    private final ApplicationContext context;

    public ContextNotificationFactory(ApplicationContext context) {
        this.context = context;
    }

    public Notification getNotification(String notificationType) {
        return switch (notificationType) {
            case "SMS" -> context.getBean(SMSNotification.class) ;
            case "EMAIL" -> context.getBean(EmailNotification.class);
            default -> context.getBean(DefaultNotification.class);
        };
    }
}
