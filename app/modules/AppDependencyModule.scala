package modules

import com.google.inject.name.Named
import com.google.inject.{AbstractModule, Singleton, Provides}
import com.redis.RedisClientPool
import infrastructures.SomeModelDAO
import play.api.Configuration
import services.SomeModelStore


class AppDependencyModule extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[SomeModelStore]).to(classOf[SomeModelDAO])
  }

  @Provides
  @Singleton
  @Named("some_model")
  def provideStoreDetailRedisClientPool(
    configuration: Configuration
  ): RedisClientPool = new RedisClientPool(
    configuration.getString("redis.host").get,
    configuration.getInt("redis.port").get,
    database = 1
  )
}
