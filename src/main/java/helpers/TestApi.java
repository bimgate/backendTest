package qa.helpers;

import qa.entities.Posts;
import qa.entities.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.util.List;

public interface TestApi {

    @Headers("Content-Type: application/json")
    @GET("/users")
    Call<List<Users>> getUser();

    @Headers("Content-Type: application/json")
    @GET("/posts?userId={userId}")
    Call<List<Posts>> getPosts(@Path("userId") Integer userId);



}
