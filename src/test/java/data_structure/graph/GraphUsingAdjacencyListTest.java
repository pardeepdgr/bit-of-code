package data_structure.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphUsingAdjacencyListTest {

    @Test
    public void should_create_a_directed_graph() {
        String filename = "src/test/resources/data_structure/graph/directed/Website.txt";
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(filename, true);

        graph.print();
    }

    @Test
    public void should_create_an_undirected_graph() {
        String filename = "src/test/resources/data_structure/graph/undirected/Friendship.txt";
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(filename, false);

        graph.print();
    }

    @Test
    public void should_do_dfs_traverse_a_directed_graph() {
        String filename = "src/test/resources/data_structure/graph/directed/Website.txt";
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(filename, true);

        graph.dfs();
    }

    @Test
    public void should_do_bfs_traverse_an_undirected_graph() {
        String filename = "src/test/resources/data_structure/graph/undirected/Friendship.txt";
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(filename, false);

        graph.bfs();
    }
}