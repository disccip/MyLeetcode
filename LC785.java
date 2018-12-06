// 785. Is Graph Bipartite? --------- medium

class LC785 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++)
        {
            if (colors[i] == -1)
            {
                colors[i] = 0;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty())
                {
                    int node = stack.pop();
                    for (int neighbor : graph[node])
                    {
                        if (colors[neighbor] == -1)
                        {
                            colors[neighbor] = colors[node] ^ 1;
                            stack.push(neighbor);
                        }
                        else if (colors[neighbor] == colors[node])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}