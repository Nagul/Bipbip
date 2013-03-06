package listener;
import pathfind.Arc;
import java.util.EventListener;

public interface FeedbackListener extends EventListener{
	public void stopFeedback();
	public void obstacleFeedback();
	public void drawFeedback(Arc currentArc);
}
