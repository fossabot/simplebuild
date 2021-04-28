package features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.snapgames.simplebuild.Application;

public class ApplicationDefSteps {

    public Application app;

    @When("^I start the application without argument$")
    public void whenIStartTheApplicationWithoutArgument() {
        app = new Application();
        app.run(new String[] {});
    }

    @When("^I start the application with hard coded args$")
    public void whenIStartTheApplication() {
        app = new Application();
        app.run(new String[] { "arg1", "arg2" });
    }

    @When("^I start the application with width=(\\d+) and height=(\\d+)$")
    public void whenIStartTheApplicationWithWidthAndheight(int width, int height) {
        app = new Application(width, height);
        String[] argValues = { "viewport" };
        app.run(argValues);
    }

    @When("^I start the application with \"([^\"]*)\"$")
    public void whenIStartTheApplicationWithArg(String arg) {
        app = new Application();
        String[] argsValues = { arg };
        if (arg.contains(",")) {
            argsValues = arg.split(",");
        }
        app.run(argsValues);
    }

    @Then("^the application is started$")
    public void theApplicationIsStarted() {
        assertNotNull("the application is not started", app);
    }

    @Then("^title is \"([^\"]*)\"$")
    public void titleIsString(String titlev) {
        assertEquals("title attribute is not the good value", titlev, app.getTitle());
    }

    @Then("^commercial version is \"([^\"]*)\"$")
    public void versionIsString(String version) {
        assertEquals("version attribute is not the good value", version, app.getVersion());
    }

    @Then("^argument list has (\\d+) elements$")
    public void argumentListHasIntElement(int nbElements) {
        assertEquals("Application has not the right number of arguments", nbElements, app.getNbArgs());
    }

    @And("^argument (\\d+) is \"([^\"]*)\"$")
    public void andArgumentIntisString(int i, String value) {
        assertEquals("Argument N°" + i + " is not the right value", value, app.getArgs(i - 1));
    }

    @And("^width is (\\d+)$")
    public void andWidthisInt(int width) {
        assertEquals("Width has not been set correctly", width, app.getViewport().getWidth(), 0.1);
    }

    @And("^height is (\\d+)$")
    public void andHeightisInt(int height) {
        assertEquals("Height has not been set correctly", height, app.getViewport().getHeight(), 0.1);
    }

    @And("^viewport is created$")
    public void andViewportIsCreated() {
        assertNotNull("View has been initialized", app.getViewport());
    }
}
