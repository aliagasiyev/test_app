package az.edu.msregister.config;

import az.edu.msregister.enums.UserRole;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RoleBasedAccessConfig {

    private static final Map<UserRole, RolePermissions> rolePermissions = new HashMap<>();

    static {
        rolePermissions.put(UserRole.SUPER_ADMIN, new RolePermissions(
                Set.of(UserRole.STAFF),
                Set.of(UserRole.STAFF, UserRole.TEACHER, UserRole.STUDENT)
        ));

        rolePermissions.put(UserRole.STAFF, new RolePermissions(
                Set.of(UserRole.STUDENT, UserRole.TEACHER),
                Set.of(UserRole.STUDENT, UserRole.TEACHER)
        ));

        rolePermissions.put(UserRole.TEACHER, new RolePermissions(
                Collections.emptySet(),
                Collections.emptySet()
        ));

        rolePermissions.put(UserRole.STUDENT, new RolePermissions(
                Collections.emptySet(),
                Collections.emptySet()
        ));
    }

    public static RolePermissions getPermissions(UserRole role) {
        return rolePermissions.getOrDefault(role, new RolePermissions(Collections.emptySet(), Collections.emptySet()));
    }
}
