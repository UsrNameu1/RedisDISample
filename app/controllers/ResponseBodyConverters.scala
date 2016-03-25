package controllers

import domains.SomeModel
import play.api.libs.json.Json


object ResponseBodyConverters {

  implicit val SomeModelWrites = Json.writes[SomeModel]
}
