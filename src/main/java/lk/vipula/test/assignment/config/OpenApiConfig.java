package lk.vipula.test.assignment.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Vipula",
                        email = "vipulana17@gmail.com",
                        url = "https://www.linkedin.com/in/vipula-ariyarathna-a1b905203/"
                ),
                description = """
                        doc - App with jwt auth. and two entities for assignment
                               -> 01. Create a account from register
                               -> 02. Give username and password to authenticate
                               -> 03. Use it by authorizing to use User controller""",
                title = "OpenAPi Spec - Vipula",
                version = "1.0"
        ),
        servers =  {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8081"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
