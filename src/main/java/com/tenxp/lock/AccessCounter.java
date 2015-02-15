package com.tenxp.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsuch2362 on 15. 2. 12..
 */
public class AccessCounter {

    private static AccessCounter accessCounter;

    private List<String> count;

    private AccessCounter() {
        this.count = new ArrayList<>();
    }

    public static AccessCounter getInstance() {
        return new AccessCounter();
    }

    public synchronized void countUp(AccessCounter accessCounter) {

        System.out.println("Current Size : " + count.size());
        count.add("1");
        int count1 = accessCounter.getCount();
        System.out.println("Added Size : " + count1);

    }

    public synchronized int getCount() {
        return count.size();
    }
}
