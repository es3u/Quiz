package com.example.exam.Cotroller;

import com.example.exam.Model.Book;
import com.example.exam.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService books ;

    @GetMapping("/getall")
    public ResponseEntity getAll(){

        return ResponseEntity.ok().body(books.getAll());
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody @Valid Book book){

        books.addBook(book);

        return ResponseEntity.ok().body("added is ok");

    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity updateBook(@PathVariable String id , @RequestBody @Valid Book book , Errors errors){

        if (errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        boolean b = books.updateBook(id , book);
        if (b){
            return ResponseEntity.ok().body("updeted is ok");
        }
        else return ResponseEntity.badRequest().body("not found");



    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity deleteBook(@PathVariable String id){
        boolean  b = books.deleteBook(id);

        if (b){
            books.deleteBook(id);
        return ResponseEntity.ok().body("deleted is ok");
        }
        return ResponseEntity.badRequest().body("not found");
    }

    @GetMapping("/getCategory/{category}")
    public ResponseEntity getCategory(@PathVariable String category){

        return ResponseEntity.ok().body(books.getCategory(category));

    }

    @GetMapping("/getPages/{number_of_pages}")
    public ResponseEntity getPages(@PathVariable int number_of_pages){

        return ResponseEntity.ok().body(books.getPages(number_of_pages));
    }
    @PutMapping("/changeBook/{id}")
    public ResponseEntity changeBook(@PathVariable String id){

       boolean b = books.changeBook(id);

       if (b){
           return ResponseEntity.ok().body("changed");
       }
       return ResponseEntity.badRequest().body("not Available");

    }







}
