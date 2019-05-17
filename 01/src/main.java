import org.jgrapht.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class main {
	public static void main(String[] args) {
		
		Graph<String, DefaultEdge> graph = new SimpleGraph<String, DefaultEdge> (DefaultEdge.class);
		
		// vertices
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addVertex("4");
		graph.addVertex("5");
		graph.addVertex("6");
		graph.addVertex("7");
		graph.addVertex("8");
		graph.addVertex("9");
		graph.addVertex("10");
		graph.addVertex("11");
		graph.addVertex("12");
		graph.addVertex("13");
		graph.addVertex("14");
		graph.addVertex("15");
		
		// arestas
		graph.addEdge("1", "2");
		graph.addEdge("1", "5");
		graph.addEdge("2", "5");
		graph.addEdge("2", "3");
		graph.addEdge("3", "4");
		graph.addEdge("4", "8");
		graph.addEdge("8", "12");
		graph.addEdge("8", "7");
		graph.addEdge("7", "11");
		graph.addEdge("11", "12");
		graph.addEdge("12", "15");
		graph.addEdge("15", "14");
		graph.addEdge("14", "13");
		graph.addEdge("5", "9");
		graph.addEdge("9", "10");
		graph.addEdge("10", "3");
		graph.addEdge("10", "11");
		graph.addEdge("10", "3");
		graph.addEdge("10", "14");
		graph.addEdge("11", "15");
		graph.addEdge("9", "13");
				
		
		System.out.println(graph.edgeSet());
		System.out.println(graph.vertexSet());
		
		System.out.println();
		
		
		
		
		
		//quarteirões vizinhos
		//Um grupo de 3 vizinhos mutuamente adjacentes não pode ser separado em distritos diferentes 
	}

}
