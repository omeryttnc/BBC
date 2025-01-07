package mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.BBC.constants.MockConstants.MYPORT;

/**
 * Manages the lifecycle of a WireMock server for mocking API responses.
 */
public class MockServer {

    private WireMockServer wireMockServer;

    /**
     * Starts the WireMock server on the specified port.
     * <p>
     * Configures the server to listen on localhost using the port defined in {@link org.BBC.constants.MockConstants#MYPORT}.
     * </p>
     */
    public void startServer() {
        wireMockServer = new WireMockServer(options().port(MYPORT));
        wireMockServer.start();

        WireMock.configureFor("localhost", MYPORT);
    }

    /**
     * Stops the WireMock server if it is running.
     */
    public void stopServer() {
        if (this.wireMockServer != null) {
            wireMockServer.stop();
        }
    }
}
