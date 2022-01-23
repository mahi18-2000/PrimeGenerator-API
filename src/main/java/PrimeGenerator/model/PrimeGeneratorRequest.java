package PrimeGenerator.model;

public class PrimeGeneratorRequest {
    private final String userID;
    private final int rangeStart;
    private final int rangeEnd;
    private final Algorithm algorithm;

    public PrimeGeneratorRequest(String userID, int rangeStart, int rangeEnd, Algorithm algorithm) {
        this.userID = userID;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.algorithm = algorithm;
    }


    public String getUserID() {
        return this.userID;
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
