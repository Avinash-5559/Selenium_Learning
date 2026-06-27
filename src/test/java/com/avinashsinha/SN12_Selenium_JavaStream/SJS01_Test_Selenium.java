package com.avinashsinha.SN12_Selenium_JavaStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SJS01_Test_Selenium {

    @Test
    public void test_regular() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Rohan");
        names.add("Anmol");
        names.add("Arun");
        names.add("Ram");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public void test_streamFilter() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Rohan");
        names.add("Anmol");
        names.add("Arun");
        names.add("Ram");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        long d = Stream.of("Abhijeet", "Rohan", "Anmol", "Arun", "Ram").filter(s ->
        {
            s.startsWith("A");
            return true;
        }).count();

        System.out.println(d);

        // print all the names of ArrayList

        /*
            names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        */

        names.stream().filter(s -> s.length() > 4).limit(1)
                .forEach(s -> System.out.println(s));

    }

    @Test
    public void test_mapStream() {

        // Print name which have last letter as 'a' with Uppercase
        Stream.of("Abhijeet", "Roma", "Anmol", "Arun", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println("Uppercase of Last Letter as 'a' : " + s));

        // Print name which have first letter as 'a' with Uppercase and Sorted
        List<String> names1 = Arrays.asList("Anmol", "Roma", "Arun", "Abhijeet", "Ram");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println("Uppercase & Sorted of Last Letter as 'a' : " + s));

        // Merging two different lists
        ArrayList<String> names2 = new ArrayList<>();
        names2.add("Man");
        names2.add("Woman");
        names2.add("Boy");
        names2.add("Girl");

        Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
        //newStream.sorted().forEach(s -> System.out.println(s));

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Man"));
        Assert.assertTrue(flag);

    }

    @Test
    public void test_streamCollect() {

        List<String> ls = Stream.of("Abhijeet", "Roma", "Anmol", "Arun", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));

        // Print unique number and sort the array
        List<Integer> listValues = Arrays.asList(3, 5, 8, 7, 9, 1, 4, 4, 5, 3, 6, 8, 7, 1);
        listValues.stream().distinct().forEach(s -> System.out.println(s));

        List<Integer> values = listValues.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Sorted Distinct : " + values.get(2));

    }

}