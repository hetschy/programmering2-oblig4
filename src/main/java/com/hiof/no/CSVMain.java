package com.hiof.no;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import com.hiof.no.model.TVSeries;
import com.hiof.no.model.TVSeriesCSVRepository;

public class CSVMain {

	public static void main(String[] args) {

		TVSeriesCSVRepository csv = new TVSeriesCSVRepository(new File("tvseries.csv"));

		TVSeries peakyBlinders = new TVSeries("Peaky Blinders",
				"A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.",
				LocalDate.parse("2013-12-09"));

		TVSeries test = new TVSeries("Test serie",
				"Test description",
				LocalDate.parse("2025-03-02"));

		ArrayList<TVSeries> los = new ArrayList<>();

		los.add(peakyBlinders);
		los.add(test);

		csv.addListOfTVSeries(los);

		for (TVSeries serie : csv.getAllTVSeries()) {
			System.out.println(serie);
		}

		System.out.println(csv.getTVSeriesByTitle("Peaky Blinders"));

	}
}
