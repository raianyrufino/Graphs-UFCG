import java.util.*;

import org.jgrapht.*;


/**
 * This is a general interface for graph and subgraph isomorphism.
 *
 * @param <V> the type of the vertices
 * @param <E> the type of the edges
 */
public interface IsomorphismInspector<V, E>
{
    Iterator<GraphMapping<V, E>> getMappings();

    boolean isomorphismExists();
}