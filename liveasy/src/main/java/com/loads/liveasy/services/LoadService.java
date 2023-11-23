package com.loads.liveasy.services;

import java.util.List;

import com.loads.liveasy.entities.Payload;

public interface LoadService {

	public void addLoad(Payload payload);

	public void updateLoad(String shipperId, Payload payload);

	public List<Payload> getAllLoad();

	public Payload getLoadById(String shipperId);

	public void deleteLoad(String shipperId);

}
