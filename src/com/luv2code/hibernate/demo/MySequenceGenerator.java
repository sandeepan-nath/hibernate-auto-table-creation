package com.luv2code.hibernate.demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.*;
import org.hibernate.engine.spi.*;
import org.hibernate.id.*;

public class MySequenceGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		try {
			//System.out.println("Class name is "+object.getClass().toString());
			String tableName;
			if(object.getClass().toString().equalsIgnoreCase("class com.luv2code.hibernate.entity.Instructor")) {
				tableName = "Instructor";
			}
			else
			{
				tableName = "Employee";
			}
			Long total = (Long) session.createQuery("select count(1) from "+tableName).uniqueResult();
			Long nextVal = total+1l;
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-MM-mm-ss");
			return "append_"+nextVal.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}