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
        
        //vertex 입력 크기만큼 linked list 사이즈 정의(힙 영역에 크기만큼 자리 확보 : null) 
        adjacent = new LinkedList[vertex];

        //vertex의 갯수 만큼 linked list 초기화 ()
        for (int i = 0; i < vertex; i++) {
            //adjacent 
            adjacent[i] = new LinkedList<Integer>();
        }
    }
    
    //그래프에 edge 추가
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
        
        //stack이 empty 가 아닐때까지 top을 pop하여 출력 
        while(stack.size() !=0 ) {
            s=stack.pop();
            System.out.print(s + " ");
            
            Iterator<Integer> i = adjacent[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                   //방문여부 체크후 stack에 add 
                    visited[n]= true;
                    stack.add(n);
                }
            }
        }
    }
}
