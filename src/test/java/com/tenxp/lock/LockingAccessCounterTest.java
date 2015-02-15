package com.tenxp.lock;

import org.junit.Test;

import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LockingAccessCounterTest {

    @Test
    public void testGetCount() throws Exception {
        final LockingAccessCounter first = LockingAccessCounter.getInstance();
        final LockingAccessCounter second = LockingAccessCounter.getInstance();

        int threadCount = 2;

        final boolean[] isFinish = new boolean[threadCount];

        Runnable[] runnables = new Runnable[threadCount];

        runnables[0] = new Runnable() {
            @Override
            public void run() {
                for (int countIdx = 0; countIdx < 100; ++countIdx) {
                    first.countUp(second);
                    System.out.printf("Thread : %02d -> Count : %02d\n", 0, first.getCount());
                }
                System.out.println("===== Thread " + 0 + " Exit ====");
                isFinish[0] = true;
            }
        };

        runnables[1] = new Runnable() {
            @Override
            public void run() {
                for (int countIdx = 0; countIdx < 100; ++countIdx) {
                    first.countUp(second);
                    System.out.printf("Thread : %02d -> Count : %02d\n", 1, first.getCount());
                }
                System.out.println("===== Thread " + 1 + " Exit ====");
                isFinish[1] = true;
            }
        };

        for (Runnable runnable : runnables) {
            new Thread(runnable).start();
        }

        await().until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                for (boolean finish : isFinish) {
                    if (!finish) {
                        return false;
                    }
                }
                return true;
            }
        });

        assertThat(first.getCount(), is(equalTo(200)));

    }
}