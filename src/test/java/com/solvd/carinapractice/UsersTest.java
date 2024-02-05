package com.solvd.carinapractice;

import com.solvd.carinapractice.api.GetSingleUserMethod;
import com.solvd.carinapractice.model.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

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
}
