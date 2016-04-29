package lunwenh.cmu.edu;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 * This is the configuration object for JGAP.
 * In this configuration object, services are
 * composed in a linear way and use AND work
 * flow operator.
 * */
public class ServiceComposition {
	
	/**
	 * Set the work flow operator here. Possible values
	 * are: AND, OR
	 * */
	private static String OPERATOR = "OR";
	
	/* The upper bound for each gene */
	private static int ONE = 4;
	private static int TWO = 2;
	private static int THREE = 7;
	
	private static int MAX_ALLOWED_EVOLUTIONS = 1000;
	
	public static void main(String[] args) throws InvalidConfigurationException {
		
		Configuration conf = new DefaultConfiguration();
		
		FitnessFunction fitnessFunction;
		if(OPERATOR.equals("AND")) {
			fitnessFunction = new ServiceANDCompositionFitnessFunction();
		} else {
			fitnessFunction = new ServiceORCompositionFitnessFunction();
		}
		
		conf.setFitnessFunction(fitnessFunction);
		
		Gene[] genes = new Gene[3];
		genes[0] = new IntegerGene(conf, 0, ONE);
		genes[1] = new IntegerGene(conf, 0, TWO);
		genes[2] = new IntegerGene(conf, 0, THREE);
		
		Chromosome sampleChromosome = new Chromosome(conf, genes);
		conf.setSampleChromosome(sampleChromosome);
		
		/* The total number of combination is 120 */
		conf.setPopulationSize(100);
		
		Genotype population = Genotype.randomInitialGenotype(conf);
		
		for( int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++ ) {
		    population.evolve();
		}
		
		IChromosome solution = population.getFittestChromosome();
		
		System.out.println("The result with operator: " + OPERATOR);
		System.out.println("Service cluster 1: " + ((Integer)solution.getGene(0).getAllele() + 1));
		System.out.println("Service cluster 2: " + ((Integer)solution.getGene(1).getAllele() + 1));
		System.out.println("Service cluster 3: " + ((Integer)solution.getGene(2).getAllele() + 1));
	}
}
