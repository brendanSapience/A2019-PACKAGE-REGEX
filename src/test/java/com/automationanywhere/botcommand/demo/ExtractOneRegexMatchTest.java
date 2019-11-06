package com.automationanywhere.botcommand.demo;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Test(enabled=true)
public class ExtractOneRegexMatchTest {

    ExtractOneRegexMatch command = new ExtractOneRegexMatch();

    @DataProvider(name = "data")
    public Object[][] dataTobeTested(){

        return new Object[][]{
                {" ([a-z]{4}) ","hello my name is bren yo",1," bren "},
                {" ([a-z]{4}) ","hello my name is bren yo",0," name "},
                {" ([a-z]{4}) ","n 1 2 3 4 5",0,""}

        };
    }

    @Test(dataProvider = "data")
    public void aTests(String RegexPattern, String InputText, double MatchNumber, String Results){
        Value<String> d = command.action(RegexPattern,MatchNumber,InputText);
        String output = (String)d.get();
        //System.out.println("Debug:"+output);
        assertEquals(output,Results);





       // assertEquals(output,result);
    }
}
