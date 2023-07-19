package com.gamedoora.backend.userservices.mappers;


import com.gamedoora.model.dto.UserDTO;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRepresentationMapper {
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
     @Mapping(source = "password", target = "credentials", qualifiedByName = "getCredentialsRepresentation")
    UserRepresentation toUserRespresentation(UserDTO userDto);

    @Named("getCredentialsRepresentation")
   default List<CredentialRepresentation> getCredentialsRepresentation(String password){
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(password);
        return List.of(credentialRepresentation);
    }
}
