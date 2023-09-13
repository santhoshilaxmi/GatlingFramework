
import io.gatling.javaapi.core.Simulation;
import protocols.httpProtocols;
import scenarios.scenarioGenerator;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class simulations extends Simulation {

    {
        try{
            setUp(
                    scenarioGenerator.getScenarioBuilder().injectOpen(
                            rampUsers(10).during(10)
                    ).protocols(httpProtocols.getHttpProtocol())
            );
        }catch(Exception e){
            throw new RuntimeException();

        }
    }
}
