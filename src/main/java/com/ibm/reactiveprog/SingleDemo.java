package com.ibm.reactiveprog;

import io.reactivex.Single;

public class SingleDemo {
    public static void main(String[] args) {
        //emit only data(only one data)
        Single.just("Hello").subscribe(System.out::println);
        Single single=Single.create(source -> {
            try {
                if ("hello".equals("helloxxx")) {
                    source.onSuccess("Hello Single");
                    source.onSuccess("How are you");
                    source.onSuccess("Hai");
                    source.onSuccess("welcome");



                } else {
                    throw new RuntimeException("some thing went wrong!");
                }
            } catch (RuntimeException e) {
                source.onError(e);

            }

        });
        single.subscribe(System.out::println, System.out::println);
    }
}

