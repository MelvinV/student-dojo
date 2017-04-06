package com.bol.pricenotificationservice.external.api.utils;

/**
 * Created by melvin on 6-4-2017.
 */
public class HttpRequestXML {

    public void call()
    {
        String url = "http://www.google.com/search?q=httpClient";

        /*
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        */
    }

    public <T> T get(T object)
    {
        return (T)object;
    }
}
