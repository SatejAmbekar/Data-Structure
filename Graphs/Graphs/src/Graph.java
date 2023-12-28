import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int noOfVertices;
    private char[] vertices;
    private int[][] adjMat;

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        vertices = new char[noOfVertices];
        adjMat = new int[noOfVertices][noOfVertices];
    }

    public void init() {
        for (int i = 0; i < noOfVertices; i++) {
            vertices[i] = (char) (65 + i);
        }

        int inputArr[] = {0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int k = 0;

        for (int i = 0; i < noOfVertices; i++) {
            for (int j = 0; j < noOfVertices; j++) {
                adjMat[i][j] = inputArr[k++];
            }
        }
    }

    public void display() {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < noOfVertices; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < noOfVertices; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < noOfVertices; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int v) {

        System.out.print("DFS: ");

        int [] visited = new int[noOfVertices];
        Stack<Integer> stack = new Stack<>();

        System.out.print(vertices[v] + " ");
        visited[v] = 1;
        stack.push(v);

        while(!stack.empty()) {

            for(int i = 0; i < noOfVertices; i++) {
                if(adjMat[v][i] == 1 && visited[i] == 0) {
                    System.out.print(vertices[i] + " ");
                    visited[i] = 1;
                    stack.push(i);

                    v = i;
                    i = -1;
                }
            }

            stack.pop();
            if(!stack.empty()) {
                v = stack.peek();
            }

        }
        System.out.println();

    }

    public void dfs(int v, int [] visited) {

        if(visited[v] == 1) {
            return;
        }

        System.out.print(vertices[v] + " ");
        visited[v] = 1;

        for(int i = 0; i < noOfVertices; i++) {
            if(adjMat[v][i] == 1) {
                dfs(i, visited);
            }
        }

    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public void bfs(int v) {
        int [] visited = new int[9];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(v);

        System.out.print("BFS: ");
        while(!queue.isEmpty()) {
            v = queue.removeFirst();
            if(visited[v] == 0) {
                System.out.print(vertices[v] + " ");
                visited[v] = 1;

                for(int i = 0; i < noOfVertices; i++) {
                    if(adjMat[v][i] == 1 && visited[i] == 0) {
                        queue.addLast(i);
                    }
                }
            }
        }
        System.out.println();
    }
}
