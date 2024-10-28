package com.example.ecommerce.controller;

import com.example.ecommerce.model.Comment;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.Rating;
import com.example.ecommerce.service.CommentService; // Tạo service để lưu bình luận
import com.example.ecommerce.service.RatingService; // Tạo service để lưu đánh giá
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/comment")
    public String viewCommentPage(@RequestParam int shipmentId, 
                                   @RequestParam int idItem, 
                                   Model model) {
        model.addAttribute("shipmentId", shipmentId); // ID shipment
        model.addAttribute("idItem", idItem); // ID sản phẩm
        
        return "comment"; // Trả về trang comment.html
    }
    
    // Xử lý xác nhận bình luận và đánh giá
    @PostMapping("/comment/submit")
    public String submitComment(@RequestParam String content,
                                @RequestParam int ratingValue,
                                @RequestParam int idItem, // Sản phẩm liên quan
                                @RequestParam int shipmentId, // Gửi idShipment
                                Model model) {
        // Tạo và lưu bình luận
        Comment comment = new Comment();
        comment.setContent(content);
        
        // Tạo và gán Item
        Item item = new Item();
        item.setIdItem(idItem); // Gán idItem
        comment.setItem(item); // Tham chiếu đến Item
        
        // Lưu bình luận
        commentService.saveComment(comment);

        // Tạo và lưu đánh giá
        Rating rating = new Rating();
        rating.setRatingValue(ratingValue);
        rating.setItem(item); // Tham chiếu đến Item
        
        // Lưu đánh giá
        ratingService.saveRating(rating);

        model.addAttribute("message", "Comment and rating submitted successfully!");
        return "confirmation"; // Tạo view để hiển thị thông báo
    }
}
