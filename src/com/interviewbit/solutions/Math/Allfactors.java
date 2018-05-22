package com.interviewbit.solutions.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Allfactors {

    public static void main(String[] args) {
        ArrayList<Integer> result = allFactorsEditorial(38808);
        //ArrayList<Integer> result = allFactors(82944);
        for (int x:
            result){
            System.out.print(" " + x);
        }
    }

    public static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                result.add(i);
                if(i != Math.sqrt(a)) {
                    result.add(a / i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static ArrayList<Integer> allFactorsEditorial(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 1; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                result.add(i);
                if(i != Math.sqrt(a)) {
                    linkedList.addFirst(a/i);
                }
            }
        }
        result.addAll(linkedList);
        return result;
    }
}
