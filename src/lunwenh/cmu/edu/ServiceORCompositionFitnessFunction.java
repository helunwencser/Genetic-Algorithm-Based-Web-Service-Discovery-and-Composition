package lunwenh.cmu.edu;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/** 
 * This class defines the fitness function which will be used in this project.
 * This fitness function should be used for work flow which uses OR control operator.
 * For example, service a, b, and c compose in a parallel way: 
 * 			 -> a ->
 * 		input-> b ->
 * 			 -> c ->
 * In this kind of work flow, the maximum fitness value of a, b, c will be
 * chosen as the fitness value for the work flow.
 * */
public class ServiceORCompositionFitnessFunction extends FitnessFunction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2931106854238251965L;
	
	private Services services = new Services("services");
	
	@Override
	protected double evaluate(IChromosome chromeosome) {
		// TODO Auto-generated method stub
		Integer index1 = (Integer)chromeosome.getGene(0).getAllele();
		Integer index2 = (Integer)chromeosome.getGene(1).getAllele();
		Integer index3 = (Integer)chromeosome.getGene(2).getAllele();
		return Math.max(
				services.getCluster1().get(index1).getQualityValue(),
				Math.max(
						services.getCluster2().get(index2).getQualityValue(),
						services.getCluster3().get(index3).getQualityValue()
						)
				);
	}
}
