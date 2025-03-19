package utils;

import annotations.Invoke;

public class InvokableClass {
    @Invoke
    public int invoke1(){
        return 42;
    }

    @Invoke
    public String invoke2(){
        return "Hello, World!";
    }

    @Invoke
    public double invoke3(){
        return 3.14;
    }
}
