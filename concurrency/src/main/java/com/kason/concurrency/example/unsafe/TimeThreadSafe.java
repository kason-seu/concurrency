package com.kason.concurrency.example.unsafe;

import com.kason.concurrency.annotations.ThreadSafe;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class TimeThreadSafe {


    public static final int clientTotal = 1000;
    public static final int threadTotal = 200;

    private static DateTimeFormatter time = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();

        // 同时可以并发的数量
        Semaphore semaphore = new Semaphore(threadTotal);
        // 模拟客户端的请求总量
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i =0; i < clientTotal; i++) {
            executorService.submit(() -> {

                try {
                    semaphore.acquire();
                    long update = update();

                    System.out.println(update);
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
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




    }

    private static long update() throws Exception {

        return time.parseMillis("20211212");
    }
}
