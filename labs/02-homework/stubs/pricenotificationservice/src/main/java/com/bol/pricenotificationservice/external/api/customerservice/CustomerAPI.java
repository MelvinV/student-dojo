package com.bol.pricenotificationservice.external.api.customerservice;

import com.bol.pricenotificationservice.external.api.utils.HttpRequestXML;

/**
 * Created by melvin on 6-4-2017.
 */
public class CustomerAPI {

    private static HttpRequestXML<Customer> httpRequestHandler = new HttpRequestXML<>(Customer.class);

    public static Customer getCustomerById(Long customerNumber)
    {
        String url = String.format("http://localhost:8280/v1/customer/%d", customerNumber);
        return httpRequestHandler.get(url);
    }
}
