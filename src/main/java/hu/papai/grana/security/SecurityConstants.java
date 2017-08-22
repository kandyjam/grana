package hu.papai.grana.security;

class SecurityConstants {

    SecurityConstants() {
        throw new IllegalStateException("Utility class.");
    }

    static final String SECRET = "MyVerySecret";
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String JWT_AUTHORITIES_KEY = "authorities";
}
