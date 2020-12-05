package com.gary.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0: {
                System.out.println("MyElasticJob - 0");
                break;
            }
            case 1: {
                System.out.println("MyElasticJob - 1");
                break;
            }
            case 2: {
                System.out.println("MyElasticJob - 2");
                break;
            }
            default: {
                System.out.println("MyElasticJob - default");
            }
        }
    }
}

