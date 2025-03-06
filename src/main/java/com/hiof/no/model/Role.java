package com.hiof.no.model;

public class Role {

	private String roleFirstName;
	private String roleLastName;
	private Person actor;

	public Role(String firstName, String lastName, String roleFirstName, String roleLastName) {
		this.actor = new Person(firstName, lastName);
		this.roleFirstName = roleFirstName;
		this.roleLastName = roleLastName;
	}

	public String getRoleFirstName() {
		return this.roleFirstName;
	}

	public void setRoleFirstName(String roleFirstName) {
		this.roleFirstName = roleFirstName;
	}

	public String getRoleLastName() {
		return this.roleLastName;
	}

	public void setRoleLastName(String roleLastName) {
		this.roleLastName = roleLastName;
	}

	// Oppgave 2.6
	@Override
	public String toString() {
		return "Role: " + roleFirstName + " " + roleLastName +
				" as portrayed by " + actor.getFullName();
	}

}
