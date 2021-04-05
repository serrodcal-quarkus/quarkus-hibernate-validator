package com.serrodcal.resource;

import com.serrodcal.resource.payload.CreateUserRequest;
import com.serrodcal.service.UserService;
import com.serrodcal.service.dto.UserDTO;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;

@Singleton
public class UserResource {

    @Inject
    UserService userService;

    @Route(path = "/user", methods = HttpMethod.POST, consumes = "application/json", produces = "application/json")
    public void create(RoutingContext rc, @Body @Valid CreateUserRequest createUserRequest) {
        UserDTO userDTO = mapCreateUserRequestToUserDTO(createUserRequest);
        this.userService.create(userDTO).subscribe().with(
                result -> rc.response().setStatusCode(HttpResponseStatus.CREATED.code()).end(Json.encode(result)),
                failure -> rc.response()
                        .setStatusCode(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
                        .putHeader("Content-Type", "text/plain")
                        .end(failure.getMessage())
        );
    }

    private UserDTO mapCreateUserRequestToUserDTO(CreateUserRequest createUserRequest) {
        return new UserDTO(
                createUserRequest.getEmail(),
                createUserRequest.getUsername(),
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.isAdmin(),
                createUserRequest.getHashedPassword());
    }

}