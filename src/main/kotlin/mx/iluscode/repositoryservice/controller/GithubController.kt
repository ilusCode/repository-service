package mx.iluscode.repositoryservice.controller

import jakarta.websocket.server.PathParam
import lombok.extern.slf4j.Slf4j
import mx.iluscode.repositoryservice.enums.RepositoryProviderEnum
import mx.iluscode.repositoryservice.model.RepositoryGithub
import mx.iluscode.repositoryservice.services.IRepositoryProviderService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@Slf4j
@RestController
@RequestMapping(path = ["/api"])
@CrossOrigin(origins = ["*"])
class GithubController(val rps: IRepositoryProviderService) : IGithubController {

    @GetMapping(path = ["/repositories"], produces = [APPLICATION_JSON_VALUE])
    override fun getRepositories(@PathParam(value = "provider") provider: RepositoryProviderEnum): ResponseEntity<Mono<List<RepositoryGithub>>> {
        return ResponseEntity.ok(rps.getRepositoriesProvider(provider))
    }
}