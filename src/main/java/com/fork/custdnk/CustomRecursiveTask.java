package com.fork.custdnk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private char[] workLoad;
    private String searched;

    public CustomRecursiveTask(char[] workLoad, String searched) {
        this.workLoad = new char[workLoad.length];
        this.searched = searched;
        System.arraycopy(workLoad, 0, this.workLoad, 0, workLoad.length);
    }

    @Override
    protected Integer compute() {
        Integer sum = 0;
        if (workLoad.length > 4) {
            List<CustomRecursiveTask> tasks = createSubtasks();
            CustomRecursiveTask t1 = tasks.get(0);
            CustomRecursiveTask t2 = tasks.get(1);
            t1.fork();
            t2.fork();

            int i1 = t1.join();
            int i2 = t2.join();
            // System.out.println("i1=" + i1 + " i2=" + i2);
            sum += i1 + i2;
        }  else {
            return processing(workLoad);
        }
        return sum;
    }

    private List<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> subtasks = new ArrayList<>();

        char[] partOne = new char[workLoad.length / 2];
        char[] partTwo = new char[workLoad.length / 2];

        System.arraycopy(workLoad, 0, partOne, 0, workLoad.length / 2);
        System.arraycopy(workLoad, workLoad.length / 2, partTwo, 0, workLoad.length / 2);

        subtasks.add(new CustomRecursiveTask(partOne, searched));
        subtasks.add(new CustomRecursiveTask(partTwo, searched));

        return subtasks;
    }

    private Integer processing(char[] work) {
        int foundCnt = 0;
        int len = 4;
        int len1 = len - 1;
        // System.out.println("processing " + work.length);
        char[] chs = new char[len];
        for (int i = 0; i < len; i++) {
            int j = i % len;
            chs[j] = work[i];

            if(j == len1 && i>0) {
                // System.out.println("j == len1 && i>0");
                String key = CustomUtil.myCharsToString(chs, 4 );

                if (key.equals(searched)) {
                    foundCnt += 1;
                    // System.out.println(foundCnt);
                }
            }
        }
        return foundCnt;
    }
}
