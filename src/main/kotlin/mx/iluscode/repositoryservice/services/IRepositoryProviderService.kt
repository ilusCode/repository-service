package mx.iluscode.repositoryservice.services

import mx.iluscode.repositoryservice.enums.RepositoryProviderEnum
import mx.iluscode.repositoryservice.model.RepositoryGithub
import reactor.core.publisher.Mono

interface IRepositoryProviderService {

    fun getRepositoriesProvider(provider: RepositoryProviderEnum): Mono<List<RepositoryGithub>>
}