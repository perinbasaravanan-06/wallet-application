package com.wallet.application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.application.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdOrderByCreatedAtDesc(Long userId);
}