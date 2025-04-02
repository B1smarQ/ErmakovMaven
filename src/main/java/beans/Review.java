package beans;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@ToString
public class Review {
    private String comment;
    private int rating;
    @Autowired
    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }


}
