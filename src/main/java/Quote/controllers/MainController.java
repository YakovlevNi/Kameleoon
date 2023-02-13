package Quote.controllers;

import Quote.model.Quote;
import Quote.model.User;
import Quote.repositories.QuoteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @PostMapping("/main")
    public String add(@Valid Quote quote, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model) {
        quote.setAuthor(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("quote", quote);
        } else {
            model.addAttribute("quote", null);
            quoteRepository.save(quote);
        }

        Iterable<Quote> quotes = quoteRepository.findAll();

        model.addAttribute("quote", quotes);

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
