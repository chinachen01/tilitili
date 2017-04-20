package com.focus.tilitili.component.net;

import com.focus.tilitili.model.MovieBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

/**
 * Created by focus on 17/4/20.
 */

public interface ApiService {
    @GET("/v2/movie/subject/{id}")
    Flowable<MovieBean> getMovie(@Path("id") String id);

    @Multipart
    @PUT("/{path}")
    Flowable<Object> putFile(@Path("path") String path, @PartMap Map<String, RequestBody> map);
}
