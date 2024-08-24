package com.movemates.admin.service;

import com.movemates.admin.model.WebContent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ContentService {
    public WebContent getContent(String title) {
        return WebContent.builder()
                .ref(UUID.randomUUID())
                .title(title)
                .content("Choosing MoveMates ensures exceptional service at a competitive price, making professional moving affordable for everyone. Our skilled and experienced team handles belongings with great care, ensuring safe delivery every time. With a strong commitment to punctuality, we guarantee timely moves without delays. Personalized solutions are offered for every unique move, providing comprehensive support from start to finish. By choosing MoveMates, customers enjoy a stress-free, seamless experience with excellent value for their money.")
                .build();
    }
}
