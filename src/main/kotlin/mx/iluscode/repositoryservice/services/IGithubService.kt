package mx.iluscode.repositoryservice.services

import mx.iluscode.repositoryservice.model.RepositoryGithub
import reactor.core.publisher.Mono

interface IGithubService {
    fun getRepositories(): Mono<List<RepositoryGithub>>
}