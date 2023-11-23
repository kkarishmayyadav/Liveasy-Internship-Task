package com.loads.liveasy.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payload-table")
public class Payload {

	@NotEmpty
	private String loadingPoint;

	@NotEmpty
	private String unloadingPoint;

	@NotEmpty
	private String productType;

	@NotEmpty
	private String truckType;

	@NotNull
	private int noOfTruck;

	@NotNull
	private double weight;

	private String comment;

	@Id
	private String shipperId;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;

}
