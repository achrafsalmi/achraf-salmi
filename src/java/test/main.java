/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author serv-web
 */
import java.io.*;
import okhttp3.*;
public class main {
  public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder()
      .build();
    MediaType mediaType = MediaType.parse("text/plain");
    RequestBody body = RequestBody.create(mediaType, "{\r\n    \"telephone\":\"70665051\",\r\n    \"type\":\"2\"\r\n\r\n}");
    Request request = new Request.Builder()
      .url("https://dark.bee.net.tn:12443/Dark_Vador_WS/api/activation_client")
      .method("POST", body)
      .addHeader("Content-Type", "text/plain")
      .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }
}
