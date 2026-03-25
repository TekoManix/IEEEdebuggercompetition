import org.junit.*;
import java.util.*;

public class TestCases {

    @Test
    public void Test1(){
        //PLEASE USE ASSERTIONS TO WRITE TESTS THIS WAS IN PLACE TO SET UP THE FILE AND MAKE SURE JUNITS ARE WORKING
        int a = 1;
        Assert.assertEquals(1, a);
    }

    @Test
    public void Test2(){

    }

    @Test
    public void Test3(){

    }

    // TASK 4: BST SEARCH

    @Test
    public void Test4() throws Exception {
        String path = "data/binary_trees/valid_bst.txt";

        // Values that exist in the tree: (10 (5 (3 _ _) (7 _ _)) (15 (12 _ _) (20 _ _)))
        Assert.assertTrue("Should find root value 10",
            Main.task4(path, 10));
        Assert.assertTrue("Should find leaf value 3",
            Main.task4(path, 3));
        Assert.assertTrue("Should find right subtree value 20",
            Main.task4(path, 20));

        // Values that do NOT exist
        Assert.assertFalse("Should not find value 99",
            Main.task4(path, 99));
        Assert.assertFalse("Should not find value 0",
            Main.task4(path, 0));
    }

    // TASK 5: IN-ORDER TRAVERSAL

    @Test
    public void Test5() throws Exception {
        // In-order of valid_bst.txt should be sorted: [3, 5, 7, 10, 12, 15, 20]
        List<Integer> result = Main.task5("data/binary_trees/valid_bst.txt");
        List<Integer> expected = Arrays.asList(3, 5, 7, 10, 12, 15, 20);
        Assert.assertEquals("In-order traversal should return sorted values",
            expected, result);

        // Single node tree: (42 _ _) -> [42]
        List<Integer> single = Main.task5("data/binary_trees/valid_single_node.txt");
        Assert.assertEquals("Single node should return one element",
            Collections.singletonList(42), single);
    }

    // TASK 6: HASH MAP LOOKUP

    @Test
    public void Test6() throws Exception {
        String path = "data/hash_maps/valid_map.txt";

        // Keys that exist
        Assert.assertEquals("Should find 'name'",
            "Alice", Main.task6(path, "name"));
        Assert.assertEquals("Should find 'age'",
            "30", Main.task6(path, "age"));
        Assert.assertEquals("Should find 'student_id'",
            "12345", Main.task6(path, "student_id"));

        // Key that does NOT exist
        Assert.assertNull("Should return null for missing key", Main.task6(path, "email"));
    }

    // TASK 7: FIND DUPLICATE VALUES

    @Test
    public void Test7() throws Exception {
        // valid_map.txt has all unique values — no duplicates expected
        Map<String, List<String>> dupes =
            Main.task7("data/hash_maps/valid_map.txt");
        Assert.assertTrue("No duplicate values in valid_map.txt",
            dupes.isEmpty());
    }

    @Test
    public void Test8(){

    }

    @Test
    public void Test9(){

    }

    @Test
    public void Test10(){

    }
}
