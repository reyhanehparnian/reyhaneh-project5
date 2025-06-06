import java.util.*;

/**
 * Solves the Two Towers problem using subset enumeration.
 *
 * @author Reyhaneh Parnian
 * @version 1.0 Build 2025.04.19
 */
public class TwoTowers {

    /**
     * The number of blocks provided by the user.
     */
    public static int numBlocks = -1;

    /**
     * The optimal target height of one tower (half the total height).
     */
    public static double targetHeight = -1;

    /**
     * A space-separated string of block numbers that make up the best shorter tower.
     */
    public static String bestSubset = "";

    /**
     * The height of the best shorter tower found.
     */
    public static double bestHeight = -1;

    /**
     * The difference between the best height and the optimal target height.
     */
    public static double distanceFromOptimal = -1;

    /**
     * The total time taken to solve the problem, in milliseconds.
     */
    public static long duration = -1;

    /**
     * Solves the two towers problem for a given number of blocks.
     * Updates all public static variables and prints the results.
     *
     * @param numberOfBlocks The number of blocks (n), each with face area from 1 to n.
     */
    public static void solve(int numberOfBlocks) {
        numBlocks = numberOfBlocks;

        // Build a list of block heights
        List<Double> blockHeights = new ArrayList<>();
        for (int i = 1; i <= numberOfBlocks; i++) {
            blockHeights.add(Math.sqrt(i));
        }

        // Compute total height and target height
        double totalHeight = 0;
        for (double h : blockHeights) {
            totalHeight += h;
        }
        targetHeight = totalHeight / 2;

        SubsetIterator<Double> it = new SubsetIterator<>(blockHeights);

        long startTime = System.currentTimeMillis();

        double bestSoFar = 0;
        String bestSubsetStr = "";

        // Enumerate all subsets and track the closest one to targetHeight
        while (it.hasNext()) {
            List<Double> subset = it.next();
            double subsetHeight = 0;

            for (double h : subset) {
                subsetHeight += h;
            }

            if (subsetHeight <= targetHeight && subsetHeight > bestSoFar) {
                bestSoFar = subsetHeight;

                String subsetStr = "";
                for (double h : subset) {
                    int originalBlock = (int)Math.round(h * h);
                    subsetStr += originalBlock + " ";
                }
                bestSubsetStr = subsetStr.trim();
            }
        }

        long endTime = System.currentTimeMillis();
        duration = endTime - startTime;

        bestHeight = bestSoFar;
        bestSubset = bestSubsetStr;
        distanceFromOptimal = targetHeight - bestHeight;

        System.out.println("Target (optimal) height: " + targetHeight);
        System.out.println("Best subset: " + bestSubset);
        System.out.println("Best height: " + bestHeight);
        System.out.println("Distance from optimal: " + distanceFromOptimal);
        System.out.println("Solve duration: " + duration + " ms");
    }

    /**
     * Prompts the user for the number of blocks and runs the solver.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of blocks: ");
        int n = sc.nextInt();
        solve(n);
    }
}