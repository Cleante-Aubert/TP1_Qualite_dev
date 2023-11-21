package com.hamcrest.testing;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestCommonMatchersTest {

    @Test
    public void testBoolean() {
        assertThat(true, is(true));
        assertThat(false, is(false));
    }

    @Test
    public void testNull() {
        assertThat(null, nullValue());
        assertThat(new Object(), notNullValue());
    }

    @Test
    public void testEqual() {
        MyHamcrestClass instance1 = new MyHamcrestClass("java");
        MyHamcrestClass instance2 = new MyHamcrestClass("java");
        MyHamcrestClass instance3 = new MyHamcrestClass("test");
        assertThat(instance1, equalTo(instance2));
        assertThat(instance1, not(instance3));
    }

    @Test
    public void testSame() {
        MyHamcrestClass instance = new MyHamcrestClass("java");
        MyHamcrestClass instance1 = instance;
        assertThat(instance, sameInstance(instance1));
    }

    @Test
    public void testArray() {
        Integer[] array = new Integer[0];
        assertThat(array, emptyArray());
    }

    @Test
    public void testList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        assertThat(list1, equalTo(list2));
    }

    @Test
    public void testListElements() {
        List<Object> list = new ArrayList<>();
        Object first = new Object();
        Object second = new Object();
        list.add(first);
        list.add(second);

        assertThat(list, hasSize(2));
        assertThat(list, hasItem(first));

        assertThat(list, contains(first, second));
        assertThat(list, containsInAnyOrder(second, first));

        Object third = new Object();
        assertThat(list, not(hasItem(third)));
    }

    @Test
    public void testMapElements() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        assertThat(map, hasKey("key"));
        assertThat(map, not(hasKey("test")));
        assertThat(map, hasValue("value"));
        assertThat(map, hasEntry("key", "value"));
    }

    @Test
    public void testCombiningMatchers() {
        String firstname = "test1";
        String lastname= "java";
        Person person = new Person(firstname, lastname);
        assertThat(person, allOf(
                hasProperty("firstname", equalTo(firstname)),
                hasProperty("lastname", equalTo(lastname))
        ));
    }

    @Test
    public void testAnything() {
        String value = "java";
        assertThat(value, is(anything()));
        assertThat(null, anything());
    }
}