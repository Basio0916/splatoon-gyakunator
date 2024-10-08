import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.should.Matchers

class WeaponCategorySpec extends AnyFlatSpec with TableDrivenPropertyChecks with Matchers {
    "WeaponCategory" should "override toString to display its class name" in {
        val examples = Table(
            ("WeaponCategory", "expectedResult"),
            (Shooter, "シューター"),
            (Roller, "ローラー"),
            (Charger, "チャージャー"),
            (Slosher, "スロッシャー"),
            (Blaster, "ブラスター"),
            (Splatling, "スピナー"),
            (Brella, "シェルター"),
            (Dualies, "マニューバー"),
            (Brush, "フデ"),
            (Stringers, "ストリンガー"),
            (Splatanas, "ワイパー")
        )
        forAll(examples) { (weaponCategory, expectedResult) =>
            weaponCategory.toString should equal(expectedResult)
        }
    }

    "apply" should "return WeaponCategory from a string" in {
        val examples = Table(
            ("value", "expectedResult"),
            ("シューター", Shooter),
            ("ローラー", Roller),
            ("チャージャー", Charger),
            ("スロッシャー", Slosher),
            ("ブラスター", Blaster),
            ("スピナー", Splatling),
            ("シェルター", Brella),
            ("マニューバー", Dualies),
            ("フデ", Brush),
            ("ストリンガー", Stringers),
            ("ワイパー", Splatanas)
        )
        forAll(examples) { (value, expectedResult) =>
            WeaponCategory(value) should equal(expectedResult)
        }
    }

    it should "throw IllegalArgumentException for invalid string" in {
        val examples = Table(
            "value",
            "invalid"
        )
        forAll(examples) { value =>
            an[IllegalArgumentException] should be thrownBy {
                WeaponCategory(value)
            }
        }
    }
}