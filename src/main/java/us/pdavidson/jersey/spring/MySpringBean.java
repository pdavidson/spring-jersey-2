package us.pdavidson.jersey.spring;

import rx.Observable;

public class MySpringBean {
    private static final String [] myFriends = {"Tina", "Napoleon", "Pedro"};

    public String sayHello(String name){
        return "What Does The Fox say " + name;
    }

    public Observable<String> friends(){
        return Observable.from(myFriends);
    };
}
