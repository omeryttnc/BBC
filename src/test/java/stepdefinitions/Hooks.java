package stepdefinitions;

import io.cucumber.java.Before;
import org.BBC.utils.ScenarioContext;

public class Hooks {
    private final ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void setup(){
        scenarioContext.setResponse(null);
    }

}
