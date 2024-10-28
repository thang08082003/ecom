package com.example.ecommerce.service;

import com.example.ecommerce.model.Rating;
import com.example.ecommerce.repository.RatingRepository; // Bạn cần tạo repository này
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
