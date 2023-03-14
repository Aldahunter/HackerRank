import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int total = 0;

    public int getResult() {
        return total;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        total += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private final static long PRIME_MOD_DIVISOR = 1000000007;
    private long redTotal = 1L;

    public int getResult() {
        return (int) (redTotal % PRIME_MOD_DIVISOR);
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED)
            redTotal = (redTotal * node.getValue()) % PRIME_MOD_DIVISOR;
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED)
            redTotal = (redTotal * leaf.getValue()) % PRIME_MOD_DIVISOR;
    }
}

class FancyVisitor extends TreeVis {
    private int greenLeafTotal = 0;
    private int evenNodeTotal = 0;

    public int getResult() {
        return java.lang.Math.abs(evenNodeTotal - greenLeafTotal);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0)
            evenNodeTotal += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN)
            greenLeafTotal += leaf.getValue();
    }
}

public class Solution {

    private int treeSize;
    private List<Integer> nodeValues;
    private List<Color> nodeColours;
    private Map<Integer, Set<Integer>> nodeEdges;

    private Solution (int treeSize) {
        this.treeSize = treeSize;
        nodeValues = new ArrayList<>(treeSize);
        nodeColours = new ArrayList<>(treeSize);
        nodeEdges = new HashMap<>();
    }

    private void getValues(Scanner scanner) {
        for (int i = 0; i<treeSize; i++)
            nodeValues.add(scanner.nextInt());
    }

    private void getColours(Scanner scanner) {
        for (int i=0; i<treeSize; i++)
            nodeColours.add(scanner.nextInt() == 1 ? Color.GREEN : Color.RED);
    }

    private void getEdges(Scanner scanner) {
        for (int i=0; i<treeSize-1; i++) {
            int parent = scanner.nextInt() - 1;
            int child = scanner.nextInt() - 1;

            addEdge(parent, child);
            addEdge(child, parent);
        }
    }

    private void addEdge(int u, int v) {
        Set<Integer> edges = getEdges(u);
        edges.add(v);
        nodeEdges.put(u, edges);
    }

    private Set<Integer> getEdges(int node) {
        Set<Integer> edges = nodeEdges.get(node);
        return (edges != null) ? edges : new HashSet<Integer>();
    }

    private static Tree buildNode(int value, Color color, int depth, boolean isLeaf) {
        if (isLeaf)
            return new TreeLeaf(value, color, depth);
        else
            return new TreeNode(value, color, depth);
    }

    private Tree buildTree() {
        Set<Integer> children = getCleanChildren(0);

        Tree rootNode = buildNode(
                nodeValues.get(0),
                nodeColours.get(0),
                0,
                children.isEmpty()
        );

        if (!children.isEmpty())
            buildChildNodes((TreeNode) rootNode, children);

        return rootNode;
    }

    private void buildChildNodes(TreeNode parent, Set<Integer> children) {
        for (int child: children) {
            Set<Integer> grandChildren = getCleanChildren(child);

            Tree childNode = buildNode(
                    nodeValues.get(child),
                    nodeColours.get(child),
                    parent.getDepth() + 1,
                    grandChildren.isEmpty()
            );
            parent.addChild(childNode);

            if (!grandChildren.isEmpty())
                buildChildNodes((TreeNode) childNode, grandChildren);
        }
    }

    private Set<Integer> getCleanChildren(int parentNode) {
        Set<Integer> children = getEdges(parentNode);
        for (Integer child: children)
            getEdges(child).remove(parentNode);
        return children;
    }

    public static Tree solve() {
        try (Scanner scanner = new Scanner(System.in)) {
            int numNodes = scanner.nextInt();
            Solution solution = new Solution(numNodes);

            solution.getValues(scanner);
            solution.getColours(scanner);
            solution.getEdges(scanner);

            return solution.buildTree();
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}