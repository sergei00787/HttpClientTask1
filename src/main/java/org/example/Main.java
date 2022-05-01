package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {

    public static ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws IOException {

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build()) {


            HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");

            try (CloseableHttpResponse response = httpClient.execute(request)) {

                HttpEntity entity = response.getEntity();

                List<FactAboutCat> facts = mapper.readValue(entity.getContent(), new TypeReference<>() {
                });

                facts.stream()
                        .filter(fact -> fact.getUpvotes() != null && Integer.parseInt(fact.getUpvotes()) > 0)
                        .forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }

    }
}



