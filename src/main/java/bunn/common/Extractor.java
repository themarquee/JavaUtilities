package bunn.common;

/**
 * Interface for defining singleton classes used for retrieving aggregates within an Object.
 * 
 * @author kquon
 *
 * @param <V>
 * @param <O>
 */
public interface Extractor<V, O> {

	/**
	 * Extracts a given aggregate or sub-aggregate from within an object.
	 * @param object Nested Object
	 * @return aggregate
	 */
	V extract(O object);
	
}