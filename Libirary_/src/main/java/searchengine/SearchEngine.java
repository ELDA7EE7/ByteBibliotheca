package searchengine;

import librarypackage.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static librarypackage.Library.books;

public abstract class SearchEngine {
   protected ArrayList<String> words = new ArrayList<>();

    protected void uploadAllBooks (){
        for (Book book: books) {
            words.add(book.getTitle());
            words.add(book.getAuthor());
        }
    }

    public Book findBook(String word){
        for(Book book: books ){
            if(word.equals(book.getAuthor())||word.equals(book.getTitle()))
                return book;
        }
        return null;
    }
    //this function returns all words that contains String you write in search textField
    protected List<String> searchList(String searchWords, List<String> listOfStrings) {
        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}
