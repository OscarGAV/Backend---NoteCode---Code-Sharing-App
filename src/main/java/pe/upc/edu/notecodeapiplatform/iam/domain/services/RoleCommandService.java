package pe.upc.edu.notecodeapiplatform.iam.domain.services;

import pe.upc.edu.notecodeapiplatform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
