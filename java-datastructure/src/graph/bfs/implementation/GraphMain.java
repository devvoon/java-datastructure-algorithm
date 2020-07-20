package graph.bfs.implementation;

public class GraphMain {

	public static void main(String[] args) {
		//vertex가 4개인 그래프 생성 
		GraphBFS graphBFS = new GraphBFS(4);
		
		graphBFS.addEdge(0, 1);
		graphBFS.addEdge(0, 2);
		graphBFS.addEdge(1, 2);
		graphBFS.addEdge(2, 0);
		graphBFS.addEdge(2, 3);
		graphBFS.addEdge(3, 3);
		
		System.out.println("BFS");
		
		graphBFS.BFS(0);
		System.out.println("");
		
		graphBFS.BFS(1);
		System.out.println("");
		
		graphBFS.BFS(2);
		System.out.println("");
		
		graphBFS.BFS(3);
		System.out.println("");
		
		//vertex가 4개인 그래프 생성 
		GraphDFS graphDFS = new GraphDFS(4);
		
		graphDFS.addEdge(0, 1);
		graphDFS.addEdge(0, 2);
		graphDFS.addEdge(1, 2);
		graphDFS.addEdge(2, 0);
		graphDFS.addEdge(2, 3);
		graphDFS.addEdge(3, 3);
		
		System.out.println("DFS");
		
		graphDFS.DFS(0);
		System.out.println("");
		
		graphDFS.DFS(1);
		System.out.println("");
		
		graphDFS.DFS(2);
		System.out.println("");
		
		graphDFS.DFS(3);

	}

}
