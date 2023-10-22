package com.techpeak.contactus.repositories;

import com.techpeak.contactus.models.ContactUsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactUsRepository extends JpaRepository<ContactUsEntity, Long> {
  Page<ContactUsEntity> findAllByParentIdIsNull(Pageable pageable);
  List<ContactUsEntity> findByParentIdOrderByCreatedAt(Long parentId);
}
