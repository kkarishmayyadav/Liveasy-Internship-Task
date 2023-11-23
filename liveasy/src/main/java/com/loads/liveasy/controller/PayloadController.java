package com.loads.liveasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loads.liveasy.entities.Payload;
import com.loads.liveasy.reponse.ApiResponse;
import com.loads.liveasy.services.LoadService;

import jakarta.validation.Valid;

@RestController
public class PayloadController {

	@Autowired
	private LoadService loadService;

	@PostMapping("/load")
	public ResponseEntity<ApiResponse> addLoad(@Valid @RequestBody Payload payload) {
		try {
			this.loadService.addLoad(payload);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Load details added succesfully"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("failed to add"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("load/{loadId}")
	public ResponseEntity<ApiResponse> updateLoad(@Valid @PathVariable("loadId") String shipperId,
			@RequestBody Payload payload) {

		try {
			if (loadService.getLoadById(shipperId) == null) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid shipperId"), HttpStatus.NOT_FOUND);
			}
			this.loadService.updateLoad(shipperId, payload);
			return new ResponseEntity<>(new ApiResponse("Updated Successfully"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("failed to update"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/load")
	public ResponseEntity<List<Payload>> getLoad() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(loadService.getAllLoad());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("load/{loadId}")
	public ResponseEntity<Payload> getLoadById(@PathVariable("loadId") String shipperId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(loadService.getLoadById(shipperId));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("load/{loadId}")
	public ResponseEntity<ApiResponse> deleteLoad(@PathVariable("loadId") String shipperId) {
		try {
			this.loadService.deleteLoad(shipperId);
			return new ResponseEntity<>(new ApiResponse("Deleted Successfully "), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiResponse("Invalid Shepper Id or Load with this Id does not exist"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
