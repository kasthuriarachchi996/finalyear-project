package com.cancerpatient.finalyearproject.repository;

import com.cancerpatient.finalyearproject.user.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Integer> {

}

