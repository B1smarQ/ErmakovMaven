package beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Review {
    private String comment;
    private int rating;

    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }
}
