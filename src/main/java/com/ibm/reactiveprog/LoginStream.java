package com.ibm.reactiveprog;

import io.reactivex.Observable;

public class LoginStream {
    public static void main(String[] args) {


        Observable<String> stream = Observable.create(source -> {
            String name = "admin";
            String password = "admin";
            if (name.equals("admin") && password.equals("admin")) {
                source.onNext("Login sucess");
                source.onComplete();
            } else {
                source.onError(new Exception("Login failed"));
            }
        });
        stream.subscribe(System.out::println, System.out::println,
                () -> System.out.println("complete"));
    }
}
