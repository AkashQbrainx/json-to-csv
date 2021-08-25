package config
import com.typesafe.config.{Config, ConfigFactory}
object AppConfig {
val config:Config=ConfigFactory.load().getConfig("json-to-csv")

}
