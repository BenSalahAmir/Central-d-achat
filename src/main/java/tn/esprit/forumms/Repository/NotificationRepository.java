package tn.esprit.forumms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.forumms.Entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}