package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import mock.MockServer;
import mock.ScheduleMock;
import utils.ScenarioContext;

public class Hooks {
    private final ScenarioContext scenarioContext;
    private final MockServer mockServer = new MockServer();
    private final ScheduleMock scheduleMock = new ScheduleMock();

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void setup() {
        scenarioContext.setResponse(null);
        scenarioContext.setScheduleMock(scheduleMock);
    }

    @Before("@scheduleMock")
    public void scheduleWireMock() {
        scenarioContext.setMocked(true);
        mockServer.startServer();
        scheduleMock.setupScheduleStub();
    }

    @Before("@scheduleNotFound")
    public void scheduleNotFoundWireMock() {
        scenarioContext.setMocked(true);
        mockServer.startServer();
        scheduleMock.setupScheduleNotFoundStub();
    }

    @After()
    public void tearDownWireMock() {
        mockServer.stopServer();
    }
}
