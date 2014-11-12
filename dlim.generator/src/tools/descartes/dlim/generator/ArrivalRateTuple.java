package tools.descartes.dlim.generator;

/**
 * A container class containing an arrival rate and its time-stamp.
 * Also offers some utilities.
 * @author J�akim G. v. Kistowski
 */
public class ArrivalRateTuple implements Comparable<ArrivalRateTuple> {
	
	private static boolean sortByTime = false;

	private double timeStamp;
	private double arrivalRate;
	
	/**
	 * Create a new tuple of arrival rate and its time-stamp.
	 * @param timeStamp
	 * @param arrivalRate
	 */
	public ArrivalRateTuple(double timeStamp, double arrivalRate) {
		this.timeStamp = timeStamp;
		this.arrivalRate = arrivalRate;
	}
	
	/**
	 * Get the time-difference between two arrival rate tuples.
	 * Returns time-stamp/2 if null is passed.
	 * @param t
	 * @return
	 */
	public double getStep(ArrivalRateTuple t) {
		if (t == null) {
			return timeStamp*2;
		}
		return Math.abs(t.getTimeStamp()-timeStamp);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(arrivalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(timeStamp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrivalRateTuple other = (ArrivalRateTuple) obj;
		if (Double.doubleToLongBits(arrivalRate) != Double
				.doubleToLongBits(other.arrivalRate))
			return false;
		if (Double.doubleToLongBits(timeStamp) != Double
				.doubleToLongBits(other.timeStamp))
			return false;
		return true;
	}

	public double getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(double timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getArrivalRate() {
		return arrivalRate;
	}

	public void setArrivalRate(double arrivalRate) {
		this.arrivalRate = arrivalRate;
	}
	
	/**
	 * Checks if arrival rate tuples are sorted by time or arrival rate.
	 * This is a static global setting!
	 * @return
	 */
	public static boolean isSortByTime() {
		return sortByTime;
	}

	/**
	 * Set whether arrival rate tuples are to be sortet by time or arrival rate.
	 * This is a static global setting!
	 * @param sortByTime
	 */
	public static void setSortByTime(boolean sortByTime) {
		ArrivalRateTuple.sortByTime = sortByTime;
	}

	/**
	 * Compares two arrival rate tuples within one another. Uses either time-stamp or arrival rate
	 * based on isSortByTime().
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ArrivalRateTuple o) {
		if (sortByTime) {
			if (timeStamp < o.getTimeStamp()) {
				return -1;
			} else if (timeStamp > o.getTimeStamp()) {
				return 1;
			}
		} else {
			if (arrivalRate < o.getArrivalRate()) {
				return -1;
			} else if (arrivalRate > o.getArrivalRate()){
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * Returns a simple output String for the arrival rate tuple.
	 */
	public String toString() {
		return timeStamp + "," + arrivalRate + ";";
	}


}
