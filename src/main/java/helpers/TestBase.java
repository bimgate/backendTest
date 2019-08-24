package helpers;

import com.google.inject.Inject;
import guice.TestApiModule;
import org.testng.annotations.Guice;

@Guice(modules = {TestApiModule.class})
public class TestBase {

    @Inject
    protected TestApi testApi;

}
