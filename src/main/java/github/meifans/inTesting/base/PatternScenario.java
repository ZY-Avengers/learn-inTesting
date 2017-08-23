package github.meifans.inTesting.base;

import org.junit.Test;

import java.util.regex.Pattern;

import lombok.extern.java.Log;

import static org.junit.Assert.assertEquals;

/**
 * Created by Meifans on 2017/5/11.
 */
@Log
public class PatternScenario {

    @Test
    public void testSplit(){
        Pattern pattern = Pattern.compile("-");
        String[] actual = pattern.split("zhao-si-yu-fei");

        assertEquals("si", actual[1]);
        assertEquals("fei",actual[3]);
    }
}
