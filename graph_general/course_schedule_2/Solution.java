class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Graph g = new Graph(numCourses);
    for (int[] req : prerequisites) {
      g.addEdge(req[0], req[1]);
    }

    TopolSort tsort = new TopolSort(g);
    return tsort.cycle != null ? new int[0] : tsort.queue.stream().mapToInt(i -> i).toArray();
  }
}

class Graph {
  int v;
  ArrayList<Integer>[] adj;

  public Graph(int numCourses) {
    this.v = numCourses;
    adj = new ArrayList[v];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<Integer>();
    }
  }

  public void addEdge(int a, int b) {
    adj[b].add(a);
  }
}

class TopolSort {

  boolean[] marked;
  int[] edgeTo;
  LinkedList<Integer> queue = new LinkedList<Integer>();
  Stack<Integer> cycle;
  boolean[] onStack;

  public TopolSort(Graph g) {
    marked = new boolean[g.v];
    onStack = new boolean[g.v];
    edgeTo = new int[g.v];
    for (int i = 0; i < g.v; i++) {
      if (!marked[i]) dfs(g, i);
    }
  }

  private void dfs(Graph g, int i) {
    marked[i] = true;
    onStack[i] = true;

    for (int v : g.adj[i]) {
      if (cycle != null) return;
      if (!marked[v]) {
        edgeTo[v] = i;
        dfs(g, v);
      } else if (onStack[v]) {
        cycle = new Stack<Integer>();
        for (int x = i; x != v; x = edgeTo[x]) {
          cycle.push(x);
        }

        cycle.push(v);
        cycle.push(i);
      }
    }

    onStack[i] = false;
    queue.addFirst(i);
  }
}
