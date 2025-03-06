package com.hiof.no.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			for (TVSeries serie : listOfTVSeries) {
				bufferedWriter.append(mapper.writeValueAsString(serie));
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	@Override
	public ArrayList<TVSeries> getAllTVSeries() {
		ArrayList<TVSeries> listOfTVSeries = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				listOfTVSeries.add(mapper.readValue(line, TVSeries.class));
			}
		} catch (JsonMappingException e) {
			System.err.println("Cannot map contents of JSON");
		} catch (JsonProcessingException e) {
			System.err.println("Error parsing JSON");
		} catch (IOException e) {
			System.err.println("I/O-exception encountered");
		}

		return listOfTVSeries;
	}

	@Override
	public TVSeries getTVSeriesByTitle(String title) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String cTitle = mapper.readValue(line, TVSeries.class).getTitle();
				if (cTitle.equals(title)) {
					return new TVSeries(cTitle,
							mapper.readValue(line, TVSeries.class).getDescription(),
							mapper.readValue(line, TVSeries.class).getReleaseDate());
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("File could not be found");
		} catch (IOException e) {
			System.err.println("File could not be opened");
		}
		return null;
	}

}
