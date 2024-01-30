package mx.iluscode.repositoryservice.model

import com.fasterxml.jackson.annotation.JsonProperty

class RepositoryGithub {

    @JsonProperty("name")
    var name: String = ""

    @JsonProperty("url")
    var url: String = ""

    @JsonProperty("last_date_push")
    var lastDatePush: String = ""

}