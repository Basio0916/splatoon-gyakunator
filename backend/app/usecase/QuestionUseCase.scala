package usecase

import javax.inject.{Inject, Singleton}
import domain.models._
import domain.models.questions._
import domain.repositories._
import domain.services.JwtService
import domain.services.BlackList
import domain.exceptions.InvalidTokenException

/**
 * 質問に対する答えを取得するユースケース
 * @param weaponRepository ブキリポジトリ
 * @param jwtService JWTサービス
 * @param blackList ブラックリスト
 */
@Singleton
class QuestionUseCase @Inject()(weaponRepository: WeaponRepository, jwtService: JwtService, blackList: BlackList) {
    /**
     * 質問に対する答えを取得する
     * @param jwt JWT
     * @param questionName 質問名
     * @param option オプション
     * @param comparator 比較
     * @return 答え
     */
    def run(jwt: String, questionName: String, option: Option[String], comparator: Option[String]): Answer = {

        if(blackList.contains(jwt)){
            throw new InvalidTokenException()
        }
        val weaponName = jwtService.decodeJwt(jwt);
        val answerWeapon = weaponRepository.findWeaponByName(weaponName).getOrElse(throw new IllegalArgumentException("Invalid token"))
        
        val question = Question(questionName, answerWeapon, option, comparator)
        question.answer
    }
}