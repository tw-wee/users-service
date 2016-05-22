package tw.wee.user.enumeration;

public enum RoleType {
    ADMIN("A"), COMMON("C");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RoleType getRole(String value) {
        if (ADMIN.value.equals(value)) {
            return ADMIN;
        } else return COMMON;
    }
}
