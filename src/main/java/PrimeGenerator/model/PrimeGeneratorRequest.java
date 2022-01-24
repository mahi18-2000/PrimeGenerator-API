//This class defines the Object type of the request which we will get from our users.

package PrimeGenerator.model;

public class PrimeGeneratorRequest {
    private final String userId;
    private final int rangeStart;
    private final int rangeEnd;
    private final Algorithm algorithm;

    public PrimeGeneratorRequest(String userId, int rangeStart, int rangeEnd, Algorithm algorithm) {
        this.userId = userId;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.algorithm = algorithm;
    }


    public String getUserId() {
        return this.userId;
    }

    public int getRangeStart() {
        return this.rangeStart;
    }

    public int getRangeEnd() {
        return this.rangeEnd;
    }

    public Algorithm getAlgorithm(){
        return this.algorithm;
    }
}
