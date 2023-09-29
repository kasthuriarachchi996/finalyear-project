package com.cancerpatient.finalyearproject.auth.Notice;


import com.cancerpatient.finalyearproject.user.notice.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/get")
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }

    @PostMapping("/add")
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        Notice createdNotice = noticeService.createNotice(notice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNotice);
    }
}
