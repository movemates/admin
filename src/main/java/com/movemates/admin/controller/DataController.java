package com.movemates.admin.controller;

import com.movemates.admin.model.WebContent;
import com.movemates.admin.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/content")
@AllArgsConstructor
public class DataController {

    private final ContentService contentService;

    @GetMapping("/{title}")
    public WebContent getContent(@PathVariable("title") String title) {
        return contentService.getContent(title);
    }
}
