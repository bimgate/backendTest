package helpers;

import entities.Posts;
import entities.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

public interface TestApi {

    @Headers("Content-Type: application/json")
    @GET("/users")
    Call<List<Users>> getUser();

    @Headers("Content-Type: application/json")
    @GET("/posts")
    Call<List<Posts>> getPosts(@Query("userId") Integer id);

}
