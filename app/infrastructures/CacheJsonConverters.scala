package infrastructures

import domains.SomeModel
import play.api.libs.json.Json


object CacheJsonConverters {

  implicit val SomeModelReads = Json.reads[SomeModel]
}
