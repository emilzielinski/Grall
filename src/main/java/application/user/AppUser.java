package application.user;


public class AppUser {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private String authority;

    public AppUser(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public AppUser(Integer id, String username, String email, boolean enabled, String authority) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
    }

    public AppUser(String username, String email, String password, boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;

    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getAuthority() {
        return authority;
    }
}
