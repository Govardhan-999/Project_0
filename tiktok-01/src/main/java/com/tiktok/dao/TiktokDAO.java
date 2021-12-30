package com.tiktok.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tiktok.entity.TiktokUser;
import com.tiktok.entity.TimeLineEntity;

public class TiktokDAO implements TiktokDAOInterface {

	public int createProfileDAO(TiktokUser lu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("insert into tiktokuser values(?,?,?,?)");
			ps.setString(1, lu.getName());
			ps.setString(2, lu.getPassword());
			ps.setString(3, lu.getEmail());
			ps.setString(4, lu.getAddress());
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public TiktokUser viewProfileDAO(TiktokUser lu) {
		TiktokUser ll = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("select * from tiktokuser where email=?");

			ps.setString(1, lu.getEmail());

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				ll = new TiktokUser();
				ll.setName(res.getString(1));
				ll.setPassword(res.getString(2));
				ll.setEmail(res.getString(3));
				ll.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public List<TiktokUser> viewAllProfileDAO() {
		List<TiktokUser> ll1 = new ArrayList<TiktokUser>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("select * from tiktokuser");

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				TiktokUser ll = new TiktokUser();
				ll.setName(res.getString(1));
				ll.setPassword(res.getString(2));
				ll.setEmail(res.getString(3));
				ll.setAddress(res.getString(4));

				ll1.add(ll);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll1;
	}

	@Override
	public int deleteProfileDAO(TiktokUser lu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("delete from tiktokuser where email=?");

			ps.setString(1, lu.getEmail());

			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public TiktokUser loginProfileDAO(TiktokUser lu) {
		TiktokUser ll = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("select * from tiktokuser where email=? and password=?");

			ps.setString(1, lu.getEmail());
			ps.setString(2, lu.getPassword());

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				ll = new TiktokUser();
				ll.setName(res.getString(1));
				ll.setPassword(res.getString(2));
				ll.setEmail(res.getString(3));
				ll.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public List<TimeLineEntity> timelineProfileDAO(TiktokUser lu) {
		List<TimeLineEntity> ll1 = new ArrayList<TimeLineEntity>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("select * from timeline where receiver=?");
			ps.setString(1, lu.getEmail());
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				TimeLineEntity ll = new TimeLineEntity();
				ll.setSender(res.getString(1));
			    ll.setMessage(res.getString(2));
				ll.setReceiver(res.getString(3));

				ll1.add(ll);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll1;
	}

	@Override
	public int editProfileDAO(TiktokUser lu) {
		TiktokUser ll = null;
		int i=0;
		 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement
					("update tiktokuser  set name = ?, password = ?, address=? WHERE email = ?");
			
			System.out.println("==== enter your details to edit your profile====");
			Scanner sc = new Scanner(System.in);
			System.out.println(" enter your name ");
			ps.setString(1,sc.next());
			System.out.println(" enter your password ");
			ps.setString(2, sc.next());
			
			System.out.println(" enter your address ");
			ps.setString(3, sc.next());
			ps.setString(4,lu.getEmail());
			

			ResultSet res = ps.executeQuery();
			i=1;
			System.out.println("====  updated successfully ====");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
		 
		 
	}

}
