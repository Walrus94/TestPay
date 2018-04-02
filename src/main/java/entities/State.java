package entities;

public enum State {
    CREATED("created"),
    APPROVED("approved"),
    FAILED("failed");

    private String stateName;

    State(String stateName) {
        this.stateName = stateName;
    }
}
