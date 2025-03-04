package enumeration;

public class GetDay {
	Days day;

	public GetDay(Days day) {
		this.day = day;
	}

	public void tellItLikeItIs() {
		switch (day) {
			case MONDAY:
				System.out.println("Mondays are bad.");
				break;

			case FRIDAY:
				System.out.println("Fridays are better.");
				break;

			case SATURDAY:
			case SUNDAY:
				System.out.println("Weekends are best.");
				break;

			default:
				System.out.println("Midweek days are so-so.");
				break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Days c1=Days.SUNDAY;
		 * System.out.println("Red Enum name:"+c1.name());
		 * System.out.println("Red Enum value:"+c1.getValue());
		 */
		for (Days day : Days.values()) {
			System.out.println("Enum name:" + day.name() + "\nEnum value:" + day.getValue());
		}
		GetDay firstDay = new GetDay(Days.MONDAY);
		firstDay.tellItLikeItIs();
		GetDay thirdDay = new GetDay(Days.WEDNESDAY);
		thirdDay.tellItLikeItIs();
		GetDay fifthDay = new GetDay(Days.FRIDAY);
		fifthDay.tellItLikeItIs();

	}
}
