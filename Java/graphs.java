import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

class WeightsClass implements Comparator<WeightsClass> {
    int value, cost;

    WeightsClass() {
    }

    WeightsClass(int _value, int _cost) {
        this.value = _value;
        this.cost = _cost;
    }

    int getValue() {
        return value;
    }

    int getCost() {
        return cost;
    }

    @Override
    public int compare(WeightsClass node1, WeightsClass node2) {
        if (node1.cost < node2.cost)
            return 1;
        if (node1.cost > node2.cost)
            return -1;
        return 0;
    }
}

public class graphs {
    public void BFS(ArrayList<ArrayList<Integer>> a, int n, int source) {
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                if (source != 0) {
                    q.add(source);
                    visited[source] = true;
                    source = 0;
                } else {
              
                    q.add(i);
                    visited[i] = true;
                }
                System.out.println("\nBFS is");
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    System.out.print(cur + " ");
                    for (int val : a.get(cur)) {
                        if (visited[val] == false) {
                            q.add(val);
                            visited[val] = true;
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public void DFS(ArrayList<ArrayList<Integer>> a, int n, int source) {
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited[i] == false) {
                Stack<Integer> s = new Stack<Integer>();
                if (source != 0) {
                    s.push(source);
                    visited[source] = true;
                    source = 0;
                } else {
                    s.push(i);
                    visited[i] = true;
                }
                System.out.println("\nDFS is");
                while (!s.empty()) {
                    int val = s.pop();
                    System.out.print(val + " ");
                    for (int j : a.get(val)) {
                        if (visited[j] == false) {
                            s.push(j);
                            visited[j] = true;
                        }
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public boolean checkCycleUndirectedBFS(ArrayList<ArrayList<Integer>> a, boolean[] visited, int i) {
        Queue<int[]> q = new LinkedList<>();
        visited[i] = true;
        q.add(new int[] { i, -1 });

        while (!q.isEmpty()) {
            int[] values = q.poll();
            int node = values[0];
            int par = values[1];
            for (int j : a.get(node)) {
                if (visited[j] == false) {
                    q.add(new int[] { j, node });
                    visited[j] = true;
                } else if (par != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public void isCyclicUndirectedBFS(ArrayList<ArrayList<Integer>> a, int n) {
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited[i] == false) {
                if (checkCycleUndirectedBFS(a, visited, i)) {
                    System.out.println("[BFS] - Cycle is detected in this graph");
                    return;
                }
            }
        }
        System.out.println("[BFS] - No Cycle is detected in this graph");
        return;
    }

    public boolean checkCycleUndirectedDFS(ArrayList<ArrayList<Integer>> a, boolean visited[], int parent, int node) {
        visited[node] = true;
        for (int i : a.get(node)) {
            if (visited[i] == false) {
                if (checkCycleUndirectedDFS(a, visited, node, i) == true)
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    public void isCyclicUndirectedDFS(ArrayList<ArrayList<Integer>> a, int n) {
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited[i] == false) {
                if (checkCycleUndirectedDFS(a, visited, -1, i)) {
                    System.out.println("[DFS] - Cycle is detected in this graph");
                    return;
                }
            }
        }
        System.out.println("[DFS] - No Cycle is detected in this graph");
        System.out.println();
        return;
    }

    public boolean cycleDirected(ArrayList<ArrayList<Integer>> a, boolean visited[], boolean dfsVisi[], int i) {
        visited[i] = true;
        dfsVisi[i] = true;

        for (int j : a.get(i)) {
            if (visited[j] == false) {
                if (cycleDirected(a, visited, dfsVisi, j) == true)
                    return true;
            } else if (dfsVisi[j] == true)
                return true;
        }
        dfsVisi[i] = false;
        return false;
    }

    public void isCyclicDirected(ArrayList<ArrayList<Integer>> a, int n) {
        boolean[] visited = new boolean[n + 1];
        boolean[] dfsVisi = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited[i] == false) {
                if (cycleDirected(a, visited, dfsVisi, i)) {
                    System.out.println("Cycle detected");
                    return;
                }
            }
        }
        System.out.println("No Cycle detected");
        return;
    }

    public boolean checkBipartiteBFS(ArrayList<ArrayList<Integer>> a, int i, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        colors[i] = 1;

        while (!q.isEmpty()) {
            int val = q.poll();
            for (int j : a.get(val)) {
                if (colors[j] == -1) {
                    q.add(j);
                    
                    colors[j] = 1 - colors[val];
                } else if (colors[j] == colors[val]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBipartiteDFS(ArrayList<ArrayList<Integer>> a, int i, int[] colors) {
        if (colors[i] == -1)
            colors[i] = 1;
        for (int j : a.get(i)) {
            if (colors[j] == -1) {
                colors[j] = 1 - colors[i];

                if (!checkBipartiteDFS(a, j, colors)) {
                    return false;
                }
            } else if (colors[j] == colors[i])
                return false;
        }
        return true;
    }

    public void isBipartite(ArrayList<ArrayList<Integer>> a, int n, int checking) {
        int[] colors = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            colors[i] = -1;
        if (checking == 0) {
            for (int i = 1; i <= n; ++i) {
                if (colors[i] == -1) {
                    if (checkBipartiteBFS(a, i, colors) == true) {
                        System.out.println("[BFS] - It is a bipartite graph");
                        return;
                    }
                }
            }
            System.out.println("[BFS] - It's not a bipartite graph");
            return;
        } else {
            for (int i = 1; i <= n; ++i) {
                if (colors[i] == -1) {
                    if (checkBipartiteDFS(a, i, colors) == true) {
                        System.out.println("[DFS] - It is a bipartite graph");
                        return;
                    }
                }
            }
            System.out.println("[DFS] - It's not a bipartite graph");
            System.out.println();
            return;
        }
    }

    public void findTopoSort(ArrayList<ArrayList<Integer>> a, Stack<Integer> s, boolean visited[], int i) {
        visited[i] = true;

        for (int j : a.get(i)) {
            if (visited[j] == false) {
                findTopoSort(a, s, visited, j);
            }
        }

        s.push(i);
    }

    public void topoSort(ArrayList<ArrayList<Integer>> a, int n) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (visited[i] == false) {
                findTopoSort(a, s, visited, i);
            }
        }
        System.out.print("Topological sort is ");
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void Dijskarta(ArrayList<ArrayList<WeightsClass>> b, int n, int src) {
        PriorityQueue<WeightsClass> p = new PriorityQueue<>(new WeightsClass());
        p.add(new WeightsClass(src, 0));

        int dis[] = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        while (!p.isEmpty()) {
            WeightsClass node = p.poll();

            // Instead of cost and value you can also use the getCost() and getValue()
            // methods which are already defined
            for (WeightsClass i : b.get(node.value)) {
                if (node.cost + i.cost < dis[i.value]) {
                    dis[i.value] = node.cost + i.cost;
                    p.add(new WeightsClass(i.value, dis[i.value]));
                }
            }
        }
        System.out.print("Dijskarta single source shortest path for " + src + " is ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(dis[i] + " ");
        }
    }

    public void floydWarshall(ArrayList<ArrayList<WeightsClass>> b, int n){
        int shortestArr[][] = new int[n+1][n+1];
        
        for(int[] row:shortestArr){
            Arrays.fill(row, 999);
        }
        
        for(int i=1; i<=n; ++i){
                ArrayList<WeightsClass> node = b.get(i);
                for(WeightsClass k : node){
                    shortestArr[i][k.value] = k.cost;
            }
        }

        for(int k=1; k<=n; ++k){
            for(int i=1; i<=n; ++i){
                for(int j=1; j<=n; ++j){
                    if(i==j)  continue;
                    shortestArr[i][j] = Math.min(shortestArr[i][j], shortestArr[i][k] + shortestArr[k][j]);
                }
            }
        }

        System.out.println("\n\nFloyds Warshall's all pair shortest path matrix is ");
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                System.out.print(shortestArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void BellmanFord(ArrayList<ArrayList<WeightsClass>> b, int n){
        int dist[] = new int[n+1];
        Arrays.fill(dist, 999);

        dist[1] = 0;
        for(int i=1; i<=n-1; ++i){
            for(int j=1; j<b.size(); ++j){
                for(WeightsClass node : b.get(j)){
                    if(dist[j] + node.cost < dist[node.value]){
                        dist[node.value] = dist[j] + node.cost;
                    }
                }
            }
        }

        for(int j=1; j<b.size(); ++j){
            for(WeightsClass node : b.get(j)){
                if(dist[j] + node.cost < dist[node.value]){
                    System.out.println("Negative weights cycle detected by BellmanFord's algorithm");
                    return;
                }
            }
        }

        System.out.print("BellmanFord shortest algorithm path is ");
        for(int i=1; i<=n; ++i) System.out.print(dist[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of nodes and edges");
        int nodes = scan.nextInt(), edges = scan.nextInt();

        boolean negativeEdges = false;
        System.out.println("Is it a weighted graph?(y/n)");
        char weightedGraph = scan.next().charAt(0);
        System.out.println("Is it a directed graph?(y/n)");
        char directedGraph = scan.next().charAt(0);

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<WeightsClass>> b = new ArrayList<ArrayList<WeightsClass>>();
        for (int i = 0; i <= nodes; ++i) {
            a.add(new ArrayList<>());
            if (weightedGraph == 'y') {
                b.add(new ArrayList<WeightsClass>());
            }
        }

        for (int i = 1; i <= edges; ++i) {
            System.out.println("Enter the source and destination of an edge");
            int s = scan.nextInt();
            int d = scan.nextInt();
            a.get(s).add(d);
            if(directedGraph == 'n') a.get(d).add(s);

            if (weightedGraph == 'y') {
                System.out.println("Enter the weight between them");
                int w = scan.nextInt();
                if(w < 0) negativeEdges = true;
                b.get(s).add(new WeightsClass(d, w));
                if(directedGraph == 'n') b.get(d).add(new WeightsClass(s, w));
            }
        }
        
        System.out.println("Adjacency List for the graph is");
        for (int i = 1; i <= nodes; ++i) {
            if (weightedGraph == 'n')
                System.out.println(i + " " + a.get(i));
            else {
                ArrayList<WeightsClass> node = b.get(i);
                for(int j=0; j<node.size(); ++j){
                    System.out.println(i + " " + node.get(j).value + " and weight is " + node.get(j).cost);
                }
            }
        }

        graphs obj = new graphs();
        System.out.println("\nEnter the source node for the BFS and as well as DFS");
        int source = scan.nextInt();
        obj.BFS(a, nodes, source);
        obj.DFS(a, nodes, source);

        if (directedGraph == 'n') {
            obj.isCyclicUndirectedBFS(a, nodes);
            obj.isCyclicUndirectedDFS(a, nodes);
        } else {
            obj.isCyclicDirected(a, nodes);
        }

        obj.isBipartite(a, nodes, 0);
        obj.isBipartite(a, nodes, 1);

        if (directedGraph == 'n')
            obj.topoSort(a, nodes);

        if (weightedGraph == 'y') {
            System.out.print("\nEnter the source for shortest path ");
            int src = scan.nextInt();
            if(negativeEdges){
                System.out.println("\nThis graph is having negative edges, so the shortest path from " + src + " can't be calculated using Dijskarta algorithm.");
            }
            else {
                //Limitation for Dijskarta
                //Wont work for negative weights and it leads to the infinite loop
                obj.Dijskarta(b, nodes, src);
            }
        }

        obj.floydWarshall(b, nodes);

        //Limitaiton for BellmanFord
        //It should not contain any negative cycle
        //And this algorithm can even tell whether there contains any negative weight cycle in the graph
        //this algorithm works only on directed graph and if there is a undirected graph then the graph has to be converted to directed graph by making bi-directional edges.
        //TC-O(N-1) * O(E) --> bad time complexity than dijskarta but still we can easily detect negative weight cycle
        //SC-O(N)
        obj.BellmanFord(b, nodes);

        scan.close();
    }
}