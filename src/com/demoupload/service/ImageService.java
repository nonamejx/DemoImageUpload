package com.demoupload.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.demoupload.bean.Image;
import com.demoupload.bean.SQLConnection;

public class ImageService {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Image> getImages() {
		ArrayList<Image> results = new ArrayList<Image>();
		Image image = null;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement("select id, name, description from image;");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				image = new Image(rs.getInt(1), rs.getString(2), rs.getString(3));
				results.add(image);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			SQLConnection.closeResultSet(rs);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeConnection(con);
		}
		
		return results;
	}
	
	public int addImage(Image img) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement("insert into image(name, description) values(?, ?);");
			pstmt.setString(1, img.getName());
			pstmt.setString(2, img.getDescription());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			SQLConnection.closeResultSet(rs);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeConnection(con);
		}
		
		return result;
	}
}
