package com.kason.distribute.election;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {


    // 进程编号
    private int pid;
    // 标记是否是master
    private boolean downFlag;
    //
    private boolean coOrdinatorFlag;

    //优先级 CPU MEM
    private int priority;

    public Process(int pid, int priority) {
        this.pid = pid;
        this.downFlag = false;
        this.coOrdinatorFlag = false;
        this.priority = priority;
    }


}
