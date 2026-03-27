package com.wallet.application.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wallet.application.service.NotificationService;

@Component
public class NotificationScheduler {

    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendDailyReminder() {

        // Replace with DB logic later
        Long userId = 1L;
        String email = "user@gmail.com";

        notificationService.createNotification(
                userId,
                email,
                "Daily Reminder",
                "Don't forget to track your expenses today!",
                "REMINDER"
        );
    }
}