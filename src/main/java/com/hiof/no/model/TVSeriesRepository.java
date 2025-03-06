package com.hiof.no.model;

import java.util.ArrayList;

public interface TVSeriesRepository { // Oppgave 2.2

	void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries);

	ArrayList<TVSeries> getAllTVSeries();

	TVSeries getTVSeriesByTitle(String title);

}
