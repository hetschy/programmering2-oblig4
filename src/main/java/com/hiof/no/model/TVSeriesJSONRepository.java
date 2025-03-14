package com.hiof.no.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ExceptionUtil;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TVSeriesJSONRepository implements TVSeriesRepository {
	private File file; // Oppgave 2.4b)

	public TVSeriesJSONRepository(File file) { // Oppgave 2.4b)
		this.file = file;
	}

	@Override
	public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, listOfTVSeries);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	@Override
	public ArrayList<TVSeries> getAllTVSeries() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		try {
			TVSeries[] tvSeriesArray = mapper.readValue(file, TVSeries[].class);
			return new ArrayList<>(Arrays.asList(tvSeriesArray));
		} catch (IOException e) {
			System.err.println(e);
		}
		return new ArrayList<>();

	}

	@Override
	public TVSeries getTVSeriesByTitle(String title) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			TVSeries[] tvSeriesArray = mapper.readValue(file, TVSeries[].class);
			for (TVSeries serie : Arrays.asList(tvSeriesArray)) {
				if (serie.getTitle().equals(title)) {
					return serie;
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}
}
