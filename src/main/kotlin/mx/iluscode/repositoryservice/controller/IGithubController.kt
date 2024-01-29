package mx.iluscode.repositoryservice.controller

import mx.iluscode.repositoryservice.enums.RepositoryProviderEnum
import mx.iluscode.repositoryservice.model.RepositoryGithub
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

interface IGithubController {
    fun getRepositories(provider: RepositoryProviderEnum): ResponseEntity<Mono<List<RepositoryGithub>>>

}