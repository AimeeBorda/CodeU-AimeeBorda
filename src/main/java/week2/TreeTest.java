package week2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {

  private Node<Integer> exampleTree;
  private Node<Integer> emptyTree;
  private Node<Integer> simpleTree;
  private Tree<Integer> tree;

  @Before
  public void setUp() {
    setExampleTree();
    setEmptyTree();
    setSimpleTree();

    tree = new Tree<>();
  }

  @Test
  public void testPrintAncestorEmpty() {
    assertEquals("prints empty string for empty tree", "", tree.printAncestors(emptyTree, 5));
  }

  @Test
  public void testPrintAncestorSimple() {
    assertEquals("prints \"\" for root", "", tree.printAncestors(simpleTree, 7));
    assertEquals("prints \"8, 7\" for ancestor on LHS (5)", "8, 7",
        tree.printAncestors(simpleTree, 5));
    assertEquals("prints \"7\" for ancestor on RHS (6)", "7",
        tree.printAncestors(simpleTree, 6));
    assertEquals("prints empty string for non-existing key", "",
        tree.printAncestors(simpleTree, 9));
  }

  @Test
  public void testPrintAncestorExample() {
    assertEquals("prints \"5, 3, 9, 16\"", "3, 9, 16", tree.printAncestors(exampleTree, 5));
  }

  @Test
  public void testCommonAncestorEmpty() {
    assertNull("should return null for empty tree",
        tree.commonAncestor(emptyTree, 1, 2));
  }

  @Test
  public void testCommonAncestorNonExistingElements() {
    assertNull("should return null if one of the element does not exists (1,5)",
        tree.commonAncestor(emptyTree, 1, 5));
  }

  @Test
  public void testCommonAncestorSimple() {
    assertEquals("should return 8 for (10,5)", 8,
        (int) tree.commonAncestor(simpleTree, 10, 5));
    assertEquals("should return 8 for (5,10)", 8,
        (int) tree.commonAncestor(simpleTree, 5, 10));
    assertEquals("should return 7 for (6,10)", 7,
        (int) tree.commonAncestor(simpleTree, 6, 10));
  }

  @Test
  public void testCommonAncestorExample() {
    assertEquals("prints \"9\" for traversing tree (5,14)", 9,
        (int) tree.commonAncestor(exampleTree, 5, 14));
    assertEquals("prints \"9\" for traversing tree (14,5)", 9,
        (int) tree.commonAncestor(exampleTree, 14, 5));
    assertEquals("prints \"3\" for traversing tree (5,3)", 3,
        (int) tree.commonAncestor(exampleTree, 5, 3));
    assertEquals("prints \"3\" for traversing tree (3,5)", 3,
        (int) tree.commonAncestor(exampleTree, 3, 5));
    assertEquals("prints \"9\" for traversing tree (1,14)", 9,
        (int) tree.commonAncestor(exampleTree, 1, 14));
    assertEquals("prints \"16\" for traversing tree (1,19)", 16,
        (int) tree.commonAncestor(exampleTree, 1, 19));

    assertNull("should return null for (15,5)",
        tree.commonAncestor(exampleTree, 15, 6));
  }

  @Test
  public void testCommonAncestorSameKey() {
    assertEquals("prints \"5\" for traversing tree (5,5)", 5,
        (int) tree.commonAncestor(exampleTree, 5, 5));
  }

  private void setExampleTree() {
    exampleTree = new Node(
        new Node(
            new Node(
                new Node(1),
                3,
                new Node(5)),
            9,
            new Node(14)),
        16,
        new Node(
            null,
            18,
            new Node(19))
    );
  }

  private void setEmptyTree() {
    emptyTree = null;
  }

  private void setSimpleTree() {
    simpleTree = new Node(
        new Node<>(
            new Node(5),
            8,
            new Node(10)),
        7,
        new Node(6));
  }
}
