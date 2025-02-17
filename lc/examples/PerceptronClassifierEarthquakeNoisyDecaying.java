package learn.lc.examples;

import java.io.IOException;

/**
 * Tests the PerceptronClassifier on the noisy earthquake data with a decaying
 * learning schedule.
 */
public class PerceptronClassifierEarthquakeNoisyDecaying extends PerceptronClassifierTest {

	public static void main(String[] args) throws IOException {
		test("src/learn/lc/examples/earthquake-noisy.data.txt", 100000, 0);
	}

}
