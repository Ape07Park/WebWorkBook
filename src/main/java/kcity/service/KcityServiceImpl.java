package kcity.service;

import java.util.List;

import kcity.dao.KcityDao;
import kcity.entity.Kcity;

public class KcityServiceImpl implements KcityService {
	private KcityDao kDao = new KcityDao();
	
	@Override
	public Kcity getById(int id) {
		 return kDao.getKcityById(id);
	}

	@Override
	public List<Kcity> getKcityList() {
		return kDao.getKcityList();
	}

	@Override
	public void insertKcity(Kcity kcity) {
		kDao.insertKcity(kcity);
		
	}

	@Override
	public void updateKcity(Kcity kcity) {
		kDao.updateKcity(kcity);
	}

	@Override
	public void deleteKcity(int id) {
		kDao.deleteKcity(id);
		
	}
	
}
