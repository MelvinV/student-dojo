package com.bol.pricenotificationservice;

import com.bol.pricenotificationservice.health.V1ApiHealthCheck;
import com.bol.pricenotificationservice.jdbi.PriceNotificationDao;
import com.bol.pricenotificationservice.resources.PriceNotificationServiceResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PriceNotificationServiceApplication extends Application<PriceNotificationServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new PriceNotificationServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "pricenotification-service";
    }

    @Override
    public void run(PriceNotificationServiceConfiguration configuration, Environment environment) throws Exception {
        PriceNotificationDao customerDao = new PriceNotificationDao();
        environment.jersey().register(new PriceNotificationServiceResource(customerDao));
        environment.healthChecks().register("api.v1", new V1ApiHealthCheck());
        new PriceNotificationService().start();
    }
}
