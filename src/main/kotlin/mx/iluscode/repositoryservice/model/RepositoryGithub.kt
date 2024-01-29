package mx.iluscode.repositoryservice.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter

class RepositoryGithub {

    @JsonProperty("name")
    var name: String = ""

    @JsonProperty("clone_url")
    var cloneUrl: String = ""

}