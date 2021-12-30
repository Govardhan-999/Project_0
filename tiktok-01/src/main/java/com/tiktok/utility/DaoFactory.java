package com.tiktok.utility;

import com.tiktok.dao.TiktokDAO;
import com.tiktok.dao.TiktokDAOInterface;

public class DaoFactory {
	
	private DaoFactory() {
		
	}

	public static TiktokDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new TiktokDAO();
	}

}
