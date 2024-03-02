package kcity.service;

import java.util.List;

import kcity.entity.Kcity;

public interface KcityService {

	Kcity getById(int id);

	List<Kcity> getKcityList();

	void insertKcity(Kcity kcity);

	void updateKcity(Kcity kcity);

	void deleteKcity(int id);

}
