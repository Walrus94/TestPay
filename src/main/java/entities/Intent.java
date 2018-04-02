package entities;

public enum Intent {
    ORDER("order");

    private String intentName;

    Intent(String intentName) {
        this.intentName = intentName;
    }
}
