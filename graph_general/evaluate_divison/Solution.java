
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        double[] result = new double[queries.size()];

        for (List<String> equation: equations){
            for (String str: equation){
                if (!map.containsKey(str)) map.put(str, map.size());
            } 
        }

        Graph graph = new Graph(map.size());
        int count = 0;
        for (List<String> equation: equations){
            graph.addEdge(map.get(equation.get(0)), map.get(equation.get(1)), values[count]);
            count++;
        }

        count = 0;
        for (List<String> query: queries){
            int a, b;
            boolean marked[] = new boolean[graph.v];

            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))){
                a = map.get(query.get(0));
                b =  map.get(query.get(1));
                //System.out.printf("a %d b %d\n", a, b);
            } else{
                result[count] = -1;
                count++;
                continue;
            }

            result[count] = dfs(marked, graph, a, b, 1);
            count++;
        }

        return result;
    }


    private double dfs(boolean marked[], Graph g, int s, int target, double r){
        marked[s] =true;
        if (s==target) return Math.abs(r);

        for (Edge e: g.adj[s]){
            if (! marked[e.to]){
                r *= e.val;
                double res = dfs(marked, g, e.to, target, r);
                if (res!=-1) return res;
                r /= e.val;
            }
        }

        return -1;
    }
}

class Edge{
    int to;
    double val;

    public Edge( int b, double val){
        this.to = b;
        this.val = val;
    }
}

class Graph{
    ArrayList<Edge>[] adj;
    int v;

    public Graph(int v){
        this.v = v;
        adj = new ArrayList[v];
        for (int i=0; i< v; i++){
            adj[i] = new ArrayList<Edge>();
        }
    }

    public void addEdge(int a, int b, double val){
        Edge e1 = new Edge(b, val);
        Edge e2 = new Edge(a, 1.0/val);
        adj[a].add(e1);
        adj[b].add(e2);
    } 
}
