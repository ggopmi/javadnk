package com.fork.custdnk;

import java.util.concurrent.ThreadLocalRandom;

public class CustomWorkLoad {
    static final char[] LETTERS = {'A', 'G', 'C', 'T'};
    static final int WORD_LEN = LETTERS.length;

    public static char[] getWorkLoad(final int totalCount) {
        final char[] res = new char[totalCount];
        ThreadLocalRandom tr = ThreadLocalRandom.current();

        for (int i = 0; i < totalCount; i++) {
            int iRand = tr.nextInt(0, WORD_LEN);
            res[i] = LETTERS[iRand];
        }
        return res;
    }

//    // Tests
//    public static char[] testGetWorkLoad4() {
//        int totalCount = 16;
//        final char[] res = new char[totalCount];
//        for (int i = 0; i < totalCount; i++) {
//            res[i] = 'G';
//        }
//        return res;
//    }
//    public static char[] testGetWorkLoad22() {
//        int totalCount = 16;
//        final char[] res = new char[totalCount];
//        for (int i = 0; i < totalCount/2; i++) {
//            res[i] = 'G';
//        }
//        for (int i = totalCount/2; i < totalCount; i++) {
//            res[i] = 'A';
//        }
//        return res;
//    }
//    public static char[] testGetWorkLoad1() {
//        int totalCount = 16;
//        final char[] res = new char[totalCount];
//        for (int i = 0; i < totalCount/4; i++) {
//            res[i] = 'G';
//        }
//        for (int i = totalCount/4; i < totalCount; i++) {
//            res[i] = 'A';
//        }
//        return res;
//    }
//    public static char[] testGetWorkLoad0() {
//        int totalCount = 16;
//        final char[] res = new char[totalCount];
//        for (int i = 0; i < totalCount; i++) {
//            res[i] = 'A';
//        }
//        return res;
//    }
}
