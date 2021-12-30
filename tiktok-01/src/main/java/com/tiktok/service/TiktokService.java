package com.tiktok.service;

import java.util.List;

import com.tiktok.dao.TiktokDAOInterface;
import com.tiktok.entity.TiktokUser;
import com.tiktok.entity.TimeLineEntity;
import com.tiktok.utility.DaoFactory;

public class TiktokService implements TiktokServiceInterface {

	public int createProfileService(TiktokUser lu) {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return ld.createProfileDAO(lu);
	}

	@Override
	public TiktokUser viewProfileService(TiktokUser lu) {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return ld.viewProfileDAO(lu);
	}

	@Override
	public List<TiktokUser> viewAllProfileService() {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return ld.viewAllProfileDAO();
	}

	@Override
	public int deleteProfileService(TiktokUser lu) {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return ld.deleteProfileDAO(lu);
	}

	@Override
	public TiktokUser loginProfileService(TiktokUser lu) {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return ld.loginProfileDAO(lu);
	}

	@Override
	public List<TimeLineEntity> timelineService(TiktokUser lu) {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return ld.timelineProfileDAO(lu);
	}

	@Override
	public int editProfileService(TiktokUser lu) {
		TiktokDAOInterface ld=DaoFactory.createObject();
		return  ld.editProfileDAO(lu);
	}

}
