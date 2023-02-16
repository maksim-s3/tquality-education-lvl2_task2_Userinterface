package dbutils.models;

public enum ResultStatuses {
    PASSED("PASSED"),
    FAILED("FAILED"),
    SKIPPED("SKIPPED");

    private final String title;

    ResultStatuses(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
