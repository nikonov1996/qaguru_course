package org.example.generics;

import org.example.comparation.Man;

import java.util.List;



public class UserInfo<T extends Man>{
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
    public UserInfo(T value){
        this.value = value;
    }

    public T print(){
        return this.value;
    }
}
