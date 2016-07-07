package Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Model.Graph;
/**
 * JUnit test of graph function.
 * @author Raoqi
 * */
public class GraphTest {
	
	private static Graph graph  = new Graph();
	HashMap<Character, Vector<Character>> graphHashMap;
	
	@Before
	public void setUp() throws Exception {
		graphHashMap= graph.getGraph();
	}

	@Test
	public void testGraph() {
		Vector<Character> S = new Vector<Character>();
		S.add('H');S.add('I');S.add('B');S.add('N');
		assertEquals(S, graphHashMap.get('S'));
		
		Vector<Character> H = new Vector<Character>();
		H.add('A');H.add('G');H.add('M');H.add('S');
		assertEquals(H, graphHashMap.get('H'));
	}
	

	
}
