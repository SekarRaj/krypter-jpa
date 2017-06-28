# krypter-jpa
Krypter JPA Repository


import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class CoinChange {
    public static Map<Integer, Integer> totalWays = new HashMap<>();
    public static void numberOfWays(int[] denom, int amount) {
        Arrays.sort(denom);
        for (int i = 0; i <= denom.length; i++) {
            int curDenom = denom[i];

            if (amount < denom[i]) {
                return;
            }

            for (int j = 1; j <= amount; j++) {
                saveData(amount, curDenom, j);
            }
        }
    }

    public static saveData(int maxAmount, int denom, int amt){
        int tempAmount = amt;
        while(tempAmount >= denom){
            tempAmount -= denom;
        }

        if(totalWays.get(j) == null){
            totalWays.put(j, curDenom);
        }
    }

    public static void main(String... args) {
        int[] denominations = { 8, 3, 1, 2 };
        // int ways = numberOfWays(denominations, 3);
        // System.out.println(ways);
    }
}
