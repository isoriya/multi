package com.tenxp.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jsuch2362 on 15. 2. 12..
 */
public class LockingAccessCounter {

    private final Lock lock;
    private List<String> count;

    private LockingAccessCounter() {
        this.count = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public static LockingAccessCounter getInstance() {
        return new LockingAccessCounter();
    }

    public void countUp(LockingAccessCounter lockingAccessCounter) {
        boolean isLocked = lock.tryLock();
        if (!isLocked) {
            while (isLocked) {
                try {
                    isLocked = lock.tryLock((long) (Math.random() * 10), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            System.out.println("Current Size : " + count.size());
            count.add("1");
            int count1 = lockingAccessCounter.getCount();
            System.out.println("Added Size : " + count1);
        } finally {
            if (isLocked) {
                lock.unlock();
            }
        }
    }

    public int getCount() {
        return count.size();
    }
}
