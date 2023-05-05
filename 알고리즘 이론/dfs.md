# 깊이 우선 탐색(DFS)
* 그래프 탐색 시, 현재 탐색중인 분기를 깊게 탐색하는 방식 
* 가장 깊은 노드까지 도달했을 때 탐색한 경로를 역추적하여 되돌아나오기 위해 스택을 사용
* 방문한 노드를 다시 방문하지 않기 위해 방문한 노드를 따로 저장


## 동작 순서
1. 루트 노드를 스택에 넣고 방문처리
2. 인접 노드 중 방문하지 않은 노드 하나를 스택에 넣고 방문처리, 만약 입접 노드를 모두 방문한 경우 스택 pop
3. 2 단계를 더 이상 수행할 수 없을 때까지 반복



## 

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
    	Stack<Integer> stack = new Stack<>();
    	stack.push(start);
    	
    	while(!stack.isEmpty()) {
    		int currentNode = stack.pop();
    		
    		for(int node : graph[currentNode]) {
    			if(!visited[node]) {
    				stack.push(node);
    				visited[node] = true;
    			}
    		}
    	}  	
 ```


 
