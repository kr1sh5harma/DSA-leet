//depth first search on undirected graph, adjacency list is given as input
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); // Total number of vertices
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();

        // Start DFS traversal from vertex 0 as required by the problem
        dfsHelper(0, adj, visited, result);

        return result;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        // 1. Mark current node as visited
        visited[node] = true;
        result.add(node);

        // 2. Visit all neighbors in the order they appear in the adjacency list
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
}
