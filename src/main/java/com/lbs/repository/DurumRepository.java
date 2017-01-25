package com.lbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbs.model.DosyaDurum;

public interface DurumRepository extends JpaRepository<DosyaDurum, Long> {

}
