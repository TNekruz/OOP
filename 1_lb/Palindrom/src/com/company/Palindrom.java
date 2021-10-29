package com.company;
import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {

        //считываем строку и разделяем их по словам
        Scanner str = new Scanner(System.in);
        String stty = str.nextLine();
        //System.out.println(stty);
        String [] slv = stty.split(" ");

        //проходится по словам и выводит палиндром
        for (int i = 0; i<slv.length; i++)
        {
            if (isPalindrome(slv[i]))
                System.out.println(slv[i] + " - является палиндромом");
        }


    }

    //Переворачивает слово
    public static String reverseString(String s)
    {
        String revs = "";
        for (int i = 0; i<s.length(); i++)
        {
            revs = revs + s.charAt(s.length()-i-1);
        }
        return revs;
    }

    //определяет является или палиндромом
    public static boolean isPalindrome(String s)
    {
        if (s.equals(reverseString(s)))
            return true;
        return false;
    }
}
