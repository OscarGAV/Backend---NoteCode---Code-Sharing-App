package pe.upc.edu.notecodeapiplatform.iam.interfaces.rest.transform;

import pe.upc.edu.notecodeapiplatform.iam.domain.model.aggregates.User;
import pe.upc.edu.notecodeapiplatform.iam.domain.model.entities.Role;
import pe.upc.edu.notecodeapiplatform.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles, entity.getEmail());
    }
}
