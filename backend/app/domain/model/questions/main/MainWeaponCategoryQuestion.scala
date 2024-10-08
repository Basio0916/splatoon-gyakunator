class MainWeaponCategoryQuestion(answerWeapon: Weapon, weaponCategory: WeaponCategory) extends Question {
    override def answer: Answer = {
        if (answerWeapon.mainWeapon.weaponCategory == weaponCategory) Yes
        else No
    }
}