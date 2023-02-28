package tn.esprit.forumms.Mappers;

import tn.esprit.forumms.DTOentities.NotificationDto;
import tn.esprit.forumms.Entity.Notification;

public class NotificationMapper {
    public static NotificationDto mapToDto(Notification notification){
        NotificationDto notificationDto = NotificationDto.builder()
                .topic(notification.getTopic())
                .commentPost(notification.getCommentPost())
                .message(notification.getMessage())
                .build();
        return notificationDto;
    }

    public static Notification mapToEntity(NotificationDto notificationDto){
        Notification notification = Notification.builder()
                .topic(notificationDto.getTopic())
                .commentPost(notificationDto.getCommentPost())
                .message(notificationDto.getMessage())
                .build();
        return notification;
    }
}
