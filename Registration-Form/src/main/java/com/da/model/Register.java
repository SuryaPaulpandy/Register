package com.da.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register {
    private String name;
    private String address;
    private String emailid;
    private String mobilenumber;
    Connection con = null;

    public Register(String name, String address, String emailid, String mobilenumber) {
        this.name = name;
        this.address = address;
        this.emailid = emailid;
        this.mobilenumber = mobilenumber;
    }

   

    public Register() {
		super();
	}



	@Override
	public String toString() {
		return "Register [name=" + name + ", address=" + address + ", emailid=" + emailid + ", mobilenumber="
				+ mobilenumber + "]";
	}



	public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }
    
    public int save() {
        int rows = 0;
        try {
        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","root");
            String s = "INSERT INTO Register1 VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(s);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, emailid);
            pstmt.setString(4, mobilenumber);
            rows = pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
