package com.dolphin422.system.service.impl.test;

import com.dolphin422.common.base.IMyThreadService;

/**
 * @author DamonJT
 * @description
 * @createDate 2019.05.24 16:19
 */
public class MyThread extends Thread {

    private IMyThreadService myThreadService;

    public MyThread(IMyThreadService myThreadService) {
        super();
        this.myThreadService = myThreadService;
    }

    @Override
    public void run() {
        myThreadService.run();
    }

}
