package shortestpath.dijkstra;

public class ShortestPath {

    //최소 거리 값
    static final int V=9; 

    public static void main(String[] args) {
        
        //인접행렬그래프로 표현 9*9
        int graph[][] = new int[][] { { 0,  4,  0,  0,  0,  0,  0,  8,  0 },
                                      { 4,  0,  8,  0,  0,  0,  0, 11,  0 },
                                      { 0,  8,  0,  7,  0,  4,  0,  0,  2 },
                                      { 0,  0,  7,  0,  9, 14,  0,  0,  0 },
                                      { 0,  0,  0,  9,  0, 10,  0,  0,  0 },
                                      { 0,  0,  4, 14, 10,  0,  2,  0,  0 },
                                      { 0,  0,  0,  0,  0,  2,  0,  1,  6 },
                                      { 8, 11,  0,  0,  0,  0,  1,  0,  7 },
                                      { 0,  0,  2,  0,  0,  0,  6,  7,  0 } };
         
        ShortestPath ShortestPath = new ShortestPath();
        ShortestPath.dijsktra(graph,0);

    }
    
    /**
     * 인접행렬로 계산하는 dijsktra 
     * @param graph
     * @param src
     */
    public void dijsktra(int graph[][], int src) {
        
        //결과를 담을 배열 distnadce
        int distance[] = new int[V];
        
        //shortest path 구했는지 여부
        Boolean sptSet[]  = new Boolean[V];
        
        //초기화 
        for (int i = 0; i < V; i++) {
            //infinite는 max_value로 셋팅  = 2147483647
            distance[i] = Integer.MAX_VALUE;
            //최단경로 구하지않았으니 false
            sptSet[i] = false;
        }
        
        System.out.println(" 초기화된 배열");
        
        toString(distance);
        System.out.println();
        // source 정점에서 자기자신까지의 거리는 언제나 0
        distance[src] = 0;
        
        //최단경로 찾기 
        for (int count = 0; count < V-1; count++) {
            
            //distance배열에서 최단경로를 못찾은 정점을 index를 찾아 u에 저장
            int u = minDistance(distance, sptSet);
            System.out.println( count + ".  " + u + " 까지의 최단경로 찾기");
            //선택된 점정u에서 최단경로를 찾을 것이기 때문에 자기자신은 true로 변경해두어야함 
            sptSet[u] = true;

            //정점 u에서 v까지 가는 최단거리 계산 로직
            for (int v = 0; v < V; v++) {

                System.out.println( " ." + v + " : " + sptSet[v]  +  "   " + graph[u][v] + " +  " + distance[u] + " < " + distance[v] );
                
                // 1. !sptSet[v] ; false = 최단경로 아직 못찾은 vertex 
                // 2. graph[u][v] != 0 ; u에서 v까지의 엣지가 있어야함 ( 거리가 0 아니여야함 )
                // 3. 최단경로를 찾으려는 정점이 현재 경로가 infinite 가 아니여아 함 (값이 있어야함)
                // 4. (((distance[u] + graph[u][v]) < distance[v])) ; src에서 v에서 u까지의 총 경로 가중치  < distance [v]의 현재 값보다 작아야 함
                if (!sptSet[v] && (graph[u][v] != 0) &&  (distance[u] != Integer.MAX_VALUE)  && (((distance[u] + graph[u][v]) < distance[v]))) {
                    //결과값에 최단경로 update 해주기 
                    distance[v] = distance[u] + graph[u][v]; 
                    System.out.println("   * result : " + distance[v] + " <= "  + distance[u] + " + " + graph[u][v] );
                } 
            
            }
        }
        
        toString(distance);
    }

    /**
     * 최단경로 못찾은 정점 찾기
     * @param distance
     * @param sptSet
     * @return
     */
    public int minDistance(int[] distance, Boolean[] sptSet) {
        //최소값 초기화
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        
        System.out.println("최단경로 못찾은 정점 찾기");
        for (int v = 0; v < V; v++) {
            // 결과배열 0~9까지 최단경로를 찾지못했고, 배열이 초기값(infinite)값과 같거나 작으면 
            if (sptSet[v] == false && distance[v] <= min) {
                //아직 최단경로를 찾지 못한 정점임
                System.out.println("" + v  + " : " + distance[v]);
                min = distance[v];
                min_index = v;
                //for문을 다 돌렸을 때, 최소값 인덱스가 나오게 되어있음
            }
        }
        //최단경로 못 찾은 인덱스 return
        return min_index;
    }
    
    /**
     * print result
     * @param distance
     */
    public void toString(int[] distance) {
        
        System.out.println();
        System.out.println("Vertex \t Distance from Source"); 
        for (int i = 0; i < V; i++) {
            System.out.println(i+ " \t " + distance[i]);
        }

    }
    

}
