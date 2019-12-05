package learn.nn.core;

/**
 * A PerceptronUnit is a Unit that uses a hard threshold
 * activation function.
 */
public class PerceptronUnit extends NeuronUnit {
	
	/**
	 * The activation function for a Perceptron is a hard 0/1 threshold
	 * at z=0. (AIMA Fig 18.7)
	 */
	@Override
	public double activation(double z) {
		if (z >= 0) return 1.0;
		else return 0.0;
	}
	
	/**
	 * Update this unit's weights using the Perceptron learning
	 * rule (AIMA Eq 18.7).
	 * Remember: If there are n input attributes in vector x,
	 * then there are n+1 weights including the bias weight w_0. 
	 */
	@Override
	public void update(double[] x, double y, double alpha) {
		double hw = h_w(x);
		this.incomingConnections.get(0).weight += alpha*(y-hw);
		for (int i = 0; i < this.incomingConnections.size()-1; i++){
			this.incomingConnections.get(i+1).weight += alpha*(y - hw)*x[i];
		}
	}
}
