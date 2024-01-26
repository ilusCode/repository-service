package mx.iluscode.repositoryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
@SpringBootApplication
class RepositoryServiceApplication

fun main(args: Array<String>) {
	runApplication<RepositoryServiceApplication>(*args)
}
