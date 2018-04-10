package practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Future;

public class AsyncHttpClient {

    private static void print(String s) {
        System.out.println(s);
    }

    public static class Person {
        Person() {}

        private String type;
        private String name;
        private String lastname;
        private int age;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().build();
        try {
            httpclient.start();

            // Created a JSON object using Requestly Library (https://www.requestly.in/library)
            HttpGet httpget = new HttpGet("https://goo.gl/SpJYdE");

            print("Executing request " + httpget.getRequestLine());

            Future<HttpResponse> future = httpclient.execute(httpget, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse response) {
                    try {
                        print("Response in onComplete: " + response.getEntity().getContent());
                        ObjectMapper objectMapper = new ObjectMapper();
                        Person p = objectMapper.readValue(response.getEntity().getContent(), Person.class);
                        print(p.name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Exception ex) {
                    print("Request failed" + Arrays.toString(ex.getStackTrace()));
                }

                @Override
                public void cancelled() {
                    print("Request cancelled");
                }
            });

            HttpResponse response = future.get();

            print("Response after future.get(): " + response.getEntity().getContent());
            print("Shutting down");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
    }
}
