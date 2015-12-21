/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package gradle.udacity.com.jokeplatformbackendlib.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jokeplatform.Joke;

/** An endpoint class we are exposing */
@Api(
    name = "myApi",
    version = "v1",
    namespace = @ApiNamespace(
        ownerDomain = "backend.jokeplatformbackendlib.com.udacity.gradle",
        ownerName = "backend.jokeplatformbackendlib.com.udacity.gradle",
        packagePath=""
    )
)

public class MyEndpoint {
    @ApiMethod(name = "getJokes")
    public MyBean getJokes() {
        MyBean response = new MyBean();
        response.setData(new Joke().getJoke());
        return response;
    }

}

