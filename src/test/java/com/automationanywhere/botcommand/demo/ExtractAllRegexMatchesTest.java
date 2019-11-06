package com.automationanywhere.botcommand.demo;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Test(enabled=true)
public class ExtractAllRegexMatchesTest {

    ExtractAllRegexMatches command = new ExtractAllRegexMatches();

    @DataProvider(name = "data")
    public Object[][] dataTobeTested(){

        return new Object[][]{
                {" ([a-z]{4}) ","hello my name is bren yo",""}

        };
    }

    @Test(dataProvider = "data")
    public void aTests(String RegexPattern, String InputText, String Results){
        ListValue<String> d = command.action(RegexPattern,InputText);

        //List<Value> myList = output.get();
        List<Value> myList = d.get();
        assertEquals(myList.size(),2);
        ArrayList<String> ExpectedRes = new ArrayList<String>();
        ExpectedRes.add(" name ");ExpectedRes.add(" bren ");

        ArrayList<String> ActualRes = new ArrayList<String>();
        for(int i=0;i<myList.size();i++){
            //System.out.println("Debug:"+myList.get(i));
            String s = myList.get(i).toString();
            ActualRes.add(s);
        }
        assertEquals(ActualRes,ExpectedRes);



       // assertEquals(output,result);
    }
}
