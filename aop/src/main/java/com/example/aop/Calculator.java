package com.example.aop;

public class Calculator {

    public long sum(int x, int y) {
        long ret = 0;
        while (x <= y) {
            ret +=x;
            x += 1;
        }
        return ret;
    }
}
