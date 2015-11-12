package com.aquaesu.webprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aquaesu.webprj.vo.Member;

public class MemberDao {
	public List<Member> getMembers() throws SQLException {
		return getMembers(1);
		
	}
	public List<Member> getMembers(int page) throws SQLException {
		
		int start =1+(page-1)*10;
		int end =page*10;
		
		  String sql = "SELECT * FROM(SELECT ROW_NUMBER() OVER "
		            + "(ORDER BY REGDATE DESC) NUM, * FROM MEMBERS)"
		            + "A WHERE NUM BETWEEN " + start  +" AND " + end;
		
		String url = "jdbc:sqlserver://211.238.142.251:1433;databaseName=edudb;";
		
		Connection con = DriverManager.getConnection(url, "edu", "class2d");
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		while (rs.next()) {
			member = new Member();
			member.setName(rs.getString("name"));
			member.setMid(rs.getString("mid"));
			list.add(member);
			System.out.println();
		}
		rs.close();
		stm.close();
		con.close();
		return list;
	}
}
