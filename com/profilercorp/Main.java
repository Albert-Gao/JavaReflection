package com.profilercorp;

import com.profilercorp.interview.ReflectTestObject;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ReflectTestObject test = new ReflectTestObject(); //task a
        test.describeFields(); //task b
        test.describeConstructor(); //task b
        test.describeMethods(); //task b
        test.createInstance(); //task c
        test.printFieldValue(); //task d
        test.callMethods(); //task e
        test.changeValueOfaField(); //task f
        test.printFieldValue(); //task d
        test.callMethods(); //task e


        test.printDivider();
        test.printDivider();
        System.out.println();
        System.out.println("Let's do task g and inspect the results:");
        System.out.println();
        test.printDivider();
        test.printDivider();
        test.printDivider();

        //task g, repeat b c d e
        test.describeFields();
        test.describeConstructor();
        test.describeMethods();
        test.createInstance();
        test.printFieldValue();
        test.callMethods();
    }
}
