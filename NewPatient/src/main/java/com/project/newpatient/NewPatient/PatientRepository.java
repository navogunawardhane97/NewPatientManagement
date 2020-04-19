package com.project.newpatient.NewPatient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
Connection con = null;
	
	
	public PatientRepository() {
		
		try {
			
				// Connect to Database
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/patientdb","root","");
				System.out.println("Database Connected....");
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}

	public List<Patient> getPatient() {
		
		List<Patient> patient = new ArrayList<>(); 
		String sql = "select * from patientdb"; 
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				Patient p = new Patient();
				
				p.setPid(rs.getInt(1));
				p.setNic(rs.getString(2));
				p.setFname(rs.getString(3));
				p.setLname(rs.getString(4));
				p.setAge(rs.getInt(5));
				p.setAddress(rs.getString(6));
				p.setGender(rs.getString(7));
				p.setEmail(rs.getString(8));
				p.setPhoneNo(rs.getInt(9));
				
				patient.add(p);
			}
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		return patient;
	}

	public Patient getPatient(int pid) {
		
		String sql = "select * from patient where pid = "+pid;
		Patient p = new Patient();
		try 
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) 
		{
	
			p.setPid(rs.getInt(1));
			p.setNic(rs.getString(2));
			p.setFname(rs.getString(3));
			p.setLname(rs.getString(4));
			p.setAge(rs.getInt(5));
			p.setAddress(rs.getString(6));
			p.setGender(rs.getString(7));
			p.setEmail(rs.getString(8));
			p.setPhoneNo(rs.getInt(9));
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}

	public void create(Patient a1) {
		String sql = "insert into patient values(?,?,?,?,?,?,?,?,?)";
		try 
		{
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, a1.getPid());
		st.setString(2, a1.getNic());
		st.setString(3, a1.getFname());
		st.setString(4, a1.getLname());
		st.setInt(5, a1.getAge());
		st.setString(6, a1.getAddress());
		st.setString(7, a1.getGender());
		st.setString(8, a1.getEmail());
		st.setInt(9, a1.getPhoneNo());
		st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	
	/*public void update(Patient a1) {
		
		String sql = "update patient set nic=?,fname=?,lname=?,age=?,address=?,gender=?,email=?,phoneNo=? where pid=?";
		try 
		{
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, a1.getNic());
		st.setString(2, a1.getFname());
		st.setString(3, a1.getLname());
		st.setInt(4, a1.getAge());
		st.setString(5, a1.getAddress());
		st.setString(6, a1.getGender());
		st.setString(7, a1.getEmail());
		st.setInt(8, a1.getPhoneNo());
		st.setInt(9, a1.getPid());

		st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public void delete(int pid) {
		String sql = "delete from patient where pid=?";
		try 
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, pid);


		st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}*/
}
