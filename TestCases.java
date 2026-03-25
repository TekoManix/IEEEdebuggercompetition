import org.junit.*;
import org.junit.Assert;

import java.util.*;

public class TestCases {

    @Test
    /**
     * Task 1: Password Cracking
     */
    public void Test1() {

        boolean task1 =  Main.task1_Valid_Password();
        Assert.assertTrue(task1);
    }

    /**
     *  Task 2: Linked List Remove Function
     */
    @Test
    public void Test2() {
        IEEE_Linked_List test = new IEEE_Linked_List();
        LinkedList<Integer> accepted = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            test.add(i * 2);
            accepted.add(i * 2);
        }

        test.remove(2);
        accepted.remove(2);

        for(int i = 0; i < 10; i++){
            int t = test.get(i);
            int a = accepted.get(i);
            Assert.assertEquals(t, a);
        }

    }

    /**
     * Task 3: Linked List swap function
     */
    @Test
    public void Test3() {
        LinkedList<Integer> accepted = new LinkedList<>();
        IEEE_Linked_List test = new IEEE_Linked_List();

        for(int i = 0; i < 10; i++){
            test.add(i * 4);
            accepted.add(i * 4);
        }

        test.swap(2, 4);
        Collections.swap(accepted, 2, 4);

        for(int i = 0; i < 10; i++){
            int t = test.get(i);
            int a = accepted.get(i);
            Assert.assertEquals(t, a);
        }

    }

    /**
     * TASK 4: BST SEARCH
     */
    @Test
    public void Test4() throws Exception {
        String path = "data/binary_trees/valid_bst.txt";

        // Values that exist in the tree: (10 (5 (3 _ _) (7 _ _)) (15 (12 _ _) (20 _ _)))
        Assert.assertTrue("Should find root value 10",
                Solutions.task4(path, 10));
        Assert.assertTrue("Should find leaf value 3",
                Solutions.task4(path, 3));
        Assert.assertTrue("Should find right subtree value 20",
                Solutions.task4(path, 20));

        // Values that do NOT exist
        Assert.assertFalse("Should not find value 99",
                Solutions.task4(path, 99));
        Assert.assertFalse("Should not find value 0",
                Solutions.task4(path, 0));
    }

    /**
     * TASK 5: IN-ORDER TRAVERSAL
     */
    @Test
    public void Test5() throws Exception {
        // In-order of valid_bst.txt should be sorted: [3, 5, 7, 10, 12, 15, 20]
        List<Integer> result = Solutions.task5("data/binary_trees/valid_bst.txt");
        List<Integer> expected = Arrays.asList(3, 5, 7, 10, 12, 15, 20);
        Assert.assertEquals("In-order traversal should return sorted values",
                expected, result);

        // Single node tree: (42 _ _) -> [42]
        List<Integer> single = Solutions.task5("data/binary_trees/valid_single_node.txt");
        Assert.assertEquals("Single node should return one element",
                Collections.singletonList(42), single);
    }

    /**
     * TASK 6: HASH MAP LOOKUP
     */
    @Test
    public void Test6() throws Exception {
        String path = "data/hash_maps/valid_map.txt";

        // Keys that exist
        Assert.assertEquals("Should find 'name'",
                "Alice", Solutions.task6(path, "name"));
        Assert.assertEquals("Should find 'age'",
                "30", Solutions.task6(path, "age"));
        Assert.assertEquals("Should find 'student_id'",
                "12345", Solutions.task6(path, "student_id"));

        // Key that does NOT exist
        Assert.assertNull("Should return null for missing key",
                Solutions.task6(path, "email"));
    }

    /**
     * TASK 7: FIND DUPLICATE VALUES
     */
    @Test
    public void Test7() throws Exception {
        // valid_map.txt has all unique values — no duplicates expected
        Map<String, List<String>> dupes =
                Solutions.task7("data/hash_maps/valid_map.txt");
        Assert.assertTrue("No duplicate values in valid_map.txt",
                dupes.isEmpty());
    }


    /**
     * Task 8: Max Value in a given array
     */
    @Test
    public void Test8() {
        int[] test = new int[10];

        for(int i = 0; i < 10; i++){
            if(i % 3 == 0){
                test[i] = i * 10;
            }else{
                test[i] = i * 2;
            }
        }

        var t = Main.task8(test);
        Assert.assertEquals(t, 90);


    }

    /**
     * Task 9: Palindrome Check function
     */
    @Test
    public void Test9() {
        Assert.assertTrue(Main.task9("racecar"));


    }

    /**
     * Task 10: Reversing array order
     */
    @Test
    public void Test10() {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] accepted = new int[]{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        Main.task10(test);
        for(int i = 0; i < test.length; i++) {
            Assert.assertEquals(test[i], accepted[i]);
        }
    }
}