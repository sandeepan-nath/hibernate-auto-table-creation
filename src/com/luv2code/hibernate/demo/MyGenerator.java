package com.luv2code.hibernate.demo;

import java.io.Serializable;
import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {
	
	private String prefix="prefix_";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {
		Connection conn = session.connection();
		
		/*try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select count(id) as Id from Student");
			
			if(rs.next()) {
				//int id = rs.getInt(1);
				String generatedID = prefix; // + new Integer(id).toString();
				return generatedID;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;*/
		
		return prefix;
	}

}
