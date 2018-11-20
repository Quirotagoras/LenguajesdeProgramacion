import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;


public class CumulativeProbability {

     NormalDistribution d;
     double prob=0;




     public CumulativeProbability(double mean,double sd, double x){
        try {
            d = new NormalDistribution(mean, sd);
            //System.out.println(d.cumulativeProbability(x));
            prob = d.cumulativeProbability(x);
        }catch (NotStrictlyPositiveException e){

        }

     }

    public double getProb(){
        return prob;
    }



}