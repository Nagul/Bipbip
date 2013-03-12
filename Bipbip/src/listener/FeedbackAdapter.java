package listener;
import java.util.ArrayList;

import pathfind.Arc;

public abstract class FeedbackAdapter implements FeedbackListener {
	public void stopFeedback(){
	}
	public void obstacleFeedback(){
	}
	public void drawFeedback(ArrayList<Arc> currentArc, boolean b){
	}
}

