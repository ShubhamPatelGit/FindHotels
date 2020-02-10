package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sql.Mysql;


@WebServlet("/Search")
public class Search extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int guest = Integer.parseInt(request.getParameter("guest"));
		int budget = Integer.parseInt(request.getParameter("budget"));
		int seat = Integer.parseInt(request.getParameter("seating"));
		String city = request.getParameter("city");
		
		List <String> hotels = new ArrayList<>();
		List <String> halls = new ArrayList<>();
		List <Integer> price = new ArrayList<>();
		
		String str="select hname, venue, budget*"+ guest +" from halls where city= '"+ city + "' and budget < "+ budget +" and	hsize > "+ guest*seat +" and hrev < "+ guest +"*budget;"; 
		
		try {
			Connection con= Mysql.connect();
			Statement stm= con.createStatement();
			ResultSet rs= stm.executeQuery(str);
			
			while(rs.next()) {
				halls.add(rs.getString(1));
				hotels.add(rs.getString(2));
				price.add(rs.getInt(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error.jsp?msg=OOPS! Something went wrong");
		}
		finally {			
			HttpSession session = request.getSession();
			session.setAttribute("hotels", hotels);
			session.setAttribute("halls", halls);
			session.setAttribute("price", price);
			if(halls.isEmpty())
				response.sendRedirect("Error.jsp?msg=No hotels found at "+city);
			else
				response.sendRedirect("Hotels.jsp?msg=Hotels found at "+city);	
		}
	}
}
