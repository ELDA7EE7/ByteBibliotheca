package searchengine;

import com.example.libirary_.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SearchEngine {
   protected ArrayList<String> words = new ArrayList<>();

    protected void uploadAllBooks (){
        for (Book book:
             Book.books) {
            words.add(book.getTitle());
            words.add(book.getAuthor());
        }
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
