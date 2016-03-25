package controllers

import com.google.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{Controller, Action}
import services.FindSomeModelService

import play.api.libs.concurrent.Execution.Implicits.defaultContext

class SomeModelController @Inject()(findService: FindSomeModelService) extends Controller {

  import ResponseBodyConverters._

  def find(identifier: String) = Action.async {
     for {
       maybeModel <- findService.findById(identifier)
       result = maybeModel match {
         case None => NotFound
         case Some(model) => Ok(Json.toJson(model))
       }
     } yield result
  }
}


