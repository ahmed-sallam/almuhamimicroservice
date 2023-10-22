package com.techpeak.faq.repositories;

import com.techpeak.faq.models.FaqEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<FaqEntity, Long> {
}
