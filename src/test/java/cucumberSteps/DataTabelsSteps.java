package cucumberSteps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * Created by Mihail_Damasheuski on 6/24/2016.
 */
public class DataTabelsSteps {


    static int summ = 0;
    static int summ1 = 0;
    static int summ2 = 0;
    private static List<TableDefinition> data;
    private static Map<String,TableDefinition> dataMap;
    private ObjectMapper objectMapper;




    @Given("^simple data table$")
    public void dataTable(List<TableDefinition> data){

        this.data = data ;

        dataMap = new HashMap<>();


        for (TableDefinition tb : data){
            String key = tb.getPairId();
            dataMap.put(key,tb);
        }

        long threadId = Thread.currentThread().getId();
        System.out.println(String.format(">>> Current thread: %s <<<",threadId));
        System.out.print(data.get(1).getNumberA()+ "   ");
        System.out.println(data.get(1).getNumberB());
        System.out.print(data.get(0).getNumberA()+ "   ");
        System.out.println(data.get(0).getNumberB());
        System.out.print(data.get(2).getNumberA()+ "   ");
        System.out.println(data.get(2).getNumberB()+"\n");

        System.out.println(dataMap.get("pair001").getPairId()+"\n"+dataMap.get("pair002").getPairId()+"\n"+dataMap.get("pair003").getPairId()+"\n"+"\n");
}

    @When("^we summ NumberA and NumberB$")
    public void summThis(){
        summ =data.get(1).getNumberA()+data.get(1).getNumberB() ;
        summ1 =data.get(0).getNumberA()+data.get(0).getNumberB() ;
        summ2 =data.get(2).getNumberA()+data.get(2).getNumberB() ;
    }

    @Then("^summ should be equal ([^\"]*)$")
    public void qualizer(int x){
        Assert.assertTrue("Check the summ",summ==x);
        Assert.assertTrue("Check the summ",summ1==x);
        Assert.assertTrue("Check the summ",summ2==x);
    }

    public class TableDefinition{

        private String pairId;
        private Integer numberA;
        private Integer numberB;

        public TableDefinition(String pairId, Integer  numberA, Integer  numberB) {
            this.pairId = pairId;
            this.numberA = numberA;
            this.numberB = numberB;
        }

        public String getPairId() {
            return pairId;
        }

        public Integer getNumberA() {
            return numberA;
        }

        public Integer getNumberB() {
            return numberB;
        }
    }
}
