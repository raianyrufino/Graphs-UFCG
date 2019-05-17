import com.sun.tools.jdeps.Graph;

public class VF2GraphIsomorphismInspector<V, E>
    extends VF2AbstractIsomorphismInspector<V, E>
{
    /**
     * This implementation of the VF2 algorithm does not support graphs with
     * multiple edges.
     *
     * @param graph1 the first graph
     * @param graph2 the second graph
     * @param vertexComparator comparator for semantic equivalence of vertices
     * @param edgeComparator comparator for semantic equivalence of edges
     * @param cacheEdges if true, edges get cached for faster access
     */
    public VF2GraphIsomorphismInspector(
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

    public VF2GraphIsomorphismInspector(
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

    public VF2GraphIsomorphismInspector(
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

    public VF2GraphIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2)
    {
        super(graph1,
            graph2,
            true);
    }

    @Override public VF2GraphMappingIterator<V, E> getMappings()
    {
        return new VF2GraphMappingIterator<>(
                ordering1,
                ordering2,
                vertexComparator,
                edgeComparator);
    }
}