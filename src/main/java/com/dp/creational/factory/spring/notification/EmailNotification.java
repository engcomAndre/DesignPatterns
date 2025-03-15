package com.dp.creational.factory.spring.notification;

import com.dp.creational.factory.spring.Notification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification {

    @Override
    public String notifyUser() {
        return "Email Notification";
    }
}
