package services

import com.google.inject.Inject
import domains.SomeModel

import scala.concurrent.Future


class FindSomeModelService @Inject()(store: SomeModelStore) {

  def findById(identifier: String): Future[Option[SomeModel]] =
    store.findById(identifier)

}
