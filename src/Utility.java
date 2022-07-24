import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utility {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SS");
	private static final Instant startInstant = Instant.now();

	/**
 	* Utility function for Timestamp
 	* 
 	*/

	public static String getTimestamp() {
	    return dateFormat.format(new Date()).substring(0, 11);
	}

	public static String getZeroTimestamp() {
		
		Duration duration = Duration.between(startInstant, Instant.now());
		return millisecondsToTimestamp(duration.toMillis());
	}

	private static String millisecondsToTimestamp(long millis) {
		
		final long hours = TimeUnit.MILLISECONDS.toHours(millis);

		final long minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));

		final long seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));

		final long ms = TimeUnit.MILLISECONDS.toMillis(millis)
				- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis));

		return String.format("%02d:%02d:%02d.%02d", hours, minutes, seconds, ms);
	}
}

