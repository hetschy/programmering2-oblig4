package com.hiof.no;

import java.time.LocalDate;
import java.util.ArrayList;

import com.hiof.no.model.*;

public class Main {

	public static void main(String[] args) {

		Episode peakyS1E1 = new Episode("Episode #1.1", 1, 1, 58, LocalDate.parse("2013-09-12"),
				"Thomas Shelby plans to fix a horse race; some guns turn up stolen.");

		Episode peakyS1E2 = new Episode("Episode #1.2", 2, 1, 58, LocalDate.parse("2013-09-19"),
				"Thomas Shelby starts a feud with a gypsy family and finally meets with Inspector Campbell to talk about the stolen guns.");

		ArrayList<Episode> peakyEpisodes = new ArrayList<Episode>();
		peakyEpisodes.add(peakyS1E1);
		peakyEpisodes.add(peakyS1E2);

		TVSeries peakyBlinders = new TVSeries("Peaky Blinders",
				"A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.",
				LocalDate.parse("2013-12-09"), peakyEpisodes);

		System.out.println(peakyBlinders);

		for (Role role : peakyBlinders.getCast()) {
			System.out.println(role);
		}

	}
}
