package protocols;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.bodyString;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class httpProtocols extends baseClass{

    public static HttpProtocolBuilder getHttpProtocol(){
        HttpProtocolBuilder httpProtocol = null;

        httpProtocol = http.baseUrl(petbaseURl)
                .check(bodyString().saveAs("responseBody"))
                .check(status().is(200));

        return httpProtocol;

    }



}
