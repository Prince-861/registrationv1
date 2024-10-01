package com.api;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A {
    public static void main(String[] args) {
//        Predicate Functional Interface
//        It will take an input and based on the input given it will produce the boolean value output.
//        means this interface is used for the comparison
//        Predicate<Integer> val = x->x>300;
//        boolean result = val.test(100);
//        System.out.println(result);

//---since here Generic is String therefore the value that will be given to the x will be String.
//        Predicate<String> val = x->x.equals("mike");
//        boolean result = val.test("mike");
//        System.out.println(result);


//        -------------find the no. which is greater than the 100 in a new List.
//        List<Integer> data = Arrays.asList(100, 5, 332, 899, 200, 343);
////        Input to this filter function is Predicate Functional Interface
////        stream() will take the value one by one from the list and give it to the x
//        List<Integer> newData = data.stream().filter(x -> x > 100).collect(Collectors.toList());
//        System.out.println(newData);


////        ----------find the name which is starting from the letter "m"---------
//        List<String> data = Arrays.asList("mike","adam","madam","hello","alex","mikasa");
//        List<String> newData = data.stream().filter(x -> x.startsWith("m")).collect(Collectors.toList());
//        System.out.println(newData);

//        ---------------------find the words that ends with the letter "m"
//          List<String> data = Arrays.asList("mikasa", "ram", "shyam", "trello");
//          List<String> newData = data.stream().filter(x->x.endsWith("m")).collect(Collectors.toList());
//          System.out.println(newData);


//        ------------find the even no. from the given list-------------------
//          List<Integer> data = Arrays.asList(11,12,13, 14, 143, 434,90,321);
//          List<Integer> newData = data.stream().filter(t->t%2==0).collect(Collectors.toList());
//          System.out.println(newData);


//        ------------find the odd no. from the given list-------------------
//        List<Integer> data = Arrays.asList(11,12,13, 14, 143, 434,90,321);
//        List<Integer> newData = data.stream().filter(t->t%2 != 0).collect(Collectors.toList());
//        System.out.println(newData);

//        Function Functional Interface
//        It takes input and produces output
//          Function<String,Integer> x = s->s.length();
//          Integer val = x.apply("mike");
//          System.out.println(val);

//        -------------------------
//        Function<String, Integer> x = t->t.length();//here we are calculating the output as length that means it will return the Integer as the output
//        Integer val = x.apply("adamant");//here we are passing the input as string "adamant"
//        System.out.println(val);

//        ------------find the square of a number------------
//          Function<Integer, Integer> x = t->t*t;
//          Integer val = x.apply(20);
//          System.out.println(val);


//        ----------here we are getting the squares of each no. present in the list-------------
//           List<Integer> data = Arrays.asList(10,20,35,12,14);
//           List<Integer> newData = data.stream().map(x->x*x).collect(Collectors.toList());
//           System.out.println(newData);

        //        ----------here we are getting the cubes of each no. present in the list-------------
//        map() does not uses Functional Predicate, it uses Function Functional Interface
//        List<Integer> data = Arrays.asList(10,20,3,4,5);
//        List<Integer> newData = data.stream().map(x->x*x*x).collect(Collectors.toList());
//        System.out.println(newData);

//      Convert every letter in the list to the Uppercase letter
//        List<String> data = Arrays.asList("mike","stallin","adam");
//        List<String> newData = data.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
//        System.out.println(newData);


//        Convert every letter in the list to the lowercase letter
//          List<String> data = Arrays.asList("MIKE", "STALLIN", "ADAM");
//          List<String> newData = data.stream().map(x->x.toLowerCase()).collect(Collectors.toList());
//          System.out.println(newData);


//    ---------  Give me the length of the each word in the list--------------
//        List<String> data = Arrays.asList("MIKE", "STALLIN", "ADAM");
//        List<Integer> newData = data.stream().map(x->x.length()).collect(Collectors.toList());
//        System.out.println(newData);

//    -----------  Sort the given String present in the List--------------------
//        sorted() method sorts both the integer as well as the string in the ascending order
//        List<String> data = Arrays.asList("MIKE", "STALLIN", "ADAM");
//        List<String> newData = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(newData);

//     ------------ Sort the given list in the ascending order-------------
//        List<Integer> data = Arrays.asList(10,20,3,4,5);
//        List<Integer>newData = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(newData);

//        -------------sort the given list in the descending order--------------------------
//        List<Integer> data = Arrays.asList(10,12,21,122,90);
//        List<Integer> newData = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(newData);

//        --------------If we want to remove the duplicate names from the given list then we can use the distinct---------
//        List<String> data = Arrays.asList("mike","adam","mike","sonu","alex","sam","sam");
//        List<String>newData = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(newData);

//        --------------give me those names which has length equal to 4 --------------------------
//        List<String> data = Arrays.asList("mike","adam","mike","sonu","alex","sam","sam");
//        List<String> newData = data.stream().filter(x->x.length()==4).collect(Collectors.toList());
//        System.out.println(newData);


//        CONSUMER FUNCTIONAL INTERFACE(It takes one input and produces no output)
//        It represents an operation that accepts a single input argument and returns no result.
//          Consumer<String> x = s->System.out.println(s);
//          x.accept("mike");
//          System.out.println(x);

//        Example:--
//          List<String> names = Arrays.asList("Alice","Bob","Charlie");
//          Consumer<String> val = s->System.out.println(s);
//          names.forEach(val);

//        -----------------09/09/2024(Next Class continuation)-------------------
//        Below list don't have the value now, it has the address of the object, and every object has some value
        List<Employee> data = Arrays.asList(
                new Employee(1, "mike", 5000),
                new Employee(2, "stallin", 4000),
                new Employee(3, "adam", 7000),
                new Employee(4,"max",4900),
                new Employee(5, "trello",5000)
        );

//   ---------- give me those employee object which has the salary greater than 4000.------------------
//        List<Employee> newData = data.stream().filter(e -> e.getSal() > 4000).collect(Collectors.toList());
//        System.out.println(newData);
//
//        for(Employee emp: newData){
//            System.out.print(emp+" ");
//        }
//
//          for(Employee emp:newData){
//              System.out.println(emp.getId());
//              System.out.println(emp.getName());
//              System.out.println(emp.getSal());
//
//          }

//        give me those employee names whose name starts with the letter "m".
//        List<Employee> newData = data.stream().filter(e -> e.getName().startsWith("m")).collect(Collectors.toList());
//        for(Employee emp:newData){
//            System.out.println(emp.getId());
//            System.out.println(emp.getName());
//            System.out.println(emp.getSal());
//        }

//        groupingBy() method
//        Here, based on the salary, we are grouping the list of Employee object
//        Map<Integer, List<Employee>> newData = data.stream().collect(Collectors.groupingBy(e -> e.getSal()));
//        System.out.println(newData);
//        newData.forEach((sal, employees)->{
//            System.out.println("Salary: " + sal);
//            for (Employee emp : employees) {
//                System.out.println("Name: " + emp.getName());
//                System.out.println("Salary: " + emp.getSal());
//                System.out.println("ID: " + emp.getId());
//            }
//        });


//        List<Integer> newData = data.stream().map(Employee::getSal).collect(Collectors.toList());
//        System.out.println(newData); //[5000, 4000, 7000, 4900, 5000]

//          -------we have to find the sum of these no.s present in the list------------
//        Whenever we are storing the value in the list it is getting stored as the "Wrapper class object" and not the primitive datatypes(like int, boolean, short, byte etc.)

//        List<Integer> data = Arrays.asList(10,20,13,15);//these values are first wrapped in the object and then placed as the collections in the list.
//        We cannot do the addition on object directly we have to convert that object into the integer first
//        Integer:: intValue --> it is the Method Reference,(we use Method Reference to access the method of a particular class).
//        int result = data.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(result);


//        By using lambda expression, if we want to calculate the sum of the no.s present in the list then,
//        List<Integer> data = Arrays.asList(10,20,13,20);
//        int sum = data.stream().mapToInt(x -> x).sum();
//        System.out.println(sum);


//        Program to find the maximum number from the given list
//        List<Integer> numbers = Arrays.asList(3,5,7,2,8,10);
//        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
//        System.out.println(max.get());

//        Program to find the maximum number from the given list using the Lambda's expression
//        List<Integer> numbers = Arrays.asList(3,23,4,2,32,5);
//        Optional<Integer> max = numbers.stream().max((a, b) -> a.compareTo(b));
//        System.out.println(max.get());



//        Program to find the minimum no. from the given list
//        List<Integer> numbers = Arrays.asList(3,5,7,2,8,10);
//        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
//        System.out.println(min.get());

//        Program to find the minimum no. from the given list using the lambda's expression
//        List<Integer> numbers = Arrays.asList(3,5,7,2,8,10);
//        Optional<Integer> min= numbers.stream().min((a, b) -> a.compareTo(b));
//        System.out.println(min.get());

//        Count the occurrences of each element
//          List<Integer> numbers = Arrays.asList(1,2,2,3,3,3,4,4,4,4);
//          Map<Integer, Long> occurrences = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//          System.out.println(occurrences);


//        Find the first no. greater than 5
//            List<Integer> numbers = Arrays.asList(1,3,4,5,7,9);
//            Optional<Integer> first = numbers.stream().filter(n -> n > 5).findFirst();
//            System.out.println(first.get());

//         Remove duplicates and sort the list
//        List<Integer> numbers = Arrays.asList(3,5,3,8,5,1,9);
//        List<Integer> result = numbers.stream().distinct().sorted().collect(Collectors.toList());
//        System.out.println(result);



//      Give me the longest length of string present in the list
//        List<String> data1 = Arrays.asList("interface", "Integers", "class", "laguna", "hinata", "malayalam");
//        String newData = data1.stream().max(Comparator.comparingInt(String::length)).orElseThrow(NoSuchElementException::new);
//        System.out.println(newData);


//        List<Employee> collect = data.stream().filter(e -> e.getSal() > 4000).collect(Collectors.toList());
//        System.out.println(collect);
//        for(Employee e: collect){
//            System.out.println(e.getId());
//            System.out.println(e.getName());
//            System.out.println(e.getSal());
//
//        }



//      Count the occurrences of each element in the list:-
//        List<Integer> numbers = Arrays.asList(1,2,2,2,3,3,4,4,4,5,5,5,6,7,7,7);
//        Map<Integer, Long> collect = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        System.out.println(collect);








    }



}
