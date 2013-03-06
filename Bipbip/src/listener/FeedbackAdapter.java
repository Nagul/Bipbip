package listener;
import pathfind.Arc;

public abstract class FeedbackAdapter implements FeedbackListener {
	public void stopFeedback(){
	}
	public void obstacleFeedback(){
	}
	public void drawFeedback(Arc currentArc){
	}
}

