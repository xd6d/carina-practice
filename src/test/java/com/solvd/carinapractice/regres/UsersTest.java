package com.solvd.carinapractice.regres;

import com.solvd.carinapractice.regres.api.*;
import com.solvd.carinapractice.regres.model.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;

public class UsersTest {

    @Test
    void getSingleUserByExistId() {
        User user = User.builder()
                .id(3)
                .firstName("Emma")
                .lastName("Wong")
                .email("emma.wong@reqres.in")
                .build();

        GetSingleUserMethod getSingleUserMethod = new GetSingleUserMethod(user.getId());
        getSingleUserMethod.addProperty("user", user);

        getSingleUserMethod.callAPIExpectSuccess();
        getSingleUserMethod.validateResponse();
    }

    @Test
    void getSingleUserByNotExistId() {
        GetSingleUserMethod getSingleUserMethod = new GetSingleUserMethod(13);
        getSingleUserMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getSingleUserMethod.callAPI();
    }

    @Test
    void createUser() {
        User user = getDefaultUser();

        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.addProperty("user", user);
        postUserMethod.callAPIExpectSuccess();

        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", s -> isCurrentDateTime(ZonedDateTime.parse(s)));
        postUserMethod.validateResponse(jsonComparatorContext);
    }

    @Test
    void putUserUpdate() {
        User user = getDefaultUser();

        PutUserMethod putUserMethod = new PutUserMethod(15);
        putUserMethod.addProperty("user", user);
        putUserMethod.callAPIExpectSuccess();

        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", s -> isCurrentDateTime(ZonedDateTime.parse(s)));
        putUserMethod.validateResponse(jsonComparatorContext);
    }

    @Test
    void patchUserUpdate() {
        User user = getDefaultUser();

        PatchUserMethod patchUserMethod = new PatchUserMethod(15);
        patchUserMethod.addProperty("user", user);
        patchUserMethod.callAPIExpectSuccess();

        JsonComparatorContext jsonComparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", s -> isCurrentDateTime(ZonedDateTime.parse(s)));
        patchUserMethod.validateResponse(jsonComparatorContext);
    }

    @Test
    void deleteUser() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(1);
        Response response = deleteUserMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.body().asString(), "");
    }

    private User getDefaultUser() {
        return User.builder()
                .firstName("John")
                .lastName("Black")
                .email("jblack@mail.com")
                .build();
    }

    private boolean isCurrentDateTime(ZonedDateTime dateTime) {
        return dateTime.toInstant().isBefore(ZonedDateTime.now().plusMinutes(1).toInstant())
                && dateTime.toInstant().isAfter(ZonedDateTime.now().minusMinutes(1).toInstant());
    }
}
