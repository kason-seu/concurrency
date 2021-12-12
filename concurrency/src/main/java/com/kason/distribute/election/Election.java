package com.kason.distribute.election;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;
@Data
public class Election {


    // ping 测试机器是否还活着
    public static ReentrantLock pingLock = new ReentrantLock();

    // 选举 老大加锁
    public static ReentrantLock electionLock = new ReentrantLock();

    // 是否选举
    public static boolean electionFlag = false;

    // 判断机器是否还活着
    public static boolean pingFlag = false;

    // 选举监视进程
    public static Process electionDetector;


    public static void initElection(RunningThread[] t) {

        Process temp = new Process(-1, -1);

        for (int i = 0; i < t.length; i++) {
            if (temp.getPriority() < t[i].getProcess().getPriority()) {
                temp = t[i].getProcess();
            }
        }
        // 获取最高优先级的process
        t[temp.getPid() - 1].getProcess().setCoOrdinatorFlag(true); // 设置位mater
    }


}
