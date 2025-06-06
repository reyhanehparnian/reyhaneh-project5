import java.util.*;

/**
 * A generic iterator that generates all possible subsets of a given list.
 * Each subset is represented as a List<T> and generated using binary counting.
 *
 * @param <T> The type of elements in the input list.
 * @author Reyhaneh Parnian
 * @version 1.0 Build 2025.04.19
 */
public class SubsetIterator<T> implements Iterator<List<T>> {

    /**
     * The original list to generate subsets from.
     */
    private List<T> originalList;

    /**
     * A long representing the current subset being generated (in binary).
     */
    private long currentSubset;

    /**
     * The total number of possible subsets (2^n).
     */
    private long maxSubset;

    /**
     * Constructs a new SubsetIterator for the given list.
     *
     * @param list The original list of elements to generate subsets from.
     */
    public SubsetIterator(List<T> list) {
        this.originalList = list;
        this.currentSubset = 0;
        this.maxSubset = 1L << list.size();
    }

    /**
     * Returns true if there are more subsets to generate.
     *
     * @return true if another subset exists, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return currentSubset < maxSubset;
    }

    /**
     * Returns the next subset in the sequence.
     *
     * @return A list representing the next subset of the original list.
     */
    @Override
    public List<T> next() {
        List<T> subset = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i++) {
            if ((currentSubset & (1L << i)) != 0) {
                subset.add(originalList.get(i));
            }
        }
        currentSubset++;
        return subset;
    }
}