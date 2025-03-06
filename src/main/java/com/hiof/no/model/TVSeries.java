package com.hiof.no.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class TVSeries {

	private String title;
	private String description;
	private LocalDate releaseDate;
	private ArrayList<Episode> episodes = new ArrayList<>();
	private double averageRunTime = 0;
	private int numSeasons = 0;

	public TVSeries() {
	}

	public TVSeries(String title, String description, LocalDate releaseDate, ArrayList<Episode> episodes) {
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.episodes = episodes;
	}

	public TVSeries(String title, String description, LocalDate releaseDate) {
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	public int getNumSeasons() {
		return this.numSeasons;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void addEpisode(Episode episode) {
		int currSeason = episode.getSeasonNumber();

		if (currSeason == numSeasons || currSeason == numSeasons + 1) {
			episodes.add(episode);
			updateAverageRuntime();
			if (currSeason == numSeasons + 1) {
				numSeasons++;
			}
		}

		else {
			System.out.println("Incorrect season!");
		}

	}

	private void updateAverageRuntime() {
		double totalTime = 0.0;

		for (Episode episode : episodes) {
			totalTime += episode.runtimeInMinutes;
		}

		averageRunTime = totalTime / episodes.size();
	}

	public ArrayList<Episode> getEpisodeInSeason(int season) {
		ArrayList<Episode> episodesInSeason = new ArrayList<Episode>();

		for (Episode episode : episodes) {
			if (season == episode.getSeasonNumber()) {
				episodesInSeason.add(episode);
			}
		}

		return episodesInSeason;
	}

	public void clearEpisodes() {
		episodes.clear();
	}

	public double getAverageRunTime() {
		return averageRunTime;
	}

	public ArrayList<Role> getCast() {
		ArrayList<Role> cast = new ArrayList<>();
		for (Episode episode : episodes) {
			for (Role role : episode.roles) {
				if (cast.contains(role)) {
					continue;
				} else {
					cast.add(role);
				}
			}
		}
		return cast;
	}

	@Override
	public String toString() {
		return "TV series title: " + title +
				"\nDescription: " + description +
				"\nRelease date: "
				+ DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(releaseDate);
	}

	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<>(episodes);
	}
}
