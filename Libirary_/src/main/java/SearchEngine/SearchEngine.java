package SearchEngine;

import com.example.libirary_.Book;

import java.util.ArrayList;

public class SearchEngine {
    ArrayList<String> booksTitle = new ArrayList<>();

    ArrayList<String> authors = new ArrayList<>();
    void uploadAllBooks (){
        for (Book book:
             Book.books) {
            booksTitle.add(book.getTitle());
            authors.add(book.getAuthor());
        }
    }
}
