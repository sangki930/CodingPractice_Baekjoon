package BOJ.bruteforce.D_day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {

	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String today = br.readLine();
		String dday = br.readLine();
		LocalDate ld1 = LocalDate.of(Integer.parseInt(today.split(" ")[0]), Integer.parseInt(today.split(" ")[1]), Integer.parseInt(today.split(" ")[2]));
		LocalDate ld2 = LocalDate.of(Integer.parseInt(dday.split(" ")[0]), Integer.parseInt(dday.split(" ")[1]), Integer.parseInt(dday.split(" ")[2]));	
		long days =ChronoUnit.DAYS.between(ld1, ld2);
		int years = Period.between(ld1, ld2).getYears();
		
		if(years>=1000) {
			System.out.println("gg");
			return;
		}
		System.out.println("D-"+days);
	}

}
