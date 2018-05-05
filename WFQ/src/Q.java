import java.util.LinkedList;
import java.util.Queue;

public class Q {
	public int Weight;	//Weight of the Queue
	public int Size;	//Size of the Queue
	private Queue<Packet> Queue;	//The packets Queue
	public Q(int w, int s){
		Weight = w;
		Size = s;
		Queue = new LinkedList<Packet>();
	}
	public Queue<Packet> getQueue() {
		return Queue;
	}
	public void setQueue(Queue<Packet> queue) {
		Queue = queue;
	}
	
}



