package com.hiof.no.model;

import java.time.LocalDate;

public class Episode extends Production {

	private int episodeNumber;
	private int seasonNumber;

	public Episode() {
	}

	public Episode(String title,
			int episodeNumber,
			int seasonNumber,
			int runtime,
			LocalDate releaseDate,
			String description,
			Person director) {
		super(title, runtime, releaseDate, description, director);
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;
	}

	public Episode(String title,
			int episodeNumber,
			int seasonNumber,
			int runtime,
			LocalDate releaseDate,
			String description) {
		super(title, runtime, releaseDate, description);
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;
	}

	public Episode(String title, int episodeNumber, int seasonNumber) {
		super(title);
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;
	}

	public Episode(String title, int episodeNumber, int seasonNumber, int runtime) {
		super(title, runtime);
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;
	}

	public int getEpisodeNumber() {
		return this.episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public int getSeasonNumber() {
		return this.seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	@Override
	public String toString() {
		return "Episode title: " + title +
				"\nEpisode number: " + episodeNumber +
				"\nSeason number: " + seasonNumber +
				"\nRuntime in minutes: " + runtimeInMinutes;
	}

}
