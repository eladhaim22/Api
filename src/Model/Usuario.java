package Model;

import java.util.ArrayList;

public class Usuario {
	
	private ArrayList<Role> roles;
	private String legajo;
	private String clave;
	
	public Usuario(){}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public ArrayList<Role> getRoles() {

		return roles;
	}

	public String getLegajo() {
		return legajo;
	}

	public String getClave() {
		return clave;
	}
}
