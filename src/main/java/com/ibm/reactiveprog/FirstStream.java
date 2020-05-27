package com.ibm.reactiveprog;

import io.reactivex.Observable;

public class FirstStream {
    public static void main(String[] args) {
        //create stream from scratch
        Observable<String> stream=Observable.create(source->{
            source.onNext("Aprajita"); //data channel
            source.onNext("Akku");
            source.onComplete();
//when complete is called, stream is cloased and we can't see lallu printed.
            //push error
            source.onError(new Exception("something went wrong"));
//as soon as we push an error , the stream is closed.
            source.onNext("Lallu");
        });

        //subscriber : three signal - data, error,complete
        stream.subscribe(data-> System.out.println(data),
                err-> System.out.println("error"),
                ()-> System.out.println("complete"));

        //enhancement using lambda
        stream.subscribe(System.out::println, System.out::println,
                ()-> System.out.println("complete"));
    }
}
