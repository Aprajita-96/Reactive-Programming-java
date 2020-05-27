package com.ibm.reactiveprog;

import io.reactivex.Observable;

public class SequentialStream {
    public static void main(String[] args) {

        Observable<Integer> stream = Observable.create(source -> {
           //sequence of nos from 1 to 10
            for(int i=1;i<=10;i++){
                source.onNext(i);
            }
            source.onComplete();
        });
        stream.subscribe(System.out::println, System.out::println,
                () -> System.out.println("complete"));
    }
}

