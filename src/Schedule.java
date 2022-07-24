import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Schedule {

    /** 
     * Stock Trades Schedule 
     * Keep the track of tasks
    */
	public List<Task> tasks;
    public Schedule() {
    	tasks=new ArrayList<>();
    }
    public void makeTask(Integer s, String f, Integer tr) {
    	Task t = new Task(s, f, tr);
    	tasks.add(t);
    }
    public boolean validTasks() {
    	if (tasks.size() == 0) return false;
    	for (Task x: tasks) {
    		if (!x.ValidT()) {
    			return false;
    		}
    	}
    	return true;
    }
    public Task getTask(int i) {
		return tasks.get(i);
    }
    public int getSize() {
    	return tasks.size();
    }





    
}
