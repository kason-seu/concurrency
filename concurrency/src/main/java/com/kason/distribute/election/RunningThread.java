package com.kason.distribute.election;

import lombok.Getter;
import lombok.Setter;

import java.net.ServerSocket;
import java.util.Random;

public class RunningThread implements Runnable {

    // 当前进程
    @Setter
    @Getter
    private Process process;

    // 进程总数量
    private int totalProcess;

    // 收到的消息
    private static boolean[] messageFlag;

    // 随机数
    Random rd;

    // socket 数组 网络连接
    ServerSocket[] sock;


    public RunningThread(Process process, int totalProcess) {
        this.process = process;
        this.totalProcess = totalProcess;
        this.rd = new Random();
        this.sock = new ServerSocket[totalProcess];
        messageFlag = new boolean[totalProcess];
    }

    public static void setMessageFlag(boolean messageFlag, int index) {

        RunningThread.messageFlag[index] = messageFlag;

    }

    public static boolean getMessageFlag(int index) {
        return RunningThread.messageFlag[index];
    }

    @Override
    public void run() {

    }
}
