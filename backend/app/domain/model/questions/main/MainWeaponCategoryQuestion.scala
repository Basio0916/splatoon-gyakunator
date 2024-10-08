class MainWeaponCategoryQuestion(answerWeapon: Weapon, weaponCategory: WeaponCategory) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.category == weaponCategory) Yes
        else No
    }
}