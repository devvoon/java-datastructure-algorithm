package graph.bfs.implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
	
	private int Vertex;
	private LinkedList<Integer> adjacent[];

	//그래프 생성
	GraphBFS(int vertex){
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
	
	// linked list로 Queue를 구현 
	void BFS(int s) {
		
		boolean visited[] = new boolean[Vertex];
		Queue<Integer> queue = new LinkedList();
		
		//방문했던곳 체크  
		visited[s] =true;
		queue.add(s);
		
		//queue가 empty  
		while(queue.size() !=0 ) {
			//queue의 head를 출력  
			s=queue.poll();
			System.out.print(s + " ");
			
			Iterator<Integer> i = adjacent[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					//  mark and enqueue all (unvisited) neighbours of u
					visited[n]= true;
					queue.add(n);
				}
			}
		}
	}
	
	
}