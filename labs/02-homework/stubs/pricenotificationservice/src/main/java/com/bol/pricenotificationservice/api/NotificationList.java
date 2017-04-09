package com.bol.pricenotificationservice.api;

import java.util.List;

/**
 * Created by melvin on 6-4-2017.
 */
public class NotificationList {

    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
