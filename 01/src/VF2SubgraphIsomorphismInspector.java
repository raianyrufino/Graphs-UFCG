import java.util.*;

import org.jgrapht.*;


/**
 * This is an implementation of the VF2 algorithm using its feature of detecting
 * <a href="http://mathworld.wolfram.com/Vertex-InducedSubgraph.html">subgraph
 * isomorphism between two graphs</a> as described in Cordella et al. A
 * (sub)graph isomorphism algorithm for matching large graphs (2004),
 * DOI:10.1109/TPAMI.2004.75, <a
 * href="http://ieeexplore.ieee.org/xpl/articleDetails.jsp?arnumber=1323804">
 * http://ieeexplore.ieee.org/xpl/articleDetails.jsp?arnumber=1323804</a>
 *
 * @param <V> the type of the vertices
 * @param <E> the type of the edges
 */
public class VF2SubgraphIsomorphismInspector<V, E>
    extends VF2AbstractIsomorphismInspector<V, E>
{
    /**
     * This implementation of the VF2 algorithm does not support graphs with
     * multiple edges.
     *
     * @param graph1 the first graph
     * @param graph2 the second graph (possible subgraph of graph1)
     * @param vertexComparator comparator for semantic equivalence of vertices
     * @param edgeComparator comparator for semantic equivalence of edges
     * @param cacheEdges if true, edges get cached for faster access
     */
    public VF2SubgraphIsomorphismInspector(
        Graph<V, E> graph1,
        Graph<V, E> graph2,
        Comparator<V> vertexComparator,
        Comparator<E> edgeComparator,
        boolean cacheEdges)
    {
        super(graph1,
            graph2,
            vertexComparator,
            edgeComparator,
            cacheEdges);
    }

    public VF2SubgraphIsomorphismInspector(
        Graph<V, E> graph1,
        Graph<V, E> graph2,
        Comparator<V> vertexComparator,
        Comparator<E> edgeComparator)
    {
        super(graph1,
            graph2,
            vertexComparator,
            edgeComparator,
            true);
    }

    public VF2SubgraphIsomorphismInspector(
        Graph<V, E> graph1,
        Graph<V, E> graph2,
        boolean cacheEdges)
    {
        super(graph1,
            graph2,
            null,
            null,
            cacheEdges);
    }

    public VF2SubgraphIsomorphismInspector(
        Graph<V, E> graph1,
        Graph<V, E> graph2)
    {
        super(graph1,
            graph2,
            true);
    }

    @Override public VF2SubgraphMappingIterator<V, E> getMappings()
    {
        return new VF2SubgraphMappingIterator<>(
                ordering1,
                ordering2,
                vertexComparator,
                edgeComparator);
    }
}
