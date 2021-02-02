package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class QueryProcessor {

    static Boolean perfectCube(int N)
    {
        int cube_root;
        cube_root = (int)Math.round(Math.cbrt(N));
     
        // If cube of cube_root is equals to N,
        // then print Yes Else print No
        if (cube_root * cube_root * cube_root == N) {
            return true;
        }
        else {
            return false;
        }
    }

    static Boolean perfectSquare(int N)
    {
        int sqrt;
        sqrt = (int)Math.round(Math.sqrt(N));
     
        // If cube of cube_root is equals to N,
        // then print Yes Else print No
        if (sqrt * sqrt == N) {
            return true;
        }
        else {
            return false;
        }
    }
        

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
        if (query.contains("minus")){
            String str = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbersString = Arrays.asList(str.trim().split(" "));
            List<Integer> numbers = new ArrayList<>();
            for(String s : numbersString) {
                numbers.add(Integer.valueOf(s));
            }
            Integer dif = 2 * numbers.get(0);
            for(int no : numbers){
                dif -= no;
            }
            return dif.toString();
        }
        if (query.toLowerCase().contains("largest")) {
            String str = query.replaceAll("[^-?0-9]+", " "); 
            List<String> numbersString = Arrays.asList(str.trim().split(" "));
            List<Integer> numbers = new ArrayList<>();
            for(String s : numbersString) {
                numbers.add(Integer.valueOf(s));
            }
            Integer max = Integer.MIN_VALUE;
            for (Integer elem : numbers) {
                max = Math.max(elem, max);
            }
            return String.valueOf(max);
        }
        if (query.contains("square") && query.contains("cube")){
            String space = "";
            String output = "";
            String str = query.replaceAll("[^-?0-9]+", " "); 
            List<String> numbersString = Arrays.asList(str.trim().split(" "));
            List<Integer> numbers = new ArrayList<>();
            for(String s : numbersString) {
                numbers.add(Integer.valueOf(s));
            }
            List<Integer> square_cube = new ArrayList<>();
            for(int no : numbers){
                if (perfectCube(no) && perfectSquare(no)){
                    output += space;
                    output += String.valueOf(no);
                    space = ", ";
                }

            }
            return output;
        }
        if (query.contains("multiplied")){
            String str = query.replaceAll("[^-?0-9]+", " "); 
            List<String> numbersString = Arrays.asList(str.trim().split(" "));
            List<Integer> numbers = new ArrayList<>();
            for(String s : numbersString) {
                numbers.add(Integer.valueOf(s));
            }
            Integer prod = 1;
            for(int no : numbers){
                prod *= no;
            }
            return prod.toString();
        }
        if (query.contains("primes")){
            String str = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbersString = Arrays.asList(str.trim().split(" "));
            List<Integer> numbers = new ArrayList<>();

            String space = "";
            String output = "";

            for(String s : numbersString) {
                numbers.add(Integer.valueOf(s));
            }

            for(Integer x : numbers){
                boolean flag = false;

                if (x == 1)
                    continue;

                for (int i = 2; i <= x / 2; i++) {
                    if(x % i == 0){
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    output += space;
                    output += String.valueOf(x);
                    space = ", ";
                }
            }

            return output;

        }
        return "";
    }
}
