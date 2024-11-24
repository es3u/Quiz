package com.example.exam.Service;

import com.example.exam.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getAll(){
        return books;
    }

    public void addBook(Book book){

        books.add(book);

    }


    public boolean updateBook(String id , Book book){

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).equals(id)){
                books.set(i , book);
                return true;
            }

        }
        return false ;

    }


    public boolean deleteBook(String id){

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(id)){
                books.remove(i);
                return true ;
            }

        }
        return false ;

    }

    public ArrayList<Book> getCategory(String category){
        ArrayList<Book> getCategory= new ArrayList<>();
        for (Book b : books){
            if (b.getCategory().equalsIgnoreCase(category)){
                getCategory.add(b);
            }
        }
        return getCategory;

    }

    public ArrayList<Book> getPages(int number_of_pages){
            ArrayList<Book> getPages = new ArrayList<>();
        for (Book b : books){
            if (b.getNumber_of_pages() >= number_of_pages){
                getPages.add(b);
            }
        }
        return getPages;
    }


    /////بنفترض ان المسول id حقه ١
    public boolean changeBook(String id ){

        for (Book b : books){
            if (b.getId().equals(id) && b.getId().equals("1")){
                b.setAvailable(true);
                return true ;
            }
        }
        return false ;

    }







}

