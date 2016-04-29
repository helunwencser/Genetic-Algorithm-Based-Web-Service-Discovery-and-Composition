package lunwenh.cmu.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all services from service cluster 1, 2, and 3
 * */
public class Services {
	
	/* service cluster 1 */
	private List<Service> cluster1 = new ArrayList<Service>();
	/* service cluster 2 */
	private List<Service> cluster2 = new ArrayList<Service>();
	/* service cluster 3 */
	private List<Service> cluster3 = new ArrayList<Service>();
	
	/* read the services from file */
	public Services(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] elements = line.split("\t");
				switch(elements[1]) {
				case "1":
					this.cluster1.add(new Service(
							Integer.parseInt(elements[1]),
							Integer.parseInt(elements[2]),
							Integer.parseInt(elements[3]),
							Integer.parseInt(elements[4])
							));
					break;
				case "2":
					this.cluster2.add(new Service(
							Integer.parseInt(elements[1]),
							Integer.parseInt(elements[2]),
							Integer.parseInt(elements[3]),
							Integer.parseInt(elements[4])
							));
					break;
				case "3":
					this.cluster3.add(new Service(
							Integer.parseInt(elements[1]),
							Integer.parseInt(elements[2]),
							Integer.parseInt(elements[3]),
							Integer.parseInt(elements[4])
							));
					break;
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Service> getCluster1() {
		return cluster1;
	}

	public List<Service> getCluster2() {
		return cluster2;
	}

	public List<Service> getCluster3() {
		return cluster3;
	}
}
