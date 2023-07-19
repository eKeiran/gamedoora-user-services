package com.gamedoora.backend.userservices.helpers;

import com.gamedoora.backend.userservices.constants.KeycloakConstants;
import com.gamedoora.backend.userservices.mappers.UserRepresentationMapper;
import com.gamedoora.model.dto.UserDTO;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * The type User operations helper.
 */
@Component
public class UserOperationsHelper {
    /**
     * The Email actions.
     */
    HashMap<String, List<String>> emailActions = new HashMap<>() {{
        put(KeycloakConstants.VERIFY_EMAIL, List.of(KeycloakConstants.VERIFY_EMAIL));
        put(KeycloakConstants.CONFIGURE_TOTP, List.of(KeycloakConstants.CONFIGURE_TOTP));
        put(KeycloakConstants.TERMS_AND_CONDITIONS, List.of(KeycloakConstants.TERMS_AND_CONDITIONS));
        put(KeycloakConstants.UPDATE_PASSWORD, List.of(KeycloakConstants.UPDATE_PASSWORD));
        put(KeycloakConstants.UPDATE_PROFILE, List.of(KeycloakConstants.UPDATE_PROFILE));
    }};
    private UsersResource keyclockUsersResource;
    private UserRepresentationMapper userRepresentationMapper;
    private KeycloakResponseHelper keycloakResponseHelper;

    /**
     * Add user .
     *
     * @param userDto the user dto
     * @return the string
     */
    public String addUser(UserDTO userDto) {
        UserRepresentation userRepresentation = getUserRepresentationMapper()
                .toUserRespresentation(userDto);
        return getKeycloakResponseHelper()
                .getUserIdFromResposne(
                        getKeyclockUsersResource().create(userRepresentation)
                );
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    public void deleteUser(String userId) {
        getKeycloakResponseHelper().checkStatus(getKeyclockUsersResource().delete(userId));
    }

    /**
     * Send email.
     *
     * @param userId      the user id
     * @param emailAction the email action
     */
    public void sendEmail(String userId, String emailAction) {
        getKeyclockUsersResource().get(userId)
                .executeActionsEmail(emailActions.get(emailAction));
    }

    /**
     * Gets keyclock users resource.
     *
     * @return the keyclock users resource
     */
    public UsersResource getKeyclockUsersResource() {
        return keyclockUsersResource;
    }

    /**
     * Sets keyclock users resource.
     *
     * @param keyclockUsersResource the keyclock users resource
     */
    @Autowired
    public void setKeyclockUsersResource(UsersResource keyclockUsersResource) {
        this.keyclockUsersResource = keyclockUsersResource;
    }

    /**
     * Gets user representation mapper.
     *
     * @return the user representation mapper
     */
    public UserRepresentationMapper getUserRepresentationMapper() {
        return userRepresentationMapper;
    }

    /**
     * Sets user representation mapper.
     *
     * @param userRepresentationMapper the user representation mapper
     */
    @Autowired
    public void setUserRepresentationMapper(UserRepresentationMapper userRepresentationMapper) {
        this.userRepresentationMapper = userRepresentationMapper;
    }

    /**
     * Gets keycloak response helper.
     *
     * @return the keycloak response helper
     */
    public KeycloakResponseHelper getKeycloakResponseHelper() {
        return keycloakResponseHelper;
    }

    /**
     * Sets keycloak response helper.
     *
     * @param keycloakResponseHelper the keycloak response helper
     */
    @Autowired
    public void setKeycloakResponseHelper(KeycloakResponseHelper keycloakResponseHelper) {
        this.keycloakResponseHelper = keycloakResponseHelper;
    }
}
