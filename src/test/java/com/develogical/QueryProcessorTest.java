package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespear"), containsString("playwright"));
    }

    @Test
    public void knowsName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("MissingTheRibbonGuy"));
    }

    @Test
    public void knowsSums() throws Exception {
        assertEquals(queryProcessor.process("what is 5 plus 1 plus 8"), "14");
    }
    
    @Test
    public void largestNumber() throws Exception {
	assertEquals(queryProcessor.process("which of the following numbers is the largest:10,20,5"), "20"); 
    }
}
