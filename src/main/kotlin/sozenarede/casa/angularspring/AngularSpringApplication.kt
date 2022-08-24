package sozenarede.casa.angularspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.security.Principal
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
  @PostMapping("/user")
  fun user(user: Principal?): Principal? {
    return user
  }

  @Configuration
  @Order(SecurityProperties.IGNORED_ORDER)
  protected class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
      http
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/index.html", "/", "/home", "/login", "/user").permitAll()
        .anyRequest().authenticated()
    }
  }

}

fun main(args: Array<String>) {
	runApplication<AngularSpringApplication>(*args)
}
