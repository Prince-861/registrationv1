package com.api;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Stream_API_Practice {
    public static void main(String[] args) {
//1.       Filter Even no. from a list
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> evenNos = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNos);

//        2. Finding the Maximum Number in a List
//        List<Integer> data = Arrays.asList(22, 45, 67, 89, 12, 34);
//        Optional<Integer> max = data.stream().max(Integer::compareTo);
////        System.out.println(max); //Optional[89]
//        System.out.println(max.get());

//         PTN:- When we are throwing the exception here then the local variable we are getting as the Integer type

//         List<Integer> numbers = Arrays.asList(3,9,2,7,10,5);
//         int maxNumbers = numbers.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
//         System.out.println(maxNumbers);

//        In below code,
//         orElseThrow(NoSuchElementException::new): This is used to handle the case where no maximum value is found (for example,
//         if the list were empty). If the stream is empty, it will throw a NoSuchElementException with a new exception object.

//        List<Integer> numbers = Arrays.asList(3, 9, 2, 7, 10, 5);
//        int maxNumber = numbers.stream()
//                .max(Integer::compareTo)
//                .orElseThrow(NoSuchElementException::new);
//        System.out.println(maxNumber);  // Output: 10


//     3. Sum of Elements in a list
//      Here we are using reduce method to find the sum of all the numbers in the list.
//        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Integer sum = data.stream().reduce(0, Integer::sum);
//        System.out.println(sum);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);

//       4. Find the sum of all the elements in the floating point value
//        List<Double> numbers = Arrays.asList(1.1, 2.1, 3.1, 4.1, 5.1);
//        List<Float> numbers = Arrays.asList(1.1f, 2.1f, 3.1f, 4.1f, 5.1f);
//      By default, decimal literals in Java (such as 1.1, 2.1, etc.) are treated as double values,
//      not float values. So, when you try to create a list using Arrays.asList() with Float as the generic type, it leads to a type mismatch error,
//      because Java is expecting Float but you are providing double literals.
//       To explicitly define the numbers as Float values, you need to append an f or F to the literals (e.g., 1.1f, 2.1f).


//        The issue you're facing occurs because the Stream API does not have a built-in method called mapToFloat().
//        Instead, Java provides specialized streams for primitive types like IntStream, LongStream, and DoubleStream,
//        but it does not directly provide a FloatStream. However, you can use mapToDouble() for working with float values, and convert them to double for stream processing.
//            List<Float> numbers = Arrays.asList(1.1f,2.1f,3.1f,4.1f,5.1f);
//            numbers.stream().mapToFloat(Float::floatValue).sum();

//            List<Double> numbers = Arrays.asList(1.1, 2.1, 3.1, 4.1, 5.1);
//            double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
//            System.out.println(sum);

//        List<Float> numbers1 = Arrays.asList(1.1f,2.1f,3.1f,4.1f,5.1f);
//        double sum = numbers1.stream().mapToDouble(Float::floatValue).sum();//When you run the stream and calculate the sum, you're telling Java to convert those float numbers into double for more accuracy. That's why you use mapToDouble(Float::floatValue).
//        System.out.println(sum); // Output: 15.499999642372131


//        5. Working with the float value
//        List<Float> numbers =  Arrays.asList(1.1f, 2.1f,3.1f,4.1f,5.1f);
//        double sum = numbers.stream().mapToDouble(Float::doubleValue).sum();
//        System.out.println(sum);

//        6. Find the First Element Greater than 5
//          List<Integer> numbers = Arrays.asList(1, 2, 3, 6, 4, 5);
//          Integer ans = numbers.stream().filter(x -> x > 5).findFirst().orElseThrow(NoSuchElementException::new);
//          System.out.println(ans);

//        7. Convert List of Strings to Uppercase
//        List<String> names = Arrays.asList("john", "jane", "doe");
//        List<String> ans = names.stream().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(ans);

//        8. Find the longest String in a List
//        if the length of the two strings is same and they are of the maximum length then it will return the first string with the maximum length.
//            List<String> words = Arrays.asList("stream", "api", "interview", "questions", "interface");
//            String ans = words.stream().max(Comparator.comparingInt(String::length)).orElseThrow(NoSuchElementException::new);
//            System.out.println(ans);

//        9. If we have maximum length ties between multiple strings then find the last element having the maximum length.
//        To find the maximum length string from a list where, in the case of ties, the last occurrence of the maximum-length string should be returned,
//        you can use the Stream API along with a reverse stream approach or by using reduce. Here's one way to approach the problem:
//        List<String> words = Arrays.asList("apple", "banana", "cherry", "pear", "mango","pineapple", "mineapple","wineapple");
//        int maxLength = words.stream().mapToInt(String::length).max().orElse(0);//till (String::length),it will produce this as the o/p (the lengths are [5, 6, 6, 4, 5, 9]), for the list ["apple", "banana", "cherry", "pear", "mango", "pineapple"],and max() will return the maximum length from the collection of list.
//
//
//        String longestFromEnd = words.stream().filter(word->word.length() == maxLength).reduce((first,second) -> second).orElse(null);
//        System.out.println(longestFromEnd);
//---------------------------------------------------------------------------------------
//        List<String> words = Arrays.asList("hello", "pineapple", "wineapple", "mineapple");
//        IntStream intStream = words.stream().mapToInt(String::length);
//
//        System.out.println(intStream);//java.util.stream.ReferencePipeline$4@45ff54e6
////        intStream.forEach(n-> System.out.print(n + " ")); // 5 9 9 9
//        int maxL = intStream.max().orElse(0);
//        System.out.println(maxL); // 9
//
//        String longestStringFromEnd = words.stream().filter(word -> word.length() == maxL).reduce((first, second) -> second).orElse(null);
//        System.out.println(longestStringFromEnd);//mineapple
//        _________________________________________________________________________________


//        Given a list of Strings, count how many strings start with the letter 'A'
//        List<String> data = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
//        long a = data.stream().filter(t -> t.startsWith("A")).count();
//        System.out.println(a);

//        List<Integer> data = Arrays.asList(22, 45, 67, 89, 12, 34);
//        Optional<Integer> max = data.stream().max(Integer::compareTo);
//      Both will return the same ans
//        System.out.println(max.get());
//        max.ifPresent(System.out::println);

//        List<String> data = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
//        long count = data.stream().filter(x->x.startsWith("A")).count();
//        System.out.println(count);


//        10.  Given a list of strings, collect them into a Map with the string as the key and its length as the value.
//        List<String> data = Arrays.asList("Dog", "Elephant", "Horse", "Cat");
//        Map<String, Integer> map = data.stream().collect(Collectors.toMap(s -> s, String::length));
//        System.out.println(map);

//        11.  Given a list of strings, join them into a single string separated by commas.
//         List<String> data = Arrays.asList("Java", "Python", "C++", "JavaScript");
//         String result = data.stream().collect(Collectors.joining(","));
//         System.out.println(result);

//         12.  FlatMap Operation: - Given a list of lists of integers, flatten it into a single list.
//            List<List<Integer>> data = Arrays.asList(
//                    Arrays.asList(1, 2, 3),
//                    Arrays.asList(4, 5, 6),
//                    Arrays.asList(7, 8, 9)
//            );
//            List<Integer> flattened = data.stream().flatMap(List::stream).collect(Collectors.toList());
//            System.out.println(flattened); //[1, 2, 3, 4, 5, 6, 7, 8, 9]


//        13.    Given a list of integers, partition them into even and odd numbers.
//            List<Integer> data = Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24);
//            Map<Boolean, List<Integer>> partitioned = data.stream().collect(Collectors.partitioningBy(t -> t % 2 == 0));
//            System.out.println(partitioned); //{false=[3, 9, 15, 21], true=[6, 12, 18, 24]}

//        14. Print duplicate element in the list
//               List<Integer> data = Arrays.asList(3,6,12,15,18,21,6,24);
//               HashSet<Integer> seen = new HashSet<>();
//               List<Integer> duplicates = data.stream().filter(n -> !seen.add(n)).collect(Collectors.toList());
//               System.out.println(duplicates); //[6] it will return ans as a list[6] because we are using the Collectors.toList() here.

//                List<Integer> data = Arrays.asList(3,6,12,15,18,21,6,24);
//                HashSet<Integer> seen = new HashSet<>();
//                data.stream().filter(n->!seen.add(n)).forEach(System.out::println);  //6


//                  List<Integer> data = Arrays.asList(3,6,9,12,15,18,21,6,24);
//                  HashSet<Integer> seen = new HashSet<>();
//                  List<Integer> collect1 = data.stream().filter(n -> !seen.add(n)).collect(Collectors.toList());
//                  System.out.println(collect1);
//                  collect1.forEach(System.out::println);

//        15. Given a list of strings, group them by their length.
//            List<String> data = Arrays.asList("Dog", "Elephant", "Cat", "Horse", "Goat");
//            Map<Integer, List<String>> grouped = data.stream().collect(Collectors.groupingBy(String::length));
//            System.out.println(grouped);

//        16. Given a list of Person objects, group them by age
//        class Person {
//            String name;
//            int age;
//            Person(String name, int age) {
//                this.name = name;
//                this.age = age;
//            }
//        }
//        List<Person> people = Arrays.asList(
//                new Person("John", 25),
//                new Person("Anna", 30),
//                new Person("Mike", 25),
//                new Person("Sara", 30)
//        );
//
//        Map<Integer, List<Person>> collect = people.stream().collect(Collectors.groupingBy(e -> e.age));
//        collect.forEach((age, persons)->{
//            System.out.println("Age" + age + ": " + persons);
//        });

//        17. Print the second character from the string using the Stream API
//          String str = "hello"; // str.chars() converts the string into an IntStream of the Unicode values of each character.
//          IntStream chars = str.chars();
////          System.out.println(chars);// java.util.stream.IntPipeline$Head@14514713
////          chars.forEach(i->System.out.print(i+" ")); // 104 101 108 108 111
//          IntStream skip = chars.skip(1);
//          System.out.println(skip); //java.util.stream.SliceOps$2@4459eb14
//
//          skip.forEach(i->System.out.println(i));

//            OptionalInt first = skip.findFirst();
//            System.out.println(first);//OptionalInt[101]
//
//            int asInt = first.getAsInt();
//            System.out.println(asInt); // 101
//            System.out.println((char) asInt); //e // here we are doing downcasting because we are moving from integer datatype to the character datatype.

//              String str = "Hello";
//              int asInt = str.chars().skip(5).findFirst().getAsInt();
//              System.out.println((char)asInt);//Here we will get NoSuchElementException as we have skipped the entire length of the string.


//        18. Check if a list contains only unique elements:-
//               List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
////             Convert the list to a set and compare the size
//               Set<Integer> collect = numbers.stream().collect(Collectors.toSet());
//               System.out.println(collect);//[1, 2, 3, 4, 5]
//               boolean b = collect.size() == numbers.size();
//        if(b){
//            System.out.println("The list contains only unique elements");
//        }
//        else{
//            System.out.println("The list contains duplicates elements");
//        }

//                System.out.println(b?"unique":"not unique");

//         In one line:-
//        boolean b1 = numbers.stream().collect(Collectors.toSet()).size() == numbers.size();
//        System.out.println(b1?"unique":"not unique");


//        allMatch() method:- The allMatch() method in Stream API is used to check  if all elements
//        of a stream match a given condition(predicate). It returns true if every element satisfies the condition,
//      and false if at least one element fails to meet the condition.

//Ex:-     19. Checking if all numbers are positive:
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4,-5);
//        boolean b = numbers.stream().allMatch(n -> n > 0);
//        System.out.println(b);//false

//         20. Check if all Strings have more than three characters.
//        List<String> words = Arrays.asList("apple", "banana", "pear", "kiwi");
//        boolean b1 = words.stream().allMatch(word -> word.length()> 3);
//        System.out.println(b1);//true


//      21. Checking if all numbers are even
//        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11);
//        boolean b = numbers.stream().allMatch(n -> n % 2 == 0);
//        System.out.println(b);//false

//        22. Count the no. of vowels present in the list
//        String words = "hello world";
////        define the list of vowels
//        List<Character> vowels = Arrays.asList('a','e','i','o','u');
////        convert the string to a stream of characters and count the vowels.
////        chars() converts the string to an IntStream of characters
//        long count = words.toLowerCase()
//                .chars() //converts the string to an IntStream of characters.
//                .mapToObj(c -> (char) c) //converts each int to a char
//                .filter(vowels::contains) //it will give us the character stream
//                .count();
//        System.out.println(count);

//        String str = "welcome to the world";
//        List<Character> vowels = Arrays.asList('a','e','i','o','u');
//        Stream<Character> characterStream = str.chars().mapToObj(c -> (char) c).filter(vowels::contains);
//        System.out.println(characterStream); //java.util.stream.ReferencePipeline$2@6659c656
//        characterStream.forEach(c-> System.out.print(c + " ") ); //e o e o e o


        String str = "welcome to the world";
        long count = str.chars().mapToObj(c -> (char) c).filter(c -> "aeiou".indexOf(c) != -1).count();
        System.out.println(count);
// Advantages of Method References:-

//Readability: Method references provide a clearer syntax compared to lambda expressions, making the code easier to read.
//Conciseness: They can reduce boilerplate code, allowing for shorter and more direct expressions.
//Reusability: If the method is already defined elsewhere, you can reference it instead of reimplementing the logic in a lambda.


    }
}
