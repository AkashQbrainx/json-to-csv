package config
import com.typesafe.config.ConfigFactory
object AppConfig {
val config=ConfigFactory.load().getConfig("json-to-csv")

}
