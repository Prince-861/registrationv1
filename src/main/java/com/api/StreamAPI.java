package com.api;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args){
//        List<Integer> nums = Arrays.asList(4,5,7,8,9);
//        Stream<Integer> stream = nums.stream();
//        long count = stream.count();
//        System.out.println(count);
//
////        stream.forEach(n-> System.out.println(n) );
//
//
//        List<Integer> collect = nums.stream().filter(n -> n % 2 == 1).sorted().collect(Collectors.toList());
//        System.out.println(collect);
//
//        Predicate<Integer> predi = new Predicate<Integer>(){
//            @Override
//            public boolean test(Integer n){
//                if(n%2==1){
//                    return true;
//                }
//                else{
//                    return false;
//                }
//            }
//        } ;
//        System.out.println(predi.test(45));
//
//
////        Using reduce method
//        List<Integer> data = Arrays.asList(3,2,1,5,6,8);
//        Integer result = nums.stream().filter(n -> n % 2 == 1).sorted().map(n -> n * 2).reduce(0, (c, e) -> c + e);
//        System.out.println(result);
//
////        Working on multiple streams:-
//        List<Integer> data1 = Arrays.asList(4,8,7,8,3);
//        Stream<Integer> data2 = data1.stream();
//        Stream<Integer>sorteddata = data2.sorted();
//        Stream<Integer> distinct = sorteddata.distinct();
//        sorteddata.forEach(n->System.out.println(n));
//        distinct.forEach(n->System.out.println(n));
//        distinct.forEach(n->System.out.println(n));//Streams can only be consumed once.


//      String s = "ashish";
//        IntStream chars = s.chars();
//
//        chars.forEach(n-> System.out.println((char)n));
//         int arr[] = {1,2,3,4};
//        Arrays.stream(arr).forEach(x->System.out.println(x));
//
//        HashMap<Integer,String> map= new HashMap<>();
//        map.put(0,"ashish");
//        map.put(1,"shubham");
//        map.put(2,"rahul");
        //map.forEach((a,b)-> System.out.println(a+" "+b));


//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//       // entries.forEach(x-> System.out.println(x.getValue()));
//        for(Map.Entry<Integer, String> a:entries ){
//            System.out.println(a.getKey());
//            System.out.println(a.getValue());
//
//
//        }


//        List<Integer> data=Arrays.asList(10,56,89,86,34,77,55);
//        Map<Boolean, List<Integer>> collect = data.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
//        System.out.println(collect);


//        String s ="Ashish";
//        Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//        System.out.println(collect);

//        Integer arr[] = {1,2,2,3};
//        List<Integer> list = Arrays.asList(arr);
//        list.stream().collect(Collectors.groupingBy(s->s, Collectors.counting())).forEach((a,b)-> System.out.println(a+" "+b));

    }


}
