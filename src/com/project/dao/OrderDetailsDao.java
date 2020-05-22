package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dto.OrderDetailsDto;
import com.project.util.DBconn;

public class OrderDetailsDao {
	
	public int insert(OrderDetailsDto dto) {
		int returnValue = 0;
		DBconn.getInstance();
		String sql = "insert into Order_Details values"
				+"(%d,%d,%f,%d,%f)";
		sql = String.format(sql,dto.getOrderID(),dto.getProductID(),dto.getUnitPrice()
					,dto.getQuantity(),dto.getDiscount());
		returnValue = DBconn.statementUpdate(sql);
		DBconn.dbClose();
		return returnValue;
	}
	public int update(int productID,int orderID) {
		int returnValue = 0;
		DBconn.getInstance();
		String sql = "update Order_Details set productID=%d where orderID=%d";
		sql = String.format(sql, productID,orderID);
		returnValue = DBconn.statementUpdate(sql);
		DBconn.dbClose();
		return returnValue;
	}
	public int delete(int orderID) {
		int returnValue = 0;
		DBconn.getInstance();
		String sql = "delete Order_Details where orderID=%d";
		sql = String.format(sql, orderID);
		returnValue = DBconn.statementUpdate(sql);
		DBconn.dbClose();
		return returnValue;
	}
	public ArrayList<OrderDetailsDto> select(){
		ArrayList<OrderDetailsDto> dtos = new ArrayList<OrderDetailsDto>();
		DBconn.getInstance();
		String sql = "select * from Order_Details";
		ResultSet rs = DBconn.statementQuery(sql);
		try {
			while(rs.next()) {
				OrderDetailsDto dto = new OrderDetailsDto();
				dto.setOrderID(rs.getInt("orderID"));
				dto.setProductID(rs.getInt("productID"));
				dto.setUnitPrice(rs.getDouble("unitPrice"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setDiscount(rs.getDouble("discount"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return dtos;
	}	
}
