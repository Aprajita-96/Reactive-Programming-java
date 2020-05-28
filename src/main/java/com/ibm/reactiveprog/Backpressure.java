package com.ibm.reactiveprog;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class Backpressure {
    public static void main(String[] args) {
        //take is the backpressure operator(take operator)
        //Also u can use Window or buffer operator when u don't want to loose any elements
        Observable<Integer> stream=Observable.range(1,200000).take(20).filter(i->i%2==0);
        stream.subscribe(System.out::println);


        //Reactive pull to keep all the items , here sub will tell how many items to be given, this is given by flowable, FlowableBackPressure

        Flowable<Integer> flowstream=Flowable.create(source->{
            for(int i=0;i<2000;i++){
                source.onNext(i);
            }
        }, BackpressureStrategy.BUFFER);
        //buffer all values until downstream consumes it
        flowstream.subscribe(System.out::print);


        

    }
}
