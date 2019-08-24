package qa.guice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.inject.Provider;
import qa.helpers.TestApi;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class TestApiProvider implements Provider<TestApi> {


    public TestApi get() {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AllureOkHttp3())
                .build();

        String baseUrl = "https://jsonplaceholder.typicode.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        return retrofit.create(TestApi.class);
    }
}
