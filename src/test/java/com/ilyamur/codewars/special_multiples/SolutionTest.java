package com.ilyamur.codewars.special_multiples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSomething() {
        assertEquals(6, CountMultiples.countSpecMult(3, 200));
        assertEquals(6, CountMultiples.countSpecMult(3, 209));
        assertEquals(6, CountMultiples.countSpecMult(3, 210));
        assertEquals(7, CountMultiples.countSpecMult(3, 211));
    }
}
