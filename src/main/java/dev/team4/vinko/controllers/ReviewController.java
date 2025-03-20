package dev.team4.vinko.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.team4.vinko.entities.Review;
import dev.team4.vinko.repositories.ReviewRepository;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewRepository repository;

    public ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return repository.save(review);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        repository.deleteById(id);
    }
}