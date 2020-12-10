package com.gary.dbrw.util;

import java.util.concurrent.ThreadLocalRandom;

public class NumberUtil {

    public static int getRandom(int min, int max) {
        if (max - min <= 0) {
            return min;
        }
        return min + ThreadLocalRandom.current().nextInt(max - min + 1);
    }

    public static int getRandom2(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
        int i = NumberUtil.getRandom(1, 2);
        System.out.println(i);
    }
}
