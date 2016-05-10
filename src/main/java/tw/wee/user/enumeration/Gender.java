package tw.wee.user.enumeration;


public enum Gender {
    FEMALE("F"), MALE("M");


    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
