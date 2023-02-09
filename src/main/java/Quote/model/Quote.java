package main.java.Quote.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String text;

    String author;

    public Quote(String text, String author) {
        this.text=text;
        this.author=author;
    }
}
