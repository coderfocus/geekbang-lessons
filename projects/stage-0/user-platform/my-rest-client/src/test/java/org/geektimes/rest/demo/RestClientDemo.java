package org.geektimes.rest.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClientDemo {

    public static void main(String[] args) {
        postWithParams();

    }

    private static void get() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8888/hello/world")      // WebTarget
                .request() // Invocation.Builder
                .get();                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);
    }

    private static void postWithoutParams() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8888/hello/world1")      // WebTarget
                .request() // Invocation.Builder
                .post(null);                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);
    }


    private static void postWithParams() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8888/hello/world2")      // WebTarget
                .request(MediaType.APPLICATION_JSON_TYPE) // Invocation.Builder
                .post(Entity.entity(User.getInstance(), MediaType.APPLICATION_JSON_TYPE));                                     //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);
    }


}
