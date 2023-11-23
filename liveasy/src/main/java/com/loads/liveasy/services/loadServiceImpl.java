package com.loads.liveasy.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loads.liveasy.entities.Payload;
import com.loads.liveasy.repositories.PayloadRepository;

@Service
public class loadServiceImpl implements LoadService {

	@Autowired
	private PayloadRepository payloadRepository;

	@Override
	public void addLoad(Payload payload) {
		// Generate Shipper Id
		String randomShpperIdString = UUID.randomUUID().toString();
		payload.setShipperId(randomShpperIdString);
		payloadRepository.save(payload);
	}

	// Update a Specific load record
	@Override
	public void updateLoad(String shipperId, Payload payload) {
		payload.setShipperId(shipperId);
		payloadRepository.save(payload);
	}

	// Get All loads Record
	@Override
	public List<Payload> getAllLoad() {
		return (List<Payload>) payloadRepository.findAll();
	}

	// Get specific load record by shipper Id
	@Override
	public Payload getLoadById(String shipperId) {
		return payloadRepository.findById(shipperId).get();
	}

	// Delete load record by shipper id
	@Override
	public void deleteLoad(String shipperId) {
		Payload deletePayload = payloadRepository.findById(shipperId).get();
		payloadRepository.delete(deletePayload);
	}

}
