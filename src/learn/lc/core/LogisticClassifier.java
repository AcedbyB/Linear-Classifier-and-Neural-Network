package learn.lc.core;

import learn.math.util.VectorOps;

public class LogisticClassifier extends LinearClassifier {

    public LogisticClassifier(int ninputs) {
        super(ninputs);
    }

    /**
     * A LogisticClassifier uses the logistic update rule
     * (AIMA Eq. 18.8): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times h_w(x)(1-h_w(x)) \times x_i
     */
    public void update(double[] x, double y, double alpha) {
        double h = eval(x);
//        System.out.println("cak " + h);
        for (int i = 0; i < weights.length; i++) {
            weights[i] = weights[i] + alpha*(y - h)*x[i]*h*(1-h);
        }
    }

    /**
     * A LogisticClassifier uses a 0/1 sigmoid threshold at z=0.
     */
    public double threshold(double z) {
        double h = 1.0/(1.0 + Math.exp((-1.0)*z));
        return h;
    }

}
