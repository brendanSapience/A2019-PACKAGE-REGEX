package com.automationanywhere.botcommand.demo;

import com.automationanywhere.botcommand.data.Value;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(enabled=true)
public class ReplaceWithRegexExpressionTest {

    ReplaceWithRegexExpression command = new ReplaceWithRegexExpression();

    @DataProvider(name = "data")
    public Object[][] dataTobeTested(){

        return new Object[][]{
                {"[\\r\\n]+","hello my name\n is \nbren","","hello my name is bren"}

        };
    }

    @Test(dataProvider = "data")
    public void aTests(String RegexPattern, String InputText, String ReplaceWith, String Results){
        Value<String> d = command.action(InputText,RegexPattern,ReplaceWith);
        String output = (String)d.get();
        //System.out.println("Debug:"+output);
        assertEquals(output,Results);





       // assertEquals(output,result);
    }
}
