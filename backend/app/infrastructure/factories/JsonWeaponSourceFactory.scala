package infrastructure.factories

import domain.factories.SourceFactory
import scala.io.Source
import scala.io.Codec

/**
 * ブキのJSONデータソースのファクトリー
 */
class JsonWeaponSourceFactory () extends SourceFactory {
  /**
   * データソースを生成する
   * @return データソース
   */
  def createSource: Source = {
    implicit val codec = Codec("UTF-8")
    Source.fromResource("Weapons.json")
  }
}