package com.tiktok.utility;

import com.tiktok.controller.TiktokController;
import com.tiktok.controller.TiktokControllerInterface;

public class ControllerFactory {
	
	private ControllerFactory() {
		
	}

	public static TiktokControllerInterface createObject() {
		// TODO Auto-generated method stub
		return new TiktokController();
	}

}
