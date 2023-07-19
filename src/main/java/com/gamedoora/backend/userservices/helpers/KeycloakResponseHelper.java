package com.gamedoora.backend.userservices.helpers;

import com.gamedoora.backend.userservices.exceptions.UserCreationException;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Component
public class KeycloakResponseHelper {
    private ArrayList<Integer> successStatus = new ArrayList<>(){{
        add(201);
        add(204);
    }};
    public String getUserIdFromResposne(Response keycloakResponse){
        checkStatus(keycloakResponse);
        return CreatedResponseUtil.getCreatedId(keycloakResponse);
    }

     void checkStatus(Response keycloakResponse) {
        if(!successStatus.contains(keycloakResponse.getStatus())){
            throw new UserCreationException(keycloakResponse.getStatusInfo().getReasonPhrase());
        }
    }
}
