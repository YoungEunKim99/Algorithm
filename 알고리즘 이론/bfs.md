# 너비 우선 탐색(BFS)
* 인접 노드부터 탐색하는 알고리즘
* 선입선출 방식인 큐 자료구조 사용


## 동작 순서
1. 탐색 시작 노드를 큐에 삽입하고 방문처리
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리
3. 1,2번 과정을 반복

### 코드 
``` java
    	int start = 1;
    	int[][] graph = {
    				{},
    			  	{2, 3, 8},
    		        {1, 7},
    		        {1, 4, 5},
    		        {3, 5},
    		        {3, 4},
    		        {7},
    		        {2, 6, 8},
    		        {1, 7}
    		        };
    	
    	
    	boolean[] visited = new boolean[graph.length + 1];
    	Arrays.fill(visited, false);
    	
    	visited[start] = true;
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(start);
    	
    	while(!queue.isEmpty()) {
    		int currentNode = queue.poll();
    		
    		for(int node : graph[currentNode]) {
    			if(!visited[node]) {
    				visited[node] = true;
    				queue.add(node);
    			}
    		}
    	}
 ```


 