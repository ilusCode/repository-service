package mx.iluscode.repositoryservice.services

import mx.iluscode.repositoryservice.enums.RepositoryProviderEnum
import mx.iluscode.repositoryservice.enums.RepositoryProviderEnum.GH
import mx.iluscode.repositoryservice.enums.RepositoryProviderEnum.GL
import mx.iluscode.repositoryservice.model.RepositoryGithub
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RepositoryProviderService(val gs: IGithubService) : IRepositoryProviderService {

    override fun getRepositoriesProvider(provider: RepositoryProviderEnum): Mono<List<RepositoryGithub>> {
        if (provider == GH) {
            return gs.getRepositories();
        } else if (provider == GL) {
            return Mono.empty();
        }
        return Mono.empty()
    }
}