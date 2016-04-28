package lunwenh.cmu.edu;

/**
 * This class defines one service
 * */
public class Service {
	
	/* The attributes of each service */
	private int cost;
	private int reliability;
	private int time;
	private int availability;
	
	/* Weight of QoS parameters in calculating fitness function */
	private int COST = 35;
	private int RELIABILITY = 30;
	private int TIME = 30;
	private int AVAILABILITY = 35;
	
	
	public Service(int cost, int reliability, int time, int availability) {
		this.cost = cost;
		this.reliability = reliability;
		this.time = time;
		this.availability = availability;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getReliability() {
		return reliability;
	}


	public void setReliability(int reliability) {
		this.reliability = reliability;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getAvailability() {
		return availability;
	}


	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	public int getFitnessValue() {
		return this.cost * this.COST +
				this.reliability * this.RELIABILITY +
				this.time * this.TIME +
				this.availability * this.AVAILABILITY;
	}
}
