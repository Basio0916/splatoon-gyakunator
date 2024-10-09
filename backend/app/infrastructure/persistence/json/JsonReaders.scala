package infrastructure.persistence.json

import play.api.libs.json._
import play.api.libs.functional.syntax._
import domain.model._

object JsonReaders{
    implicit val weightReads: Reads[Weight] = Reads {
        case JsString(s) => JsSuccess(Weight(s))
        case _ => JsError("Could not read Weight")
    }

    implicit val weaponCategoryReads: Reads[WeaponCategory] = Reads {
        case JsString(s) => JsSuccess(WeaponCategory(s))
        case _ => JsError("Could not read WeaponCategory")
    }

    implicit val answerReads: Reads[Answer] = Reads {
        case JsString(s) => JsSuccess(Answer(s))
        case _ => JsError("Could not read Answer")
    }

    implicit val mainWeaponReads: Reads[MainWeapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "weaponCategory").read[WeaponCategory] and
        ((JsPath \ "range1").read[String] and (JsPath \ "range2").read[String]).tupled.map { case (r1, r2) => 
            List(r1, r2).flatMap(r => if (r.isEmpty) None else Some(r.toDouble))
        } and
        ((JsPath \ "damage1").read[String] and (JsPath \ "damage2").read[String] and (JsPath \ "damage3").read[String] and (JsPath \ "damage4").read[String]).tupled.map { case (d1, d2, d3, d4) => 
            List(d1, d2, d3, d4).flatMap(d => if (d.isEmpty) None else Some(d.toDouble))
        } and
        ((JsPath \ "firingInterval1").read[String] and (JsPath \ "firingInterval2").read[String]).tupled.map { case (fi1, fi2) => 
            List(fi1, fi2).flatMap(fi => if (fi.isEmpty) None else Some(fi.toDouble))
        } and
        ((JsPath \ "spread1").read[String] and (JsPath \ "spread2").read[String]).tupled.map { case (s1, s2) => 
            List(s1, s2).flatMap(s => if (s.isEmpty) None else Some(s.toDouble))
        } and
        (JsPath \ "weight").read[Weight] and
        (JsPath \ "canRapidFire").read[Answer] and
        (JsPath \ "canCharge").read[Answer] and
        (JsPath \ "isExplosive").read[Answer] and
        (JsPath \ "canRollingOrBrushing").read[Answer] and
        (JsPath \ "canChargeKeep").read[Answer] and
        (JsPath \ "dodgeRollCount").read[String].map(ic => ic.toInt) and
        (JsPath \ "hasDirectHitSound").read[Answer]
    )(MainWeapon.apply _)

    implicit val subWeaponReads: Reads[SubWeapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "inkConsumption").read[String].map(ic => ic.toInt) and
        ((JsPath \ "damage1").read[String] and (JsPath \ "damage2").read[String] and (JsPath \ "damage3").read[String]).tupled.map { case (d1, d2, d3) => 
            List(d1, d2, d3).flatMap(d => if (d.isEmpty) None else Some(d.toDouble))
        } and
        (JsPath \ "isAttackType").read[Answer] and
        (JsPath \ "canBePlaced").read[Answer] and
        (JsPath \ "canInk").read[Answer] and
        (JsPath \ "canMark").read[Answer]
    )(SubWeapon.apply _)

    implicit val specialWeaponReads: Reads[SpecialWeapon] = (
        (JsPath \ "name").read[String] and
        (JsPath \ "hasZRButtonAction").read[Answer] and
        (JsPath \ "hasRButtonAction").read[Answer] and
        (JsPath \ "canOneShot").read[Answer] and
        (JsPath \ "dealsContinuousDamage").read[Answer] and
        (JsPath \ "isAttackType").read[Answer] and
        (JsPath \ "jumpsToUsePoint").read[Answer]
    )(SpecialWeapon.apply _)
}