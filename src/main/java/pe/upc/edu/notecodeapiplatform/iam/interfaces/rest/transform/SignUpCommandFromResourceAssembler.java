package pe.upc.edu.notecodeapiplatform.iam.interfaces.rest.transform;

import pe.upc.edu.notecodeapiplatform.iam.domain.model.commands.SignUpCommand;
import pe.upc.edu.notecodeapiplatform.iam.domain.model.entities.Role;
import pe.upc.edu.notecodeapiplatform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() !=null
                ? resource.roles().stream().map(Role::toRoleFromName).toList()
                : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles, resource.email());
    }
}
