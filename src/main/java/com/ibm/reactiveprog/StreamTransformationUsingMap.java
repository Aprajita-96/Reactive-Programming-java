package com.ibm.reactiveprog;

import io.reactivex.Observable;

public class StreamTransformationUsingMap {
    public static void main(String[] args) {
        //source stream
        Observable<Integer> stream = Observable.create(source -> {
            //sequence of nos from 1 to 10
            for(int i=1;i<=10;i++){
                source.onNext(i);
            }
            source.onComplete();
        });

        //apply transformation:multiply by 2
        Observable<Integer> downstream=stream.map(item->item*2);

        downstream.subscribe(System.out::println, System.out::println,
                () -> System.out.println("complete"));


        //Refctor code:  BUILDER CODE (i.e  don't assign anything in a variable)
        Observable<Integer> stream1 = Observable.create(source -> {
            //sequence of nos from 1 to 10
            for(int i=1;i<=10;i++){
                source.onNext(i);
            }
            source.onComplete();
        });
        stream1.map(item->item*2).subscribe(System.out::println);

    }
}
