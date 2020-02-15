package com.bitlab.controllers;

import com.bitlab.db.Books;
import com.bitlab.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class MainController {
    private DBManager connection = new DBManager();

    public MainController() {
    }

    @GetMapping(
            path = {"/"}
    )
    public String index(Model model) {
        ArrayList<Books> books = this.connection.getAllBooks();
        model.addAttribute("books", books);
        return "/index";
    }
    @GetMapping(
            path = {"/listbook"}
    )
    public String listbook(Model model) {
        ArrayList<Books> books = this.connection.getAllBooks();
        model.addAttribute("books", books);
        return "/listbook";
    }
    @PostMapping(
            path = {"/search"}
    )
    public String searchbook(@RequestParam("name") String name) {
        ArrayList<Books> books = this.connection.getAllBooks();
        Model model = null;
        ArrayList<Books> temp = new ArrayList<>();
        for (Books b : books){
            if (name.equals(b.getName())){
                temp.add(b);
            }
        }
        model.addAttribute("books", temp);
        return "/listbook";
    }

    @GetMapping(
            path = {"/addbook"}
    )
    public String addBlog(Model model) {
        return "/addbook";
    }

    @PostMapping(
            path = {"/addbook"}
    )
    public String toAddBlog(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("price") int price) {
        Books b = new Books((Long)null, name, author, price);
        return this.connection.addBooks(b) ? "redirect:addbook?success" : "redirect:addbook?error";
    }

    @GetMapping(
            path = {"/readblog/{id}/{latinUrl}.html"}
    )
    public String readBlog(Model model, @PathVariable("id") Long id, @PathVariable("latinUrl") String latinUrl) {
        Books books = this.connection.getBook(id);
        model.addAttribute("book", books);
        return "/readblog";
    }
}
