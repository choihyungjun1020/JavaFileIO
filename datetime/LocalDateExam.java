package file_io.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class LocalDateExam {
	public static void printCalendar(LocalDate date) {
		// date 인스턴스를 YearMonth로 변경.
		YearMonth yearMonth = YearMonth.from(date);

		// 첫 번째 날짜를 구한다.
		LocalDate firstDay = yearMonth.atDay(1);

		// date인스턴스의 월의 총 길이(며칠)을 구한다.
		int days = date.lengthOfMonth();

		// 반복하여 날짜와 요일을 출력한다.
		System.out.println(firstDay);
		System.out.println(firstDay.getDayOfWeek());

		for (int i = 0; i < days - 1; i++) {
			firstDay = firstDay.plusDays(1);

			System.out.println(firstDay);
			System.out.println(firstDay.getDayOfWeek().name());
		}

		System.out.println("========================================");
	}

	/**
	 * 금일 제외하고 가장 가까운 다음 영업일 구하기
	 * 
	 * @param localDate 오늘
	 * @return
	 */
	public static Map<String, Object> getClosestWorkingDay(LocalDate localDate) {
		// 0. localDate에 하루를 더해본다.
		localDate = localDate.plusDays(1);
		
		// 1. 오늘의 요일을 구한다.
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		
		int dayCount = 1;

		// 2. 하루를 더한 날짜가 휴일인지 검사한다.
		while (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
			// 3. 만약 휴일이라면 하루를 또 더한다.
			localDate = localDate.plusDays(1);
			dayOfWeek = localDate.getDayOfWeek();			
			dayCount++;
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("workingDay", localDate);
		result.put("dayCount", dayCount);

		// 4. 만약 휴일이 아니라면 더한 결과를 반환한다.
		return result;
	}

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();


//		LocalDate closestWorkingDay = getClosestWorkingDay(now);
		Map<String, Object> closestWorkingDay = getClosestWorkingDay(LocalDate.of(2024, 2, 9));
		System.out.println(closestWorkingDay);
		System.out.println("===================================================");
		printCalendar(now);
		System.out.println("===================================================");

		System.out.println(now.getDayOfWeek().name());

		YearMonth yearMonth = YearMonth.from(now);

		LocalDate firstDay = yearMonth.atDay(1);
		System.out.println(firstDay);
		System.out.println(firstDay.getDayOfWeek().name());
		
		// 날짜 사이의 차이
		LocalDate startDate = LocalDate.of(2022, 1, 1);
		LocalDate endDate = LocalDate.of(2023, 5, 20);
		Period between = Period.between(startDate, endDate);
		
		System.out.println(between.getYears() + ", " + between.getMonths() + ", " + between.getDays());
	}
}
