package dev.zilioti.web.dao;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import dev.zilioti.web.model.Post;


import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.channels.UnresolvedAddressException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;


public class PostsDAO {


    private Logger logger = Logger.getLogger(getClass().getName());

    // The BlogId for the Blogger Buzz blog
    String BLOG_ID = "1482420237361379345";
    String API_KEY = "AIzaSyD2rlkLNTokhdxgoEJ8AHe4enxggX-X3Lo";

    public Post getLastestPost(){
        String response = doRequest();
        if(response != null){
            return jsonToObject(response);
        }else{
            return null;
        }
    }

    private Post jsonToObject(String response){
        HashMap<String, Object> map = new Gson().fromJson(response, HashMap.class);
        ArrayList items = (ArrayList) map.get("items");
        LinkedTreeMap map2 = (LinkedTreeMap) items.get(0);
        Post post = new Post();
        post.setUrl(map2.get("url").toString());
        post.setTitle(map2.get("title").toString());
        post.setPublished(ZonedDateTime.parse(map2.get("published").toString()));
        return post;
    }

    private String doRequest(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://www.googleapis.com/blogger/v3/blogs/"+BLOG_ID+"/posts/?key="+API_KEY+"&orderBy=published&maxResults=1&fetchBodies=false"))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                return response.body();
            }


        } catch (URISyntaxException | InterruptedException | IOException | UnresolvedAddressException e) {
            e.printStackTrace();
        }
        return null;
    }

}
