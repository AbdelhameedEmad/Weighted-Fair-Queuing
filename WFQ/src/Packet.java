
public class Packet {
	public float length;		//The length of the packet
	public float time;		//The arrival Time of the packet
	public int myQueue;		//The Number of The queue the packet belongs to
	public Packet(int length,float arrivalTime,int q) {
		this.length = length ;
		time = arrivalTime ;
		myQueue = q ;
	}
	}