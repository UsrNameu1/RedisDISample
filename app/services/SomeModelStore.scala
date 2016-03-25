package services

import domains.SomeModel

import scala.concurrent.Future


trait SomeModelStore {

  def findById(identifier: String): Future[Option[SomeModel]]

}
