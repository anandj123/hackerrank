public class Time {

	public String whatTime(int seconds) {
		int actualSeconds = seconds%60;
		int timeLeftAfterSeconds = seconds - actualSeconds;
		int actualMinutes = timeLeftAfterSeconds % 3600;
		int timeLeftAfterMinutes = timeLeftAfterSeconds - (60*actualMinutes);
		int actualHours = timeLeftAfterMinutes / 3600;
		return actualHours + ":" + actualMinutes + ":" + actualSeconds; 
		
	}

}
