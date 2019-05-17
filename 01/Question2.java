import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.*;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.SimpleGraph;


import examples.Adjacencia;
import examples.DefaultVertex;
import examples.MyJGraphTUtil;
import examples.RelationshipEdge;

public class main {
	public static void main(String[] args) {
		
		// recebe um grafo maior
		Graph<DefaultVertex, RelationshipEdge> graphgml = new Pseudograph<>(RelationshipEdge.class);
		graphgml = MyJGraphTUtil.importGraphGML(graphgml, "./src/main/java/graphs/pseudograph-Aula02.gml");
		MyJGraphTUtil.printGraph(graphgml);

		// criando grafo ciclo
		Graph<DefaultVertex, RelationshipEdge> graphciclo = new Pseudograph<>(RelationshipEdge.class);
		graphgml = MyJGraphTUtil.importGraphGML(graphciclo, "./src/main/java/graphs/raianyGraph.gml");
		MyJGraphTUtil.printGraph(graphciclo);
		
		/* vertices
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addVertex("4");
		graph.addVertex("5");
		graph.addVertex("6");
		
		// arestas
		
		graph.addEdge("1", "2");
		graph.addEdge("2", "3");
		graph.addEdge("3", "4");
		graph.addEdge("4", "5");
		graph.addEdge("5", "6");
		graph.addEdge("6", "1");
		*/
		
		
		// Encontra a adjacencia por meio da comparação entre um determinado grafo(grafoGML) dado 
		// e um grafo cíclico definido(graphciclo) para procurar semelhantes ao grafoGML.
	    VF2GraphIsomorphismInspector <DefaultVertex,RelationshipEdge> iso1_2 = 
	    		new VF2GraphIsomorphismInspector <> (graphgml, graphciclo);
	    if (iso1_2.isomorphismExists()) {
	    	System.out.println("\nG1 eh isomorfico a G2? sim \nPossiveis bijecoes:");
		    Iterator <GraphMapping <DefaultVertex,RelationshipEdge>> it = iso1_2.getMappings();
		    while (it.hasNext()) {
		    	System.out.println(it.next());
		    }
	   
	    } else System.out.println("\nG1 eh isomorfico a G2? nao");
	}

}
