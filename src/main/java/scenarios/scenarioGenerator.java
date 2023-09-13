package scenarios;

import io.gatling.javaapi.core.*;
import protocols.baseClass;
import java.io.IOException;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;


public class scenarioGenerator extends baseClass{

    public static ScenarioBuilder userActions;

    public static FeederBuilder.Batchable<String> fb = csv("status.csv").circular();

    public static ScenarioBuilder getScenarioBuilder(){

        userActions = CoreDsl.scenario("Get Pet Details")
                .repeat(1)
                .on(
                feed(fb)
                .exec(flushHttpCache())
                .exec(flushCookieJar())
                .exec(http("PetStoreURL").get(petgetuserurl)
                        .queryParam("status", "#{sold}")
                      //  .check(jsonPath().saveAs("Save in this variable")));
        ));

        return userActions;

    }
}
