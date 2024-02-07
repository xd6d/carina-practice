package com.solvd.carinapractice.regres.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.base_url}/api/users/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get/get_single_user_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSingleUserMethod extends AbstractApiMethodV2 {
    public GetSingleUserMethod(long id) {
        replaceUrlPlaceholder("id", String.valueOf(id));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
