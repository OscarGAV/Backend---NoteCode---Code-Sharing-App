package pe.upc.edu.notecodeapiplatform.iam.domain.services;

import pe.upc.edu.notecodeapiplatform.iam.domain.model.entities.Role;
import pe.upc.edu.notecodeapiplatform.iam.domain.model.queries.GetAllRolesQuery;
import pe.upc.edu.notecodeapiplatform.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
