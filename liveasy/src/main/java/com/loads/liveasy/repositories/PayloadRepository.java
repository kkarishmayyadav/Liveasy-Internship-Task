package com.loads.liveasy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loads.liveasy.entities.Payload;

public interface PayloadRepository extends JpaRepository<Payload, String> {

}
