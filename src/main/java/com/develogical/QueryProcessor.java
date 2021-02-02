package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("shakespear")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("meme")) {
            return "Some dope meme ";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "MissingTheRibbonGuy";
        }
        if (query.contains("plus")){
            String str = query.replaceAll("[^-?0-9]+", " "); 
            List<String> numbersString = Arrays.asList(str.trim().split(" "));
            List<Integer> numbers = new ArrayList<>();
            for(String s : numbersString) {
                numbers.add(Integer.valueOf(s));
            }
            Integer sum = 0;
            for(int no : numbers){
                sum += no;
            }
            return sum.toString();
        }
        if (query.toLowerCase().contains("largest")) {
            String[] parts = query.split(":");
            String numbers = parts[1];
            String[] numbers_list = numbers.split(",");
            Integer max = Integer.MIN_VALUE;
            for (String elem : numbers_list) {
            max = Math.max(Integer.parseInt(elem.trim()), max);
            }
            return String.valueOf(max);
        }
        return "";
    }
}
