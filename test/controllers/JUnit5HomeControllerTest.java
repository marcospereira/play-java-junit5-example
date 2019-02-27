package controllers;

// Use JUnit 5 test APIs
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import akka.stream.Materializer;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;


public class JUnit5HomeControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

}

// Let's have a custom `WithApplication` class that uses @BeforeEach and @AfterEach from JUnit 5, instead of
// @Before and @After from JUnit 4.
class WithApplication {

    protected Application app;

    /**
     * The application's Akka streams Materializer.
     */
    protected Materializer mat;

    /**
     * Override this method to setup the application to use.
     *
     * @return The application to use
     */
    protected Application provideApplication() {
        return Helpers.fakeApplication();
    }

    /**
     * Provides an instance from the application.
     *
     * @param clazz the type's class.
     * @param <T> the type to return, using `app.injector.instanceOf`
     * @return an instance of type T.
     */
    protected <T> T instanceOf(Class<T> clazz) {
        return app.injector().instanceOf(clazz);
    }

    @BeforeEach // JUnit 5
    public void startPlay() {
        app = provideApplication();
        Helpers.start(app);
        mat = app.asScala().materializer();
    }

    @AfterEach // JUnit 5
    public void stopPlay() {
        if (app != null) {
            Helpers.stop(app);
            app = null;
        }
    }

}
