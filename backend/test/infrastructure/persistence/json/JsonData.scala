package infrastructure.persistence.json

object JsonData{
    val weapons = """
        [
            {
                "name": "わかばシューター",
                "mainWeapon": "わかばシューター",
                "subWeapon": "スプラッシュボム",
                "specialWeapon": "グレートバリア",
                "specialPoint": "180"
            }
        ]
    """

    val mainWeapons = """
        [
            {
                "name": "わかばシューター",
                "weaponCategory": "シューター",
                "range1": "1.6",
                "range2": "",
                "damage1": "28.0",
                "damage2": "",
                "damage3": "",
                "damage4": "",
                "firingInterval1": "5.0",
                "firingInterval2": "",
                "spread1": "12.0",
                "spread2": "",
                "weight": "軽量級",
                "canRapidFire": "YES",
                "canCharge": "NO",
                "isExplosive": "NO",
                "canRollingOrBrushing": "NO",
                "canChargeKeep": "NO",
                "dodgeRollCount": "0",
                "hasDirectHitSound": "NO"
            }
        ]
    """

    val subWeapons = """
        [
            {
                "name": "スプラッシュボム",
                "inkConsumption": "70",
                "damage1": "180.0",
                "damage2": "30.0",
                "damage3": "",
                "isAttackType": "YES",
                "canBePlaced": "NO",
                "canInk": "YES",
                "canMark": "NO"
            }
        ]
    """

    val specialWeapons = """
        [
            {
                "name": "グレートバリア",
                "hasZRButtonAction": "NO",
                "hasRButtonAction": "NO",
                "canOneShot": "NO",
                "dealsContinuousDamage": "NO",
                "isAttackType": "NO",
                "jumpsToUsePoint": "YES"
            }
        ]
    """
}