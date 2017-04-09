package com.bol.pricenotificationservice.external.api.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

/**
 * Created by melvin on 6-4-2017.
 */
public class HttpRequestXML<T> {

    private final Class<T> typeClass;

    public HttpRequestXML(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    public T get(String url)
    {
        T result = null;

        try {

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);

            // add request header
            request.addHeader("User-Agent", USER_AGENT);
            HttpResponse response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer resultstr = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                resultstr.append(line);
            }

            JAXBContext context = JAXBContext.newInstance(typeClass);
            Unmarshaller unMarshaller = context.createUnmarshaller();

            StringReader stringReader = new StringReader(resultstr.toString());
            StreamSource streamSource = new StreamSource(stringReader);
            return unMarshaller.unmarshal(streamSource, typeClass).getValue();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
