package Quote.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
     User author;

    public Quote(String text, User user) {
        this.text=text;
        this.author=user;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }
}
