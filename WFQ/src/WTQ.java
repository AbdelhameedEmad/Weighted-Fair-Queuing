import java.util.Queue;

public class WTQ {
    public Q q1,q2,q3; 
	public float sr;
    @SuppressWarnings("unused")
	private boolean busy;
    public boolean queuesAreEmpty;
	public WTQ(int w1,int s1,int w2,int s2,int w3,int s3,float sr) {
	    this.sr=sr;
        queuesAreEmpty = true;
	}

	public void enterPacket(String x) {
		String userInput[] = x.split(", ");
		int packetLength = Integer.parseInt(userInput[0]);
		float arrivalTime = Float.valueOf(userInput[1]);
		int arrivalQueue = Integer.parseInt(userInput[2]);
		Packet p= new Packet(packetLength,arrivalTime,arrivalQueue);
		if(arrivalQueue == 1)
			q1.getQueue().add(p);
		else if(arrivalQueue == 2)
			q2.getQueue().add(p);
		else 
			q3.getQueue().add(p);
		queuesAreEmpty = false;
	}
	
	public Queue<Packet> getQueue(int N){
		if(N == 1)
		return q1.getQueue();
		else if(N == 2)
			return q2.getQueue();
		else
			return q3.getQueue();
	}
	
	public Q getHeighestQueue(){
		if(q1.Weight > q2.Weight && q1.Weight > q3.Weight)
			return q1;
		else if(q2.Weight > q1.Weight && q2.Weight > q3.Weight)
			return q2;
		else 
			return q3;
	}
	public Q getMiddleQueue(){
		if(q1.Weight < this.getHeighestQueue().Weight && q1.Weight > this.getLeastQueue().Weight)
			return q1;
		else if(q2.Weight < this.getHeighestQueue().Weight && q2.Weight > this.getLeastQueue().Weight)
			return q2;
		else 
			return q3;
	}
	public Q getLeastQueue(){
		if(q1.Weight < q2.Weight && q1.Weight < q3.Weight)
			return q1;
		else if(q2.Weight < q1.Weight && q2.Weight < q3.Weight)
			return q2;
		else 
			return q3;
	}

	public float finishtag() {
		return 0;
	}
}
