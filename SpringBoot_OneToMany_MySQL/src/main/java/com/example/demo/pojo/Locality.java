package com.example.demo.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locality {
	
	private Integer localityId;
	private String locality;
	private String streetName;
	private String city;
	private List<WaterTank> waterTanks;

}
