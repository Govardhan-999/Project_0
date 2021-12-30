package com.tiktok.utility;

import com.tiktok.service.TiktokService;
import com.tiktok.service.TiktokServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}

	public static TiktokServiceInterface createObject() {
		// TODO Auto-generated method stub
		return new TiktokService();
	}

}
