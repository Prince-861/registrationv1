package com.api;

public class B {
    public static void main(String[] args) {
        B b1 = new B();
        b1.test(); // when we debug this code then we will get undefined because debugger doesn't have anything to display, the term "undefined" simply reflects that the method doesn't return anything meaningful for display purposes.

        int val  = b1.test1();
        System.out.println(val);

        C c1 = new C();
        c1.test2();

        D d1 = new D();
        d1.test();
    }
    public void test(){
        System.out.println("Hello");
    }
    public int test1(){
        System.out.println("hello");
        return 100;
    }

}
