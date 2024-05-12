package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import utils.Context;
import utils.ScenarioContext;

public class Steps {

    ScenarioContext scenarioContext = new ScenarioContext();

    @Before
    public void beforeScenario() {
        System.out.println("before scenario");
    }

    @After
    public void afterScenario() {
        System.out.println("after scenario");
    }

    @Given("I execute before step")
    public void iExecuteBeforeStep() {
        System.out.println("Scenario - Before Step");
    }

    @Given("I use the parameterized step of {string}")
    public void iUseParametrizedStepOf(String p) {
        System.out.println("Scenario - Step 1 with parameter: " + p);
    }

    @Given("I run the step with {string} and {string}")
    public void iRunTheStepWithAnd(String arg0, String arg1) {
        System.out.println("Scenario Outline with parameters: " + arg0 + " " + arg1);
    }

    @Given("I set scenario context value {string}")
    public void iSetScenarioContextValue(String value) {
        System.out.println("ContextID "+Context.ID);
        scenarioContext.setContext(Context.ID, value);
    }

    @Given("I use scenario context value")
    public void iUseScenarioContextValue() {
        String sharedValue = scenarioContext.getContext(Context.ID).toString();
        System.out.println("Scenario Context with shared value: " + sharedValue);
    }

    @Given("I verify the column contains expected value")
    public void iVerifyColumnValuesInTableUsingQueryFromFileOnSchema(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        for (Map<String, String> form : data) {
            String columnName = form.get("columnName");
            String expectedResult = form.get("expectedValue");
            System.out.println("Data Table Scenario with values: " + columnName + " " + expectedResult);
        }
    }

    @Given("^I use variable (.*)")
    public void iUseVariableVar(String arg) {
        if (arg.equals("var1")){
            System.out.println("Regular Expression Scenario with value: " + arg);
        }
        else if(arg.equals("var2")){
            System.out.println("Regular Expression Scenario with value: " + arg);
        }
    }

    @Given("I use string {string}, int {int}, float {double} and boolean {string}")
    public void iUseStringIntFloatAndBoolean(String arg0, int arg1, double arg2, String arg3) {
        boolean f = Boolean.parseBoolean(arg3);
        System.out.println("Data Types Scenario with values: " + arg0 + " " + arg1 + " " + arg2 + " " + f);
    }

}
