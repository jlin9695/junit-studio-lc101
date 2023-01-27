package test;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import java.rmi.server.ExportException;

import static main.BalancedBrackets.hasBalancedBrackets;
import static org.junit.Assert.*;

public class BalancedBracketsTest {

    public String str1 = "[This is a balanced Bracket]";
    public String str2 = "[This is an unbalanced Bracket.";

    //TODO: add tests here
    @Test
    public void balanceTest() {

        assertEquals(true,hasBalancedBrackets(str1) );
    }

    @Test
    public void unbalancedTest(){
        assertEquals(false, hasBalancedBrackets(str2));
    }

    @Test
    public void isFalse(){
        assertFalse(hasBalancedBrackets("This is a totally unbalanced bracket]"));
    }

    @Test
    public void isTrue(){
        assertTrue(hasBalancedBrackets("[This is a balanced statement]"));
    }

    @Test
    public void isSame(){
        assertSame(hasBalancedBrackets("This is balanced."),hasBalancedBrackets("[This is balanced too.]"));
    }

    @Test
    public void isNotSame(){
        assertNotSame(hasBalancedBrackets("[This is unbalanced."), hasBalancedBrackets("This is balanced."));
    }

    @Test
    public void isEqualWhenTrue(){
        assertEquals(hasBalancedBrackets("This is balanced."),hasBalancedBrackets("This is also balanced."));
    }
    @Test
    public void isEqualWhenFalse(){
        assertEquals(hasBalancedBrackets("]This is unbalanced."),hasBalancedBrackets("This is also unbalanced.]"));
    }

    @Test
    public void isTrueWhenEmpty(){
        assertTrue(hasBalancedBrackets(""));
    }

    @Test
    public void isEqualWhenWrongSpot(){
        assertEquals(hasBalancedBrackets("]Like this."), hasBalancedBrackets("And like] This."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenNull(){
        String test = null;
        hasBalancedBrackets(test);
        fail("You must input a string!");

    }

    @Test
    public void outOfOrderIsFalse(){
        assertFalse(hasBalancedBrackets("]This String is now unbalanced."));
    }



}
