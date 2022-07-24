    /**
     * Inner class to store task object
     */

    public class Task {
    	private Integer stamp = null;
    	private String flicker = null;
    	private Integer trade = null;
        public Task() {}
        public Task(Integer s, String f, Integer tr) {
        	stamp = s;
        	flicker = f;
        	trade = tr;
        }
        public boolean ValidT() {
        	if (stamp == null || flicker == null || trade == null) {
        		return false;
        	}
        	return true;
        }
        public Integer getStamp() {
        	return stamp;
        }
        public String getFlicker() {
        	return flicker;
        }
        public Integer getTrade() {
        	return trade;
        }
    }