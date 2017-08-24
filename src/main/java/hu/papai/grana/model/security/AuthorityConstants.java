package hu.papai.grana.model.security;

public final class AuthorityConstants {

    private AuthorityConstants() { throw new IllegalStateException("Utility class."); }

    public static final String ROLE_OPERATOR = "ROLE_OPERATOR";
    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
}
