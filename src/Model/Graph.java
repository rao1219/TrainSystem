package Model;

import java.util.HashMap;
import java.util.Vector;

/**
 * This Graph class stores information of the routes map, containing station names and connection relationships.
 * @author Raoqi
 * */
public class Graph {
	public HashMap<Character, Vector<Character>> graph;
	Vector<Character> connects = new Vector<Character>();//这里用Vector考虑到线程安全
	public Graph(){
		graph = new HashMap<Character, Vector<Character>>();
		initGraph();
	}
	
	public HashMap<Character, Vector<Character>> getGraph() {
		return graph;
	}

	public void setGraph(HashMap<Character, Vector<Character>> graph) {
		this.graph = graph;
	}
	
	public Vector<Character> getConnects(Character c){
		return this.graph.get(c);
	}
	/**
	 * To init the whole routes map.
	 * */
	private void initGraph(){
		connects = new Vector<Character>();
		connects.clear();
		connects.add('B');
		connects.add('H');
		connects.add('I');
		graph.put('A', connects);
		
		connects = new Vector<Character>();
		connects.add('A');
		connects.add('S');
		connects.add('J');
		connects.add('C');
		graph.put('B', connects);
		
		connects = new Vector<Character>();
		connects.add('B');
		connects.add('D');
		graph.put('C', connects);
		
		connects = new Vector<Character>();
		connects.add('C');
		connects.add('N');
		connects.add('E');
		graph.put('D', connects);
		
		connects = new Vector<Character>();
		connects.add('D');
		connects.add('F');
		graph.put('E', connects);
		
		connects = new Vector<Character>();
		connects.add('G');
		connects.add('E');
		graph.put('F', connects);
		
		connects = new Vector<Character>();
		connects.add('H');
		connects.add('F');
		graph.put('G', connects);
		
		connects = new Vector<Character>();
		connects.add('A');
		connects.add('G');
		connects.add('M');
		connects.add('S');
		graph.put('H', connects);
		
		connects = new Vector<Character>();
		connects.add('A');
		connects.add('S');
		graph.put('I', connects);
		
		connects = new Vector<Character>();
		connects.add('B');
		connects.add('N');
		graph.put('J', connects);
		
		connects = new Vector<Character>();
		connects.add('N');
		connects.add('L');
		graph.put('K', connects);
		
		connects = new Vector<Character>();
		connects.add('M');
		connects.add('K');
		graph.put('L', connects);
		
		connects = new Vector<Character>();
		connects.add('H');
		connects.add('L');
		graph.put('M', connects);
		
		connects = new Vector<Character>();
		connects.add('S');
		connects.add('J');
		connects.add('K');
		connects.add('D');
		graph.put('N', connects);
		
		
		connects = new Vector<Character>();
		connects.add('H');
		connects.add('I');
		connects.add('B');
		connects.add('N');
		graph.put('S', connects);
		
	}
	/**
	 * @return a Vector that holds all station's name.
	 * */
	public Vector<Character> getAllStates(){
		Vector<Character> states = new Vector<Character>();
		states.add('A');
		states.add('B');
		states.add('C');
		states.add('D');
		states.add('E');
		states.add('F');
		states.add('G');
		states.add('H');
		states.add('I');
		states.add('J');
		states.add('K');
		states.add('L');
		states.add('M');
		states.add('N');
		states.add('S');
		return states;
	}
	
}
