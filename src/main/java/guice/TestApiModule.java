package qa.guice;

import com.google.inject.AbstractModule;
import qa.helpers.TestApi;

public class TestApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TestApi.class).toProvider(TestApiProvider.class);
    }

}