package com.bol.pricenotificationservice.external.api.productservice;

import com.bol.pricenotificationservice.external.api.utils.HttpRequestXML;

/**
 * Created by melvin on 9-4-2017.
 */
public class ProductAPI {

    private static HttpRequestXML<Product> httpRequestHandler = new HttpRequestXML<>(Product.class);

    public static Product getProductByEan(String ean)
    {
        String url = String.format("http://localhost:8380/v1/product/%s", ean);
        return httpRequestHandler.get(url);
    }
}
