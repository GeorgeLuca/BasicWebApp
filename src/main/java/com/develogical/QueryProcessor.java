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
            System.out.println(numbersString);
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
        return "";
    }
}
