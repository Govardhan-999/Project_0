package com.tiktok.service;

import java.util.List;

import com.tiktok.entity.TiktokUser;
import com.tiktok.entity.TimeLineEntity;

public interface TiktokServiceInterface {

	int createProfileService(TiktokUser lu);

	TiktokUser viewProfileService(TiktokUser lu);

	List<TiktokUser> viewAllProfileService();

	int deleteProfileService(TiktokUser lu);

	TiktokUser loginProfileService(TiktokUser lu);

	List<TimeLineEntity> timelineService(TiktokUser lu);

	int editProfileService(TiktokUser lu);

}
