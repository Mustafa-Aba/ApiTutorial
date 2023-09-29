package com.Clarusway.TDD.Lesson.Day6;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BasicMatchers {


    @Test
    public void checkPoint1() {


        Assert.assertEquals(3, 3);

        assertThat(3, Matchers.is(3)); // Basit assertion yapma degelerin denkligini test ediyoruz.

        assertThat(3, equalTo(3)); // Basit assertion yapma degelerin denkligini test ediyoruz.

        assertThat(3, is(equalTo(3))); // Kombinasyon islemi yuklerda yaptigimiz assertionlarla ayni islemi yapiyor.

        assertThat(5, not(0)); // Olmamasi gereken degerin assertion islemini gereceklestiriyoruz

        assertThat(101, greaterThan(100)); // Beklenen degerin actual degerden buyuklugunu test ediyoruz.

        assertThat(101, greaterThanOrEqualTo(101));

        assertThat(101, lessThan(110));


        assertThat(101, is(not(equalTo(103))));


    }

    @Test
    public void matchersString() {


        assertThat("clarus", equalTo("clarus"));


        assertThat("test executed",startsWith("test"));

        assertThat("test executed",endsWith("executed"));

        assertThat("test executed",containsString("ex"));

        assertThat(null,nullValue());

        assertThat("",blankString());

        assertThat("apple", containsStringIgnoringCase("APPle"));


    }


    @Test
    public void matcherCollection() {

        List<String> stringList = Arrays.asList("intermediate", "tanzania", "modify");
        List<Integer> intList = Arrays.asList(3, 34, 54, 34, 66, 123);
        List<Boolean> emptyList = new ArrayList<>();
        List<String> everyItemList = Arrays.asList("TR002", "TR344", "TR343", "TR6645");


        assertThat(intList,hasSize(6));

        assertThat(stringList,contains("intermediate", "tanzania", "modify"));

        assertThat(stringList,containsInAnyOrder("tanzania","intermediate", "modify"));

        assertThat(emptyList, empty());

        assertThat(everyItemList,everyItem(startsWith("TR")));

        assertThat(everyItemList,hasItem("TR6645"));

        assertThat(everyItemList,hasItems("TR6645","TR344"));

        System.out.println("---------------------------");
        List<Integer> scores = Arrays.asList(90, 95, 88, 92, 89);

        assertThat(scores,everyItem(greaterThan(85)));

    }

    @Test
    public void assertionMap() {
        //hasEntry
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 88);


        assertThat(scores,hasEntry("Alice", 90));

        //hasKey
        Map<String, String> countries = new HashMap<>();
        countries.put("USA", "United States");
        countries.put("CA", "Canada");
        countries.put("UK", "United Kingdom");

        assertThat(countries,hasKey("USA"));

        //hasValue
        Map<Integer, String> colors = new HashMap<>();
        colors.put(1, "Red");
        colors.put(2, "Green");
        colors.put(3, "Blue");

        assertThat(colors, hasValue("Green"));

    }




}
