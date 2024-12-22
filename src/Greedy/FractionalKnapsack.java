package Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
	public int getMaximum(int A[], int B[], int C) {
		int n = A.length;
		 // Create KnapsackItems based on input arrays A and B
		KnapsackItem items[] = new KnapsackItem[A.length];
		for(int i=0; i<n; i++) {
			items[i] = new KnapsackItem(B[i], A[i]*1.0*100/B[i]);
		}
		 // Sort items array in descending order based on valuePerWeight using a lambda expression
		Arrays.sort(items,(a, b)->Double.compare(b.valuePerWeight, a.valuePerWeight));
		double value = 0;
		// Iterate through the sorted items array and add items to the knapsack until capacity C is reached
		for(int i=0; i<n && C>0; i++) {
			int min = Math.min(items[i].weight, C);
			value += items[i].valuePerWeight * min;
			C = C-min;
		}
		return (int)Math.floor(value);
	}

}

class KnapsackItem {
    int weight;
    double valuePerWeight;
    public KnapsackItem(int weight, double valuePerWeight) {
        this.weight = weight;
        this.valuePerWeight = valuePerWeight;
    }
}