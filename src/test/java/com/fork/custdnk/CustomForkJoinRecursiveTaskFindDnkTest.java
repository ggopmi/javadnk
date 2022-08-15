package com.fork.custdnk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class CustomForkJoinRecursiveTaskFindDnkTest {
    String searchTemplate = "GGGG";
    final int totalLetters = 16;

//    public static void main(String[] args) {
//        CustomForkJoinRecursiveTaskFindDnkTest t = new CustomForkJoinRecursiveTaskFindDnkTest();
//        t.testGetWorkLoadFor0();
//        t.testGetWorkLoadFor1();
//        t.testGetWorkLoadFor4();
//        t.testGetWorkLoadFor22();
//    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
     void testGetWorkLoadFor4() {
        int expected = 4;
         char[] workload = testGetWorkLoad4();
         int sum = CustomForkJoinRecursiveTaskFindDnk.doSearch(workload, searchTemplate);
         assertEquals(sum, expected);
//         System.out.println("sum=" + sum + " expected=" + 4);
     }

    @Test
    void testGetWorkLoadFor22() {
        int expected = 2;
        char[] workload = testGetWorkLoad22();
        int sum = CustomForkJoinRecursiveTaskFindDnk.doSearch(workload, searchTemplate);
        assertEquals(sum, expected);
//        System.out.println("sum=" + sum + " expected=" + 2);
    }

    @Test
    void testGetWorkLoadFor1() {
        int expected = 1;
        char[] workload = testGetWorkLoad1();
        int sum = CustomForkJoinRecursiveTaskFindDnk.doSearch(workload, searchTemplate);
        assertEquals(sum, expected);
//        System.out.println("sum=" + sum + " expected=" + 1);
    }

    @Test
    void testGetWorkLoadFor0() {
        int expected = 0;
        char[] workload = testGetWorkLoad0();
        int sum = CustomForkJoinRecursiveTaskFindDnk.doSearch(workload, searchTemplate);
        assertEquals(sum, expected);
//        System.out.println("sum=" + sum + " expected=" + 0);
    }

    // loading the tests
    private char[] testGetWorkLoad4() {
        final char[] res = new char[totalLetters];
        for (int i = 0; i < totalLetters; i++) {
            res[i] = 'G';
        }
        return res;
    }
    private char[] testGetWorkLoad22() {
        final char[] res = new char[totalLetters];
        for (int i = 0; i < totalLetters/2; i++) {
            res[i] = 'G';
        }
        for (int i = totalLetters/2; i < totalLetters; i++) {
            res[i] = 'A';
        }
        return res;
    }
    private char[] testGetWorkLoad1() {
        final char[] res = new char[totalLetters];
        for (int i = 0; i < totalLetters/4; i++) {
            res[i] = 'G';
        }
        for (int i = totalLetters/4; i < totalLetters; i++) {
            res[i] = 'A';
        }
        return res;
    }
    private char[] testGetWorkLoad0() {
        final char[] res = new char[totalLetters];
        for (int i = 0; i < totalLetters; i++) {
            res[i] = 'A';
        }
        return res;
    }
}