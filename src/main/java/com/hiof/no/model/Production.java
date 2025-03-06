package com.hiof.no.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public abstract class Production { // Oppgave 2.1 - Abstraksjon

	protected String title;
	protected int runtimeInMinutes;
	protected LocalDate releaseDate;
	protected String description;
	protected Person director;
	protected ArrayList<Role> roles = new ArrayList<>();

	public Production() {
	}

	public Production(String title, int runtimeInMinutes, LocalDate releaseDate, String description, Person director) {
		this.title = title;
		this.runtimeInMinutes = runtimeInMinutes;
		this.releaseDate = releaseDate;
		this.description = description;
		this.director = director;
	}

	public Production(String title, int runtimeInMinutes, LocalDate releaseDate, String description) {
		this.title = title;
		this.runtimeInMinutes = runtimeInMinutes;
		this.releaseDate = releaseDate;
		this.description = description;
	}

	public Production(String title, int runtimeInMinutes) {
		this.title = title;
		this.runtimeInMinutes = runtimeInMinutes;
	}

	public Production(String title) {
		this.title = title;
	}

	public Person getDirector() {
		return this.director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRuntimeInMinutes() {
		return this.runtimeInMinutes;
	}

	public void setRuntimeInMinutes(int runtimeInMinutes) {
		this.runtimeInMinutes = runtimeInMinutes;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		String production = "Production: " + title +
				"\nDuration: " + runtimeInMinutes + " minutes" +
				"\nRelease date: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(releaseDate) +
				"\nDescription: " + description +
				"\nDirector: " + director.getFullName();

		if (roles.isEmpty()) {
			return production;

		} else {
			str.append(production);
			for (Role role : roles) {
				str.append("\n" + role);
			}
			return str.toString();
		}
	}

	public void addToRoles(Role role) {
		roles.add(role);
	}

	public void addToRoles(ArrayList<Role> listOfRoles) {
		roles.addAll(listOfRoles);
	}

	public ArrayList<Role> getRoles() {
		return new ArrayList<>(roles);
	}

}
