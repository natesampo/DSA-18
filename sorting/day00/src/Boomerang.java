import java.util.HashMap;

public class Boomerang {

	public static int numberOfBoomerangs(int[][] points) {
		int counter = 0;
		
		for(int i=0;i<points.length;i++) {
			int[] point = points[i];
			HashMap<Double, Integer> distances = new HashMap<Double, Integer>();
			for(int j=0;j<points.length;j++) {
				
				int[] tempPoint = points[j];
				double dist = Math.sqrt((point[0]-tempPoint[0])*(point[0]-tempPoint[0]) + (point[1]-tempPoint[1])*(point[1]-tempPoint[1]));
				
				if(distances.get(dist) != null) {
					int tempDist = distances.get(dist);
					
					counter -= tempDist*(tempDist-1);
					tempDist += 1;
					distances.put(dist, tempDist);
					counter += tempDist*(tempDist-1);
				} else {
					distances.put(dist, 1);
				}
			}
		}
		
		return counter;
	}
}
