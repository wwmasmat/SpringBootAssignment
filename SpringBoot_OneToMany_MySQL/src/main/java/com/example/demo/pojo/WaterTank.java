package com.example.demo.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterTank {
	
	private Integer localityId;
	private Integer capacity;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastCleanedDate;

}
