@file:Suppress("CAST_NEVER_SUCCEEDS")

package mx.iluscode.repositoryservice.services

import com.fasterxml.jackson.databind.ObjectMapper
import mx.iluscode.repositoryservice.model.RepositoryGithub
import mx.iluscode.repositoryservice.utils.Constants.Companion.AUTHORIZATION
import mx.iluscode.repositoryservice.utils.Constants.Companion.BEARER
import mx.iluscode.repositoryservice.utils.Constants.Companion.HTML_URL
import mx.iluscode.repositoryservice.utils.Constants.Companion.NAME
import mx.iluscode.repositoryservice.utils.Constants.Companion.PUSHED_AT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object


@Service
class GithubService : IGithubService {

    @Value("\${github.token}")
    var tokenGithub: String = ""

    @Value("\${url.github_repo}")
    var githubRepoUrl: String = ""

    @Value("\${service.github_repo}")
    var githubRepoService: String = ""

    @Autowired
    private lateinit var webClient: WebClient

    override fun getRepositories(): Mono<List<RepositoryGithub>> {
        val url = githubRepoUrl.plus(githubRepoService)
        val om = ObjectMapper()
        return webClient.get()
            .uri(url)
            .header(AUTHORIZATION, BEARER.plus(tokenGithub))
            .retrieve()
            .bodyToMono(String::class.java)
            .map { om.readValue(it, ArrayList<HashMap<String, Object>>().javaClass) }
            .map { it ->
                val lRepo: List<RepositoryGithub> = ArrayList()
                it.forEach {
                    val rg = RepositoryGithub()
                    rg.name = it[NAME] as String
                    rg.url = it[HTML_URL] as String
                    val pushedAt = it[PUSHED_AT] as String
                    val zdt = ZonedDateTime.parse(pushedAt)
                    val fDate = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    rg.lastDatePush = zdt.format(fDate).toString()
                    lRepo.addLast(rg)
                }
                return@map lRepo
            }
    }
}