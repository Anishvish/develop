import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter date");
		int dd = sc.nextInt();
		System.out.println("Enter month");
		int mm = sc.nextInt();
		System.out.println("Enter year");
		int yyyy = sc.nextInt();
		LocalDate l = LocalDate.of(yyyy, mm, dd);
		LocalDate now = LocalDate.now();
		Period diff = Period.between(l, now);
		System.out.println(diff.getYears() + " Years " + diff.getMonths() + " Months " + diff.getDays() + " Days ");
	}
}
