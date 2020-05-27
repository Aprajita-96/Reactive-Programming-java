package com.ibm.reactiveprog;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class FactoryApiToCreateStream {
    public static void main(String[] args) {
        Observable<Integer> stream=Observable.just(1,2,3,4,5,6,7,8);
        stream.filter(item->item%2==0)
                .subscribe(System.out::println);

        //Data source Array
        String[] names={"A","B","C","D"};
        Observable<String> namesStream=Observable.fromArray(names);
        namesStream.filter(item->item=="A")
                .subscribe(System.out::print);

        //EmployeeClass Stream
        Employee[] employees = {new Employee(1, "A1"), new Employee(2, "A2"), new Employee(3, "A3")};

        Observable<Employee> employeeStream = Observable.fromArray(employees);

        employeeStream.filter(employee -> employee.getName().equals("A1"))
                .subscribe(System.out::println, System.out::println, () -> System.out.println("done!"));

        //stream from list
        List<String> list= Arrays.asList(names);
        Observable<String> streamList=Observable.fromIterable(list);
        streamList.filter(item->item=="A").subscribe(System.out::println);

    }
}
