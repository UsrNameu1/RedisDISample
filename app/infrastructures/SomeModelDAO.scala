package infrastructures

import javax.inject.{Named, Inject}

import com.redis.RedisClientPool
import domains.SomeModel
import play.api.libs.json.Json
import services.SomeModelStore

import scala.concurrent.Future

import play.api.libs.concurrent.Execution.Implicits.defaultContext

class SomeModelDAO @Inject()(@Named("some_model") pool: RedisClientPool) extends SomeModelStore {

  import CacheJsonConverters._

  override def findById(identifier: String): Future[Option[SomeModel]] = Future {
    pool.withClient { client =>
      val maybeJson = client.get(identifier) map Json.parse
      maybeJson map { Json.fromJson(_).get }
    }
  }

}


