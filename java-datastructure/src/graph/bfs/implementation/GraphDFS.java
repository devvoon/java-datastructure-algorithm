package graph.bfs.implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDFS {

	private int Vertex;
	private LinkedList<Integer> adjacent[];

	//그래프 생성
	GraphDFS(int vertex){
		Vertex = vertex;
		
		//vertex 입력 크기만큼 초기화 
		adjacent = new LinkedList[vertex];
		
		//vertex의 갯수 만큼 linked list 생성
		for (int i = 0; i < vertex; i++) {
			//adjacent 
			adjacent[i] = new LinkedList();
		}
	}
	
	//그래프에 edgd 추가
	void addEdge(int vertex, int input) {
		adjacent[vertex].add(input);
	}
	
	//Stack 생성  
	void DFS(int s) {
		boolean visited[] = new boolean[Vertex];
		Stack<Integer> stack = new Stack<Integer>();
		
		//vertex 입력 
		visited[s] =true;
		stack.add(s);
		
		//	non-empty 가 될때까지 
		while(stack.size() !=0 ) {
			// stack의 head pop
			s=stack.pop();
			System.out.print(s + " ");
			
			Iterator<Integer> i = adjacent[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n]= true;
					stack.add(n);
				}
			}
		}
	}
	
	
}
