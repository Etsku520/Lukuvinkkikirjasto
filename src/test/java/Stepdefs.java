import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import io.*;
import data_access.*;

public class Stepdefs {
    App app;
    StubIO io;
    List<String> inputLines = new ArrayList<>();
    ItemDao itemDao = new InMemoryItemDao();

    @Given("^user starts the application$")
    public void program_is_start() throws Throwable {
        io = new StubIO(inputLines);
        app = new App(io, itemDao);
        app.run();
    }

    @Given("^item \"([^\"]*)\" exists in the application")
    public void item_exists_in_application(String item) throws Throwable {
        itemDao.addItem(item);
    }

    @Given("^command \"([^\"]*)\" is entered$")
    public void command_is_entered(String command) {
        inputLines.add(command);
    }

    @When("^user does nothing$")
    public void user_does_nothing() {
        io = new StubIO(inputLines);
        app = new App(io, itemDao);
        app.run();
    }

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String message) throws Throwable {
        assertTrue(io.getPrints().contains(message));
    }
}