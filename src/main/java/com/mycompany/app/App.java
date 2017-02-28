package com.mycompany.app;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = scan.next();
        System.out.println("Enter second string: ");
        String s2 = scan.next();
        System.out.println("The Levenshtein distance between "+s1+" and " + s2+" is "+StringUtils.getLevenshteinDistance(s1, s2));
    }
}