package domain.factories

import scala.io.Source

/**
 * データソースのファクトリー
 */
trait SourceFactory {
  /**
   * データソースを生成する
   * @return データソース
   */
  def createSource: Source
}
