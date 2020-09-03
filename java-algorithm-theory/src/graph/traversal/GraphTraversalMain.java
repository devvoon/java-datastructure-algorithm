package graph.traversal;

/**
 * Graph Traversal Main
 * @author iamdawoonjeong
 *
 */
public class GraphTraversalMain {

    public static void main(String[] args) {
        
        System.out.println("[ * BFS * ]");
        
        //vertex가 7개인 그래프 생성 
        BFS bfs = new BFS(4);
        
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        
        //vertex 0 부터 시작
        bfs.BFS(0);
        System.out.println("");
        
        //vertex가 7개인 그래프 생성 
        BFS bfs2 = new BFS(7);
        
        bfs2.addEdge(0, 1);
        bfs2.addEdge(0, 2);
        bfs2.addEdge(1, 3);
        bfs2.addEdge(1, 4);
        bfs2.addEdge(2, 5);
        bfs2.addEdge(2, 6);
        
        //vertex 0 부터 시작
        bfs2.BFS(0);
        System.out.println("");
        
        
        System.out.println("[ * DFS * ]");
        //vertex가 4개인 그래프 생성 
        DFS dfs = new DFS(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        //0 부터 시작
        dfs.DFS(0);
        System.out.println("");
        
        
        //vertex가 7개인 그래프 생성 
        DFS dfs2 = new DFS(7);

        dfs2.addEdge(0, 1);
        dfs2.addEdge(0, 2);
        dfs2.addEdge(1, 3);
        dfs2.addEdge(1, 4);
        dfs2.addEdge(2, 5);
        dfs2.addEdge(2, 6);

        //0 부터 시작
        dfs2.DFS(0);
        System.out.println("");
        
        
        
        
    }

}
