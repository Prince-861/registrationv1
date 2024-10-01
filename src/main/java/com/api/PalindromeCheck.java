package com.api;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String original = sc.nextLine();
        String cleaned = original.replaceAll("\\s+","").toLowerCase();// Here, the "" stands for the empty space from which we want to replace the whitespace with.
        //   \\s: This is a special symbol in regular expressions that stands for any whitespace character. It matches spaces, tabs, newlines, or any other space-like characters.
        //    +: This means "one or more." So, \\s+ matches one or more consecutive whitespace characters (like a single space, multiple spaces, or a mix of spaces and tabs).

//      Check if the cleaned string is a palindrome or not
        if(isPalindrome(cleaned)){
            System.out.println(original + " is a palindrome");
        }
        else{
            System.out.println(original + " is not a palindrome");
        }

    }
//    Method to check if the string is a Palindrome
    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left<right){
            if(str.charAt(left)!= str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
