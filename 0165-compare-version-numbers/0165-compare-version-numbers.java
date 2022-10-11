import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int compareVersion(String version1, String version2) {

        Queue<Integer> v1Revisions = new LinkedList<>();
        Queue<Integer> v2Revisions = new LinkedList<>();

        for (String rev : version1.split("\\.", 0)) {
            v1Revisions.add(Integer.parseInt(rev));
        }

        for (String rev : version2.split("\\.", 0)) {
            v2Revisions.add(Integer.parseInt(rev));
        }

        while (v1Revisions.peek() != null && v2Revisions.peek() != null) {
            
            int diff = v1Revisions.poll() - v2Revisions.poll();

            if (diff == 0) continue;

            if (diff > 0) return 1;
            else return -1;
        }

        if (v1Revisions.peek() != null) {
            while (v1Revisions.peek() != null) {
                if (v1Revisions.poll() != 0) return 1;
            }
        }

        if (v2Revisions.peek() != null) {
            while (v2Revisions.peek() != null) {
                if (v2Revisions.poll() != 0) return -1;
            }
        }

        return 0; 
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(
            o.compareVersion("1.0", "1.00.0")
        );
    }
}