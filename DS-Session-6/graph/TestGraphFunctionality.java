package graph;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import java.util.List;

/**
 * To test the methods of GraphFunctionality class
 */
public class TestGraphFunctionality {

	@Test
	public void testIsConnectedMethodOfGraphWhenAllEdgesAreConnected() {

		GraphFunctionality graph = new GraphFunctionality(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);

		assertTrue(graph.isConnected());
	}

	@Test
	public void testIsConnectedMethodOfGraphWhenAllEdgesAreNotConnected() {

		GraphFunctionality graph = new GraphFunctionality(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(4, 5, 4);

		assertFalse(graph.isConnected());
	}

	@Test
	public void testShortestPathMethodBetweenTwoVertices() {

		GraphFunctionality graph = new GraphFunctionality(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);

		assertEquals(8, graph.shortestPath(0, 2));

	}
}
