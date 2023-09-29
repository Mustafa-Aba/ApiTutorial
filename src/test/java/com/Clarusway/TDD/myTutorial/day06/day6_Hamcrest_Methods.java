package com.Clarusway.TDD.myTutorial.day06;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class day6_Hamcrest_Methods {

    @Test
    public void checkPoint1(){

        Assert.assertEquals(3,3);// ilk parameter actual deger ikinci parameter expected deger

        MatcherAssert.assertThat(3, Matchers.is(3));//degerlerin eşitliği denkliği kontrol edilir.
        MatcherAssert.assertThat((1+2), equalTo(3));// is() metodundan az farklı
        MatcherAssert.assertThat((1+2), is(equalTo(3))); // yukardaki işlemlere benzer bir işlem
        MatcherAssert.assertThat((1+2), is(not(equalTo(4)))); // is not kullanımı
        MatcherAssert.assertThat((1+2), not(0)); //değilinin kontrolu yapılabilir
        MatcherAssert.assertThat(101, greaterThan(100));
        MatcherAssert.assertThat(101, greaterThanOrEqualTo(101));


    }
    @Test
    public void matchersString() {

        // string kontrolu için methodlar

        assertThat("clarus", equalTo("clarus"));

        assertThat("test executed", startsWith("test"));

        assertThat("test executed", endsWith("executed"));

        assertThat("test executed", containsString("ex"));

        assertThat("apple", containsStringIgnoringCase("APPle"));


        assertThat(null, nullValue());

        assertThat("", blankString());
    }
    @Test
    public void matcherCollection() {

        List<String> stringList = Arrays.asList("intermediate", "tanzania", "modify");
        List<Integer> intList = Arrays.asList(3, 34, 54, 34, 66, 123);
        List<Boolean> emptyList = new ArrayList<>();
        List<String> everyItemList = Arrays.asList("TR002", "TR344", "TR343", "TR6645");


        assertThat(intList,hasSize(6));// size() kontrolu için hasSize() metodu

        assertThat(stringList,contains("intermediate", "tanzania", "modify"));// contains() metodunda listin tüm elemanları olmalı sıra önemli

        assertThat(stringList,containsInAnyOrder("tanzania","intermediate", "modify"));// listin tüm elemanları olmalı ancak sıra önemsiz kontrol

        assertThat(emptyList, empty());

        assertThat(everyItemList,everyItem(startsWith("TR")));// her elemanı kontrol et "TR" ile başlıyor mu?

        assertThat(everyItemList,hasItem("TR6645"));// listte eleman var mı kontrolu

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


        assertThat(scores,hasEntry("Alice", 90));// Map te eleman kontrolunu yapar

        //hasKey
        Map<String, String> countries = new HashMap<>();
        countries.put("USA", "United States");
        countries.put("CA", "Canada");
        countries.put("UK", "United Kingdom");

        assertThat(countries,hasKey("USA"));// Map te key kontrolunu yapar

        //hasValue
        Map<Integer, String> colors = new HashMap<>();
        colors.put(1, "Red");
        colors.put(2, "Green");
        colors.put(3, "Blue");

        assertThat(colors, hasValue("Green"));// Map te value kontrolunu yapar

    }



}
