package com.bol.pricenotificationservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.bol.pricenotificationservice.api.Notification;
import com.bol.pricenotificationservice.api.NotificationList;
import com.bol.pricenotificationservice.jdbi.PriceNotificationDao;
import com.codahale.metrics.annotation.Timed;

import java.util.Arrays;

@Path("/v1")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class PriceNotificationServiceResource {
    private final PriceNotificationDao priceNotificationDao;

    public PriceNotificationServiceResource(PriceNotificationDao priceNotificationDao) {
        this.priceNotificationDao = priceNotificationDao;
    }

    @GET
    @Path("customer/{customerNumber}/notifications")
    @Timed
    public NotificationList getNotifications(@PathParam("customerNumber") Long customerNumber) {
        NotificationList notificationList = new NotificationList();
        notificationList.setNotifications(Arrays.asList()/*priceNotificationDao.getProducts()*/);
        return notificationList;
    }

    @PUT
    @Path("customer/{customerNumber}/notifications/{ean}")
    @Timed
    public void addNotification(Notification notification, @PathParam("customerNumber") Long customerNumber, @PathParam("ean") String ean) {
        priceNotificationDao.addNotification(customerNumber, notification);
    }

    @DELETE
    @Path("customer/{customerNumber}/notifications/{ean}")
    @Timed
    public String deleteNotification(@PathParam("customerNumber") Long customerNumber, @PathParam("ean") String ean) {
        return "";
    }
}
