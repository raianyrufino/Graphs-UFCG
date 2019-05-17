package exercicioPratico02;

import org.jgrapht.Graph;
import org.jgrapht.GraphTests;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.CSVFormat;

import examples.MyJGraphTUtil;

import java.util.*;

public class OurGraph {
	
	private Graph<String, DefaultEdge> graph;
	private DefaultDirectedGraph<String, DefaultEdge> directGraph;
    private String graphRoot;
	
	public OurGraph(String path, CSVFormat format) {

        this.graph = new SimpleGraph<>(DefaultEdge.class);
        this.graph = MyJGraphTUtil.importGraphCSV(graph, path, format, false, false, true);
        this.directGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
        generateDirectGraph();
        
    }
	
	private boolean isTree() {
        return GraphTests.isTree(this.graph);
    }

    private void selectGraphRoot() {

        Random r = new Random();
        Object[] vertexs = this.graph.vertexSet().toArray();
        int index = r.nextInt(vertexs.length);
        this.graphRoot = (String) vertexs[index];


    }

    private void generateDirectGraph() throws RuntimeException {

        if (!isTree()) {
            throw new RuntimeException("O grafo não é uma árvore.");
        }
        
        Set<String> visited = new HashSet<>();
        
        int c = 1;

        selectGraphRoot();

        Queue<String> queueA = new LinkedList<String>();
        queueA.add(this.graphRoot);

        while (c <= this.graph.vertexSet().size()) {
            String f = queueA.remove();
            this.directGraph.addVertex(f);
            visited.add(f);

            for (int i = 0; i < this.graph.edgesOf(f).size(); i++) {
                String v = String.valueOf(this.graph.edgesOf(f).toArray()[i]);

                if (v.substring(1, 2).equals(f)) {
                    if (!visited.contains(v.substring(5, 6))) {
                        queueA.add(v.substring(5, 6));
                        this.directGraph.addVertex(v.substring(5, 6));
                        this.directGraph.addEdge(f, v.substring(5, 6));
                        visited.add(v.substring(5, 6));
                    }
                } else if (!visited.contains(v.substring(1, 2))) {
                    queueA.add(v.substring(1, 2));
                    this.directGraph.addVertex(v.substring(1, 2));
                    this.directGraph.addEdge(f, v.substring(1, 2));
                    visited.add(v.substring(1, 2));
                }
            }

            c++;
        }

    }
    
    public boolean isGraphRoot(String n) {
        if (this.graphRoot.equals(n))
        	return true;
        
        return false;
    }

    public String getDirectdGraph() {
        return this.directGraph.edgeSet().toString();
    }

    public String getGraphRoot() {
        return this.graphRoot;
    }
    
    public String getPredecessor (String n) {
    	return Graphs.predecessorListOf(directGraph, n).toString();
    }
    
    public String getSucessors (String n) {
    	return Graphs.successorListOf(directGraph, n).toString();
    }
}
