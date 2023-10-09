package org.example.collections.library;

import java.util.*;

public class Library{

    Map<Integer,Polka> library = new HashMap<>();

    public void addPolka(Integer polkaNum, Polka polka){
        if(this.library.containsKey(polkaNum)){
            System.out.println("Полка с номером " + polkaNum + "уже существует в библиотеке");
            return;
        }
        this.library.put(polkaNum,polka);
    }

    public void showBookList(){
        for (Map.Entry entry:this.library.entrySet()){
            System.out.println(
                    "На полке под номером - " + entry.getKey()
                    + " лежат книги:"
                    + entry.getValue().toString()
            );
        }
    }
    public String findBook(Book book){

        for (int i = 1; i <= library.size(); i++) {
            Polka polka = library.get(i);
            Optional<Book> finedBook = polka.getPolka().stream().filter(b->b.equals(book)).findFirst();
            if (finedBook.isPresent()){
                return "Книга \""
                        + book.getTitle() + "\", автор: \""
                        + book.getAuthor() + "\" находится на полке под номером - "
                        + library.get(i).getNumber();
            }
        }
        return "Книга \""
                + book.getTitle() + "\", автор: "
                + book.getAuthor() + "\" не найдена в библиотеке!";
    }
}
