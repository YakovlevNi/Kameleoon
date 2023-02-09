package main.java.controllers;

import Quote.model.Quote;
import Quote.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class MainController {
@Autowired
    private QuoteRepository quoteRepository;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("greetings", "Main page frontend");
        return "main";

    }

    @GetMapping("/auth")
    public String auth(Map<String, Object> model) {
        return "auth";
    }

    @GetMapping("/main")
    public String Quote(Map<String, Object> model) {
        Iterable<Quote> quotes = quoteRepository.findAll();

        model.put("quote", quotes);

        return "main";
    }

    @PostMapping("/")
    public String add(@RequestParam String text, @RequestParam String author, Map<String, Object> model) {
        Quote quote = new Quote(text, author);

        quoteRepository.save(quote);

        Iterable<Quote> quotes = quoteRepository.findAll();

        model.put("quote", quotes);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Quote> quotes;

        if (filter != null && !filter.isEmpty()) {
            quotes = quoteRepository.findByAuthor(filter);
        } else {
            quotes = quoteRepository.findAll();
        }

        model.put("quotes", quotes);

        return "main";
    }


}
