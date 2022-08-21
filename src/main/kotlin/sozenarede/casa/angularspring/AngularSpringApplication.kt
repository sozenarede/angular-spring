package sozenarede.casa.angularspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*


@SpringBootApplication
@Controller
class AngularSpringApplication {
  @GetMapping("/resource")
  @ResponseBody
  fun home(): Map<String, Any>? {
    val model: MutableMap<String, Any> = HashMap()
    model["id"] = UUID.randomUUID().toString()
    model["content"] = "Hello World"
    return model
  }
}

fun main(args: Array<String>) {
	runApplication<AngularSpringApplication>(*args)
}
