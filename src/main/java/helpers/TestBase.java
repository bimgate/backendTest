package qa.tests;

import com.google.inject.Inject;
import guice.TestApiModule;
import helpers.TestApi;
import org.testng.annotations.Guice;

@Guice(modules = {TestApiModule.class})
public class TestBase {

    @Inject
    protected TestApi testApi;

}
