public class MinimumCostOfClothing {
    public static int findMinimumCost(int[][] price) {
        int N = price.length;
        if (N != 3) {
            throw new IllegalArgumentException("The number of people (N) must be 3.");
        }

        int minCost1 = price[0][0]; // Minimum cost if person 1 chooses clothing type 1
        int minCost2 = price[0][1]; // Minimum cost if person 1 chooses clothing type 2
        int minCost3 = price[0][2]; // Minimum cost if person 1 chooses clothing type 3

        // Calculate the minimum cost for each person while considering the previous choices
        for (int i = 1; i < N; i++) {
            int prevMinCost1 = minCost1; // Minimum cost for person i-1's choice of clothing type 1
            int prevMinCost2 = minCost2; // Minimum cost for person i-1's choice of clothing type 2
            int prevMinCost3 = minCost3; // Minimum cost for person i-1's choice of clothing type 3

            // Update the minimum cost for person i's choice of clothing type
            minCost1 = price[i][0] + Math.min(prevMinCost2, prevMinCost3); // Choose clothing type 1 for person i
            minCost2 = price[i][1] + Math.min(prevMinCost1, prevMinCost3); // Choose clothing type 2 for person i
            minCost3 = price[i][2] + Math.min(prevMinCost1, prevMinCost2); // Choose clothing type 3 for person i
        }

        // Return the minimum cost among all possible choices for the final person
        return Math.min(minCost1, Math.min(minCost2, minCost3));
    }

    public static void main(String[] args) {
        int[][] price = {
            {14, 4, 11},
            {11, 14, 3},
            {14, 2, 10}
        };
        int result = findMinimumCost(price);
        System.out.println("Minimum cost required: " + result); // Output: 9
    }
}
