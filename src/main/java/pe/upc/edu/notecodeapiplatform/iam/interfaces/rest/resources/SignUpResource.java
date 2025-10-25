package pe.upc.edu.notecodeapiplatform.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String username, String password, List<String> roles, String email) {
}
