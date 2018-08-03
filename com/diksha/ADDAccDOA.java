package com.diksha;

import java.sql.*;
import java.util.*;

public class ADDAccDOA implements CommonDAO<Customer> {
	
	private List<Customer> cardlist = new ArrayList<Customer>();
	private static final String SQL_SELECT_ID_CUSTOMER = "select * from Customer where id = ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO Customer(title, firstname, lastname, Age, DOB) values(?, ?, ?,?,?)";
	private static final String SEL_CUST = "select * from Customer"; 

	@Override
	public void create(Customer object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER);
			ps.setInt(1,object.getId());
			ps.setString(2, object.getDOB());
			ps.setString(3, object.getTitle());
			ps.setString(4, object.getFirstname());
			ps.setString(5, object.getLastname());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Customer findById(int id) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID_CUSTOMER);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Customer e = new Customer();
			if (rs.next()) {
				//e.setId(rs.getInt(1));
				e.setDOB(rs.getString(2));
				e.setAge((rs.getString(3)));
				e.setLastname((rs.getString(4)));
				e.setFirstname((rs.getString(5)));
			}

			return e;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Customer> findAll() {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SEL_CUST);
			// ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Customer card = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				cardlist.add(card);
			}

			return cardlist;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}
	

	}

// @Override
// public List<Card> findAll() {
// try (Connection con = ConnectionUtil.getConnection()) {
// PreparedStatement ps = con.prepareStatement(SQL_SELECT);
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery();
// Card e = new Card();
// while (rs.next()) {
//
//
//
// return cardlist;
// } catch (SQLException ex) {
// ex.printStackTrace();
// return null;
// }
//
//
// }
// }

	
	
	


