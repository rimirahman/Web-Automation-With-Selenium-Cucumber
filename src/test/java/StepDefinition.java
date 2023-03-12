import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

    public class StepDefinition extends Setup {
        LoginPage loginPage;

        @Given("I am on the GitHub landing page")
        public void i_am_on_the_github_landing_page() {
              driver.get("https://github.com/");
        }

        @When("I search for {string}")
        public void i_search_for(String searchInput) {
            loginPage=new LoginPage(driver);
            loginPage.doSearch(searchInput);
        }

        @Then("I should see a count of matching results")
        public void i_should_see_a_count_of_matching_results() {
            // Find the results count element and verify that it exists
            WebElement resultsCount = driver.findElement(By.cssSelector("h3"));
            Assert.assertNotNull(resultsCount);
        }

        @Then("the first result should be {string}")
        public void the_first_result_should_be(String expectedProject) {
            // Find the first result element and verify that its title matches the expected project
            WebElement firstResult = driver.findElement(By.cssSelector("ul.repo-list li:nth-child(1)"));
            String actualProject = firstResult.findElement(By.cssSelector("h3 a")).getText();
            Assert.assertEquals(expectedProject, actualProject);
        }

        @Given("I click the {string} button in the footer")
        public void i_click_the_button_in_the_footer(String about) {
            // Find the About button element in the footer and click it
            WebElement aboutButton = driver.findElement(By.linkText(about));
            aboutButton.click();
        }

        @Then("Assert i am on About page")
        public void assert_i_am_on_about_page() {

            String actual_Text=driver.findElement(By.className("h1-mktg")).getText();
            String expected_Text="Let's build from here";
            Assert.assertTrue(actual_Text.contains(expected_Text));

        }

        @After
        public void tearDown() {
            driver.quit();
        }


}
