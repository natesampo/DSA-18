package greedy.src;

public class MCCR {
	public static int MCCR(EdgeWeightedGraph G) {
        int cost = 0;
        IndexPQ<Integer> edgeCosts = new IndexPQ<>(G.numberOfV());

        for(Integer i = 0; i < G.numberOfV(); i++) {
            edgeCosts.insert(i, Integer.MAX_VALUE);
        }
        edgeCosts.changeKey(0, 0);

        while(!edgeCosts.isEmpty()) {
        	cost += edgeCosts.minKey();
            Integer v = edgeCosts.delMin();
            
            for(Edge edge:G.edges(v)) {
                Integer u = edge.other(v);
                if(edgeCosts.contains(u) && edge.weight() < edgeCosts.getKey(u)) { //< vert_keys.get(u)) {
                    Integer new_key = edge.weight();
                    edgeCosts.changeKey(u, new_key);
                }
            }

        }
        return cost;
    }
}