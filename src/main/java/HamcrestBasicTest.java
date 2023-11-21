package com.hamcrest.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

// hamcrest: matcher library
public class HamcrestBasicTest {

    @Test
    public void testEquals() {
        // junit5 assertions
        Assertions.assertEquals(20, 10 + 10);
        Assertions.assertEquals(20, 10 + 10, "test method failed message");

        // hamcrest
        assertThat(10 + 10, is(20));
        assertThat("assert failed message",10 + 10, is(20));

        assertThat(10 + 10, lessThan(200));
        assertThat(10 + 10, is(lessThan(100)));
    }
}