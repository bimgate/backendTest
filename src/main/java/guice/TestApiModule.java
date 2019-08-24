package guice;

import com.google.inject.AbstractModule;
import helpers.TestApi;

public class TestApiModule extends AbstractModule {

    protected void configure() {
        bind(TestApi.class).toProvider(TestApiProvider.class);
    }

}