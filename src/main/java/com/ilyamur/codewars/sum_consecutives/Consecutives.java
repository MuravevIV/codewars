package com.ilyamur.codewars.sum_consecutives;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Consecutives {

    public static void main(String[] args) {

        List<Integer> s = Arrays.asList(1,4,4,4,0,4,3,3,1);

        List<Integer> ans = s.stream().collect(Collectors.groupingBy(n -> n, Collectors.toList())).entrySet().stream().map(a -> a.getValue().stream().mapToInt(n -> n).sum()).collect(Collectors.toList());
    }

  /*  public static List<Integer> sumConsecutives(List<Integer> s) {
        Map<Integer, List<Integer>> collect = s.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));
    }*/
}
