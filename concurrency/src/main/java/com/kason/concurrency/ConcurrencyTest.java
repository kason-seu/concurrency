package com.kason.concurrency;

import com.kason.concurrency.annotations.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


@NotThreadSafe
public class ConcurrencyTest {


    public static final int clientTotal = 1000;
    public static final int threadTotal = 200;

    private static int cnt = 0;
    private static void add() {
        cnt ++;
    }
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i =0; i < clientTotal; i++) {
            executorService.submit(() -> {

                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        executorService.shutdown();

        System.out.println(cnt);


    }

}
