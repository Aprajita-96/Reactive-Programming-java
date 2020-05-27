package com.ibm.reactiveprog;

import io.reactivex.Observable;

public class ColdStream {
    public static void main(String[] args) throws InterruptedException {

        //Source Stream: stream broadcast to multiple subscribers

        Observable<Integer> colstream=Observable.create(source->{
         for(int i=0;i<5;i++)   {
             source.onNext(i);
         }
         source.onComplete();
        });
        //each subscribe has a clone of the stream, and they don't share the stream like hot observable
        //because it's a cold stream all three sub will get data one by one
        //sub :1
        colstream.subscribe(System.out::println,System.out::println,()-> System.out.println("Apii"));
        //subs2
        colstream.subscribe(System.out::println,System.out::println,()-> System.out.println("Aprajita"));
        //Late joining
        Thread.sleep(5000);
        //sub:3(the sub3 comes after 3 seconds and still gets the same data from scratch)
        colstream.subscribe(System.out::println,System.out::println,()-> System.out.println("Aprajita"));

    }
}
