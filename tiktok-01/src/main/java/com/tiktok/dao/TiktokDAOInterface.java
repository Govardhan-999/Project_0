package com.tiktok.dao;

import java.util.List;

import com.tiktok.entity.TiktokUser;
import com.tiktok.entity.TimeLineEntity;

public interface TiktokDAOInterface {

	int createProfileDAO(TiktokUser lu);

	TiktokUser viewProfileDAO(TiktokUser lu);

	List<TiktokUser> viewAllProfileDAO();

	int deleteProfileDAO(TiktokUser lu);

	TiktokUser loginProfileDAO(TiktokUser lu);

	List<TimeLineEntity> timelineProfileDAO(TiktokUser lu);

	int editProfileDAO(TiktokUser lu);

}
