package com.focus.tilitili.component.net;

import com.focus.tilitili.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by focus on 16/12/27.
 */

public class MockInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        String path = chain.request().url().uri().getPath();
        if(BuildConfig.DEBUG && needMock(path)) {
            String responseString = getJsonString(path);
            response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        } else {
            response = chain.proceed(chain.request());
        }
        return response;
    }

    private boolean needMock(String path) {
        switch (path) {
            case "/rest/album/list":
            case "/asdf":
                return true;
                default:
                    return false;
        }
    }

    private String getJsonString(String path) {
        switch (path) {
            case "/rest/album/list":
                return "[\n" +
                        "{\n" +
                        "\"name\": \"test\",\n" +
                        "\"artist\": \"ww\",\n" +
                        "\"cover\": \"http://192.168.36.163:8082/music/album/cover/1480490410416.jpg\",\n" +
                        "\"releaseTime\": \"2016-11-08\",\n" +
                        "\"recordCompany\": \"ww\",\n" +
                        "\"id\": \"584682fccccd61c2d3166a90\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"name\": \"test唯一\",\n" +
                        "\"artist\": \"qqq\",\n" +
                        "\"cover\": \"http://192.168.36.163:8082/music/album/cover/1480490487570.jpeg\",\n" +
                        "\"releaseTime\": \"2016-11-30\",\n" +
                        "\"recordCompany\": \"q\",\n" +
                        "\"id\": \"584682fccccd61c2d3166a91\"\n" +
                        "}\n" +
                        "]";
            default:
                return "";
        }
    }
}
