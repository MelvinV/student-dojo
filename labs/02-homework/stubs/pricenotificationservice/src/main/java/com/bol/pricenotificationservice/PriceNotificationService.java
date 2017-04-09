package com.bol.pricenotificationservice;

/**
 * Created by melvin on 9-4-2017.
 */
public class PriceNotificationService extends Thread {

    @Override
    public void run()
    {
        checkNotificationNeedsToFire();
    }

    private void checkNotificationNeedsToFire() {

        while(true)
        {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
