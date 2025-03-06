package com.hiof.no.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Movie extends Production {

	public Movie(String title, int runtimeInMinutes, LocalDate releaseDate, String description, Person director) {
		super(title, runtimeInMinutes, releaseDate, description, director);
	}

	public Movie(String title, int runtimeInMinutes, LocalDate releaseDate, String description) {
		super(title, runtimeInMinutes, releaseDate, description);
	}

	public Movie(String title, int runtimeInMinutes) {
		super(title, runtimeInMinutes);
	}

	public Movie(String title) {
		super(title);
	}

	@Override
	public String toString() {
		return "Movie: " + title +
				"\nDescription: " + description +
				"\nRelease date: "
				+ DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(releaseDate) +
				"\nRuntime: " + runtimeInMinutes + " minutes" +
				"\nDescription: " + description +
				"\nDirector: " + director.getFullName();
	}

}
