package org.example.generics;

import java.util.List;

public class Info <T>{
    @Override
    public String toString() {
        return "INFO: {" +
                "value=" + value +
                "}\n";
    }

    public T getValue() {
        return value;
    }

    public static <T>T showFirstFromList(List<T> list ){
        return list.get(0);
    }

    private T value;
    public Info(T value){
        this.value = value;
    }

    public T print(){
        return this.value;
    }
}
