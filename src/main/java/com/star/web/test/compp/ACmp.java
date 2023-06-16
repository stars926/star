package com.star.web.test.compp;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("a")
public class ACmp extends NodeComponent {

    @Override
    public void process() throws InterruptedException {
        //do your business
        Thread.sleep(1000);
        System.out.println("a");
    }
}
