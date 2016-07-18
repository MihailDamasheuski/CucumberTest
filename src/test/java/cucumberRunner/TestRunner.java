package cucumberRunner;

import org.junit.runner.JUnitCore;

/**
 * Main class to trigger JUnit execution
 */
public class TestRunner {

    public static void main(String[] args){
        JUnitCore runner = new JUnitCore();
        runner.run(cucumberRunner.class,cucumberRunnerOne.class);
    }
}
