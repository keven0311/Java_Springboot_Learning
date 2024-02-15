package dev.learning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // getters:

    // setters:
    @Autowired

    // MongoTemplate is another way to communicate with mongo database by calling:
    // .update method like below:
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        // .first() method indicate to execute the operation on the first matched
        // document in MongoDB.
        // .multi() will execute the operation to mutiple matched documents instead.

        return review;
    }

}
