package com.hiof.no.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSeriesCSVRepository implements TVSeriesRepository {

	private File file;

	public TVSeriesCSVRepository(File file) {
		this.file = file;
	}

	@Override // Oppgave 2.3b)
	public void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));) {
			String delimiter = ";";

			for (TVSeries tvserie : listOfTVSeries) {
				bufferedWriter.write(tvserie.getTitle() + delimiter +
						tvserie.getDescription() + delimiter +
						tvserie.getReleaseDate().toString());

				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<TVSeries> getAllTVSeries() { // Oppgave 2.3c)
		ArrayList<TVSeries> listOfTVSeries = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] serie = line.split(";");
				listOfTVSeries
						.add(new TVSeries(
								serie[0], // Title
								serie[1], // Description
								LocalDate.parse(serie[2]))); // Release date
			}
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found");
		} catch (IOException e) {
			System.err.println("File could not be opened");
		}

		return listOfTVSeries;
	}

	@Override
	public TVSeries getTVSeriesByTitle(String title) {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] serie = line.split(";");
				if (serie[0].equals(title)) {
					return new TVSeries(
							serie[0],
							serie[1],
							LocalDate.parse(serie[2]));
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
