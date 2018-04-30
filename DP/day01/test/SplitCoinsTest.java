package DP.day01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import DP.day01.src.SplitCoins;

public class SplitCoinsTest {

    /**
     * Test method for {@link SplitCoins#splitCoins(int[])}.
     */
    @Test
    public void testSplitCoins() throws FileNotFoundException {
        for(int i = 1; i <= 12; i++){
            Scanner input = new Scanner(new File(
                    "C:/Users/N4tticus/Eclipse Workspace/DSA-18/DP/day01/test/testcases/divgold." + i + ".in"));
            Scanner output = new Scanner(new File(
                    "C:/Users/N4tticus//Eclipse Workspace/DSA-18/DP/day01/test/testcases/divgold." + i + ".out"));

            int n = input.nextInt();
            int[] coins = new int[n];
            for(int j = 0; j < n; j++){
                coins[j] = input.nextInt();
            }

            assertEquals(output.nextInt(), SplitCoins.splitCoins(coins));

            input.close();
            output.close();
        }
    }
}
