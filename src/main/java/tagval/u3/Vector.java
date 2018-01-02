package tagval.u3;

public interface Vector {
    /**
     *
     * @param i=0-x,1-y,2-z
     * @return xyz
     */
    double component(int i);

    /**
     *
     * @return length
     */
    double length();

    /**
     * sum vectors
     * @param other vector
     * @return result vector
     */
    Vector plus(Vector other);

    /**
     *
     * @return string xyz
     */
    @Override
    String toString();
}
