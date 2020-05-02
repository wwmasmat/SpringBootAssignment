package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LocalityDao;
import com.example.demo.pojo.Locality;

@Service
public class LocalityService {

	@Autowired
	private LocalityDao localityDao;
	
	public Locality addLocalityWithWaterTank(Locality locality) {
		return localityDao.addLocalityWithWaterTank(locality);
	}

	public Locality findLocalityById(Integer id) {
		return localityDao.findLocalityById(id);
	}

	public List<Locality> findAllLocality() {
		return localityDao.findAllLocality();
	}

	public Locality updateLocality(Locality locality) {
		return localityDao.updateLocality(locality);
	}

	public List<Locality> deleteLocality(Integer localityId) {
		return localityDao.deleteLocality(localityId);
	}

}
