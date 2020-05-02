package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Locality;
import com.example.demo.service.LocalityService;

@RestController
@RequestMapping("/locality")
public class LocalityWaterTankController {
	
	@Autowired
	private LocalityService localityService;
	
	@PostMapping("/add")
	public Locality addLocalityWithWaterTank(@RequestBody Locality locality) {
		return localityService.addLocalityWithWaterTank(locality);
	}
	
	@GetMapping("/find/{id}")
	public Locality findLocalityById(@PathVariable Integer id) {
		return localityService.findLocalityById(id);
	}
	
	@GetMapping("/findAll")
	public List<Locality> findAllLocality() {
		return localityService.findAllLocality();
	}
	
	@PutMapping("/update")
	public Locality updateLocality(@RequestBody Locality locality) {
		return localityService.updateLocality(locality);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Locality> deleteLocality(@PathVariable("id") Integer localityId) {
		return localityService.deleteLocality(localityId);
	}
}