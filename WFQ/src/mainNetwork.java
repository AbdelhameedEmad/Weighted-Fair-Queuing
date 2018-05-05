import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainNetwork {
     static Packet p1;
     static Packet p2;
     static Packet p3;
     static float currentTime;
     static Q heighestWeight;
     static Q secHeighestWeight;
     static Q leastWeight;
	public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] Int =b.readLine().split(", "); 
        WTQ Network= new WTQ(Integer.parseInt(Int[0]),Integer.parseInt(Int[1]),
        		Integer.parseInt(Int[2]),Integer.parseInt(Int[3]),Integer.parseInt(Int[4]),
        		Integer.parseInt(Int[5]),Float.valueOf(Int[6]));
        heighestWeight = Network.getHeighestQueue();
        secHeighestWeight = Network.getMiddleQueue();
        leastWeight = Network.getLeastQueue();
        while(true) {
        if(b.ready()) {
      	  if(b.readLine().toLowerCase().equals("finish")) {		//If there is no more packets
      		  break;
      	  }else {
      	    Network.enterPacket(b.readLine());
      	  }}}
        currentTime = 0;
        while(Network.queuesAreEmpty == false){		//If the queues aren't empty
        	if(Network.getQueue(1).isEmpty() && Network.getQueue(2).isEmpty() && Network.getQueue(3).isEmpty())
        		Network.queuesAreEmpty = true;
        	else {
        		if(!heighestWeight.getQueue().isEmpty())
        	p1 = heighestWeight.getQueue().peek();
        		else
        			p1 = new Packet(0, 1000000000, 0);
        		if(!secHeighestWeight.getQueue().isEmpty())
        	p2 = secHeighestWeight.getQueue().peek();
        		else
        			p2 = new Packet(0, 1000000000, 0);
        		if(!leastWeight.getQueue().isEmpty())
        	p3 = leastWeight.getQueue().peek();
            		else
            			p1 = new Packet(0, 1000000000, 0);
        	if(p1.time < p2.time && p1.time < p3.time){
        		currentTime = currentTime +(p1.length / Network.sr);
        		heighestWeight.getQueue().remove();
        	}
        	else if(p2.time < p1.time && p2.time < p3.time){
        		currentTime = currentTime +(p2.length / Network.sr);
        		secHeighestWeight.getQueue().remove();
        	}
        	else{
        		currentTime = currentTime +(p3.length / Network.sr);
        		leastWeight.getQueue().remove();
        	}
        	}
        		
        	
        }
        
        
    }}