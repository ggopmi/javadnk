package com.fork.custdnk;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class CustomForkJoinRecursiveTaskFindDnk {
    static List<String> searchArr = List.of("GGGG", "AAAA");
    static final int CNT = 2048; //16; //10_000_000;

    public static void main(final String[] arguments) throws InterruptedException {
        char[] workLoad = null;
        String searchedPattern = null;

        workLoad = CustomWorkLoad.getWorkLoad(CNT);
        System.out.println(CustomUtil.myCharsToString(workLoad, CNT)); // 1st time only
        for (int i = 0; i < searchArr.size(); i++) {
            searchedPattern = searchArr.get(i);
            int sum = doSearch(workLoad, searchedPattern);
            System.out.println("searchedPattern="+searchedPattern + " , count=" + sum);
        }
    }

    public static int doSearch(char[] workLoad, String searchedPattern) {
        int proc = Runtime.getRuntime().availableProcessors();
        System.out.println("\n1. Number of available core in the processor is: " + proc);
        ForkJoinPool pool = ForkJoinPool.commonPool(); // parallelism, threadFactory, exceptionHandler
        System.out.println("2. Number of active thread before invoking: " + pool.getActiveThreadCount());

        CustomRecursiveTask task = new CustomRecursiveTask(workLoad, searchedPattern);

        int sum = pool.invoke(task);  // obtain result
//        System.out.println("searchedPattern="+searchedPattern + " , count=" + sum);

        System.out.println("3. Number of active thread after invoking: " + pool.getActiveThreadCount());
        System.out.println("4. Common Pool Size is: " + pool.getPoolSize());

        return sum;
    }
}
