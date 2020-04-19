package com.project.newpatient.NewPatient;
import java.util.List;

import javax.ws.rs.Consumes;
/*import javax.ws.rs.DELETE;*/
import javax.ws.rs.GET;
import javax.ws.rs.POST;
/*import javax.ws.rs.PUT;*/
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("patients")
public class PatientResource {
	PatientRepository repo = new PatientRepository();

	@GET
	
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
	public List<Patient> getPatient() {  
		
		
		System.out.println("Patient calling...");
		return repo.getPatient();
	}
	
	@GET
	@Path("patient/{pid}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public Patient getPatient(@PathParam("pid") int pid) {
		
		System.out.println("Successful");
		return repo.getPatient(pid);
	}

	@POST
	@Path("patient")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient CreatePatient(Patient a1) {
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	
	/*@PUT
	@Path("patient")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient UpdatePatient(Patient a1) {
		
		System.out.println(a1);
		
		if(repo.getPatient(a1.getPid()).getPid()==0) {
			
			repo.create(a1);
		}
		else
		{ 
			
			repo.update(a1);
			System.out.println("Update patient Successfully...");
		}
		
		return a1;
	}
	
	@DELETE
	@Path("patient/{pid}")
	public Patient removePatient(@PathParam("pid")int pid)
	{
		Patient a = repo.getPatient(pid);
		if(a.getPid()!= 0) {
			
			repo.delete(pid);
		}
		
		return a;
	}*/
	
}
