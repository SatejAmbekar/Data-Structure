public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(9);
        g.init();
        g.display();
        System.out.println();
        g.dfs(0);
        g.dfs(6);
        System.out.println();

        g.dfs(0, new int[g.getNoOfVertices()]);

        System.out.println();
        g.bfs(0);

    }
}
