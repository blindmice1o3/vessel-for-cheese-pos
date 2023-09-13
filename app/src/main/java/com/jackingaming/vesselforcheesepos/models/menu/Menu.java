package com.jackingaming.vesselforcheesepos.models.menu;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.extra_refresher_bases_options.ExtraRefresherBasesOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBasesOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesepos.models.menu.hierarchy.Category;
import com.jackingaming.vesselforcheesepos.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesepos.models.menu.hierarchy.Topic;
import com.jackingaming.vesselforcheesepos.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.AppleCrispOatmilkFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.CaffeVanillaFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.CaramelFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.CaramelRibbonCrunchFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.CoffeeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.EspressoFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.JavaChipFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.MochaCookieCrumbleFrappuccino;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.MochaFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.PumpkinSpiceFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.coffeebased.WhiteChocolateMochaFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.AppleCrispOatmilkCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.ChaiCremeFrappuccino;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.ChocolateCookieCrumbleCremeFrappuccino;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.DoubleChocolatyChipCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.MatchaCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.PumpkinSpiceCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.StrawberryCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.VanillaBeanCremeFrappuccinoBlendedCreme;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.blendedbeverages.cremebased.WhiteChocolateCremeFrappuccinoBlendedBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.ChocolateCreamColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.CinnamonCaramelCreamColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.OleatoGoldenFoamColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.PumpkinCreamColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.SaltedCaramelCreamColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.StarbucksColdBrewCoffee;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.StarbucksColdBrewCoffeeWithMilk;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.StarbucksReserveColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.coldbrews.VanillaSweetCreamColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees.IcedCoffee;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees.IcedCoffeeWithMilk;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.icedcoffees.IcedEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.nitrocoldbrews.CinnamonCaramelCreamNitroColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.nitrocoldbrews.NitroColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.cold.nitrocoldbrews.VanillaSweetCreamNitroColdBrew;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.CaffeMisto;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.CloverMalawiSableFarmsStarbucksReserve;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.CloverStarbucksReserveCostaRicaNaranjo;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.CloverStarbucksReserveVietnamDaLat;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedBlondeRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedBlondeRoastVerandaBlend;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedDarkRoastCaffeVerona;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedDarkRoastSumatra;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedDecafRoastDecafPikePlaceRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedDecafRoastDecafPikePlaceRoast2;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedMediumRoastPikePlaceRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.brewed.hot.FeaturedMediumRoastPikePlaceRoast2;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites.IcedFlatWhite;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites.IcedHoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedCaffeLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedCinnamonDolceLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedPumpkinSpiceLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedStarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.StarbucksReserveIcedHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.StarbucksReserveIcedLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmacchiatos.IcedAppleCrispOatmilkMacchiato;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmacchiatos.IcedCaramelMacchiato;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.IcedCaffeMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.IcedWhiteChocolateMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.StarbucksReserveIcedDarkChocolateMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedAppleCrispOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedBrownSugarOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedChocolateAlmondmilkShakenEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedShakenEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedToastedVanillaOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.OleatoIcedShakenEspressoWithOatmilkAndToffeenut;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.cappuccinos.Cappuccino;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.flatwhites.FlatWhite;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.flatwhites.HoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.CaffeLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.CinnamonDolceLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.OleatoCaffeLatteWithOatmilk;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.PumpkinSpiceLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksReserveHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksReserveLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.AppleCrispOatmilkMacchiato;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.CaramelMacchiato;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.EspressoMacchiato;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.mochas.CaffeMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.mochas.StarbucksReserveDarkChocolateMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.milk_based.hot.mochas.WhiteChocolateMocha;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.straight_shots.EspressoConPanna;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.straight_shots.ShotEspresso;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based.cold.icedamericano.IcedCaffeAmericano;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.espresso.water_based.hot.americanos.CaffeAmericano;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.BlendedStrawberryLemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.EvolutionFreshMightyWatermelon;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.EvolutionFreshOrange;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.EvolutionFreshOrganicDefenseUp;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.EvolutionFreshOrganicSuperFruitGreens;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.EvolutionFreshOrganicVitalBerry;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.Lemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.StarbucksBayaEnergyMangoGuava;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.StarbucksBayaEnergyRaspberryLime;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.juice.TreeTopAppleJuiceBox;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk.ColdMilk;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk.HorizonChocolateOrganicMilk;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk.HorizonOrganicLowfatMilkBox;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.milk.HorizonOrganicVanillaMilkBox;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.DragonDrinkStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.DragonDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.FrozenMangoDragonfruitLemonadeStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.FrozenStrawberryAcaiLemonadeStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.MangoDragonfruitLemonadeStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.MangoDragonfruitStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.ParadiseDrinkStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.ParadiseDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.PineapplePassionfruitLemonadeStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.PineapplePassionfruitStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.PinkDrinkStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.StrawberryAcaiLemonadeStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.refreshers.StrawberryAcaiStarbucksRefreshersBeverage;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.sparklingwater.GalvaninaSparklingWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.sparklingwater.GalvaninaSparklingWaterLime;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.sparklingwater.SpindriftGrapefruitSparklingWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.sparklingwater.SpindriftRaspberryLimeSparklingWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.water.DasaniBottledWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.water.EthosBottledWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.water.FilteredTapWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.cold.water.HawaiiVolcanicWater;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.hotchocolates.HotChocolate;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.hotchocolates.WhiteHotChocolate;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.juice.CaramelAppleSpice;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.juice.SteamedAppleJuice;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.steamers.PumpkinSpiceCreme;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.steamers.SteamedMilk;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.other.hot.steamers.VanillaCreme;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.bottledteas.TeavanaMangoBlackTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.bottledteas.TeavanaSparklingUnsweetenedPeachNectarineGreenTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedblackteas.IcedBlackTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedblackteas.IcedBlackTeaLemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedblackteas.IcedLondonFogTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedblackteas.IcedRoyalEnglishBreakfastTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedchaiteas.IcedChaiTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedchaiteas.IcedChaiTeaLatteWithOleatoGoldenFoam;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedchaiteas.IcedPumpkinCreamChaiTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedGreenTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedGreenTeaLemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedMatchaLemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedMatchaTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedMatchaTeaLatteWithOleatoGoldenFoam;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedPeachGreenTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedgreenteas.IcedPeachGreenTeaLemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedherbalteas.IcedPassionTangoTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.cold.icedherbalteas.IcedPassionTangoTeaLemonade;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.blackteas.EarlGreyTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.blackteas.RoyalEnglishBreakfastTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.blackteas.RoyalEnglishBreakfastTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.blackteas.TeavanaLondonFogTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.chaiteas.ChaiTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.chaiteas.ChaiTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.greenteas.EmperorsCloudsAndMist;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.greenteas.HoneyCitrusMintTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.greenteas.JadeCitrusMintBrewedTea;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.greenteas.MatchaTeaLatte;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.herbalteas.MintMajesty;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.teas.hot.herbalteas.PeachTranquility;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.travelers.TravelerDarkRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.travelers.TravelerDecafPikePlaceRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.travelers.TravelerPikePlaceRoast;
import com.jackingaming.vesselforcheesepos.models.menu_items.drinks.travelers.TravelerVerandaBlend;

import java.util.Arrays;
import java.util.List;

public class Menu {
    public static final String TAG = Menu.class.getSimpleName();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final List<String> DRINK_COMPONENTS_KEYS = Arrays.asList(
            LemonadeOptions.TAG,
            ExtraRefresherBasesOptions.TAG,
            PreparationOptions.TAG,
            MilkOptions.TAG,
            EspressoOptions.TAG,
            BlendedOptions.TAG,
            RefresherBasesOptions.TAG,
            TeaOptions.TAG,
            JuiceOptions.TAG,
            SweetenerOptions.TAG,
            FlavorOptions.TAG,
            ToppingOptions.TAG,
            AddInsOptions.TAG,
            CupOptions.TAG
    );

    public static final List<String> DRINK_SIZE_CHANGED_KEYS = Arrays.asList(
            AddInsOptions.TAG,
            BlendedOptions.TAG,
            EspressoOptions.TAG,
            TeaOptions.TAG,
            SweetenerOptions.TAG,
            FlavorOptions.TAG
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_COFFEES = "Hot Coffees";
    public static final String AMERICANOS = "Americanos";
    public static final String BREWED_COFFEES = "Brewed Coffees";
    public static final String CAPPUCCINOS = "Cappuccinos";
    public static final String ESPRESSO_SHOTS = "Espresso Shots";
    public static final String FLAT_WHITES = "Flat Whites";
    public static final String LATTES = "Lattes";
    public static final String MACCHIATOS = "Macchiatos";
    public static final String MOCHAS = "Mochas";
    public static final String COFFEE_TRAVELERS = "Coffee Travelers";

    public static final List<MenuItem> americanos = Arrays.asList(
            new CaffeAmericano()
    );

    public static final List<MenuItem> brewedCoffees = Arrays.asList(
            new FeaturedBlondeRoast(),
            new FeaturedMediumRoastPikePlaceRoast(),
            new FeaturedDarkRoastSumatra(),
            new FeaturedDecafRoastDecafPikePlaceRoast(),
            new FeaturedBlondeRoastVerandaBlend(),
            new FeaturedMediumRoastPikePlaceRoast2(),
            new FeaturedDarkRoastCaffeVerona(),
            new FeaturedDecafRoastDecafPikePlaceRoast2(),
            new CaffeMisto(),
            new CloverStarbucksReserveCostaRicaNaranjo(),
            new CloverMalawiSableFarmsStarbucksReserve(),
            new CloverStarbucksReserveVietnamDaLat()
    );

    public static final List<MenuItem> cappuccinos = Arrays.asList(
            new Cappuccino()
    );

    public static final List<MenuItem> espressoShots = Arrays.asList(
            new ShotEspresso(),
            new EspressoConPanna()
    );

    public static final List<MenuItem> flatWhites = Arrays.asList(
            new FlatWhite(),
            new HoneyAlmondmilkFlatWhite()
    );

    public static final List<MenuItem> lattes = Arrays.asList(
            new PumpkinSpiceLatte(),
            new OleatoCaffeLatteWithOatmilk(),
            new CaffeLatte(),
            new CinnamonDolceLatte(),
            new StarbucksReserveLatte(),
            new StarbucksReserveHazelnutBiancoLatte(),
            new StarbucksBlondeVanillaLatte()
    );

    public static final List<MenuItem> macchiatos = Arrays.asList(
            new AppleCrispOatmilkMacchiato(),
            new CaramelMacchiato(),
            new EspressoMacchiato()
    );
    public static final List<MenuItem> mochas = Arrays.asList(
            new CaffeMocha(),
            new WhiteChocolateMocha(),
            new StarbucksReserveDarkChocolateMocha()
    );

    public static final List<MenuItem> coffeeTravelers = Arrays.asList(
            new TravelerVerandaBlend(),
            new TravelerDarkRoast(),
            new TravelerPikePlaceRoast(),
            new TravelerDecafPikePlaceRoast()
    );

    public static final List<Section> hotCoffees = Arrays.asList(
            new Section(AMERICANOS, R.drawable.harvest_moon_natsume, americanos),
            new Section(BREWED_COFFEES, R.drawable.harvest_moon_natsume, brewedCoffees),
            new Section(CAPPUCCINOS, R.drawable.harvest_moon_natsume, cappuccinos),
            new Section(ESPRESSO_SHOTS, R.drawable.harvest_moon_natsume, espressoShots),
            new Section(FLAT_WHITES, R.drawable.harvest_moon_natsume, flatWhites),
            new Section(LATTES, R.drawable.harvest_moon_natsume, lattes),
            new Section(MACCHIATOS, R.drawable.harvest_moon_natsume, macchiatos),
            new Section(MOCHAS, R.drawable.harvest_moon_natsume, mochas),
            new Section(COFFEE_TRAVELERS, R.drawable.harvest_moon_natsume, coffeeTravelers)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String COLD_COFFEES = "Cold Coffees";
    public static final String COLD_BREWS = "Cold Brews";
    public static final String NITRO_COLD_BREWS = "Nitro Cold Brews";
    public static final String ICED_AMERICANO = "Iced Americano";
    public static final String ICED_COFFEES = "Iced Coffees";
    public static final String ICED_SHAKEN_ESPRESSO = "Iced Shaken Espresso";
    public static final String ICED_FLAT_WHITES = "Iced Flat Whites";
    public static final String ICED_LATTES = "Iced Lattes";
    public static final String ICED_MACCHIATOS = "Iced Macchiatos";
    public static final String ICED_MOCHAS = "Iced Mochas";

    public static final List<MenuItem> coldBrews = Arrays.asList(
            new PumpkinCreamColdBrew(),
            new OleatoGoldenFoamColdBrew(),
            new CinnamonCaramelCreamColdBrew(),
            new ChocolateCreamColdBrew(),
            new SaltedCaramelCreamColdBrew(),
            new StarbucksReserveColdBrew(),
            new StarbucksColdBrewCoffee(),
            new VanillaSweetCreamColdBrew(),
            new StarbucksColdBrewCoffeeWithMilk()
    );

    public static final List<MenuItem> nitroColdBrews = Arrays.asList(
            new CinnamonCaramelCreamNitroColdBrew(),
            new NitroColdBrew(),
            new VanillaSweetCreamNitroColdBrew()
    );

    public static final List<MenuItem> icedAmericano = Arrays.asList(
            new IcedCaffeAmericano()
    );

    public static final List<MenuItem> icedCoffees = Arrays.asList(
            new IcedCoffee(),
            new IcedCoffeeWithMilk(),
            new IcedEspresso()
    );

    public static final List<MenuItem> icedShakenEspresso = Arrays.asList(
            new IcedAppleCrispOatmilkShakenEspresso(),
            new OleatoIcedShakenEspressoWithOatmilkAndToffeenut(),
            new IcedToastedVanillaOatmilkShakenEspresso(),
            new IcedBrownSugarOatmilkShakenEspresso(),
            new IcedChocolateAlmondmilkShakenEspresso(),
            new IcedShakenEspresso()
    );

    public static final List<MenuItem> icedFlatWhites = Arrays.asList(
            new IcedFlatWhite(),
            new IcedHoneyAlmondmilkFlatWhite()
    );

    public static final List<MenuItem> icedLattes = Arrays.asList(
            new IcedPumpkinSpiceLatte(),
            new StarbucksReserveIcedLatte(),
            new StarbucksReserveIcedHazelnutBiancoLatte(),
            new IcedCaffeLatte(),
            new IcedCinnamonDolceLatte(),
            new IcedStarbucksBlondeVanillaLatte()
    );

    public static final List<MenuItem> icedMacchiatos = Arrays.asList(
            new IcedAppleCrispOatmilkMacchiato(),
            new IcedCaramelMacchiato()
    );

    public static final List<MenuItem> icedMochas = Arrays.asList(
            new IcedWhiteChocolateMocha(),
            new IcedCaffeMocha(),
            new StarbucksReserveIcedDarkChocolateMocha()
    );

    public static final List<Section> coldCoffees = Arrays.asList(
            new Section(COLD_BREWS, R.drawable.harvest_moon_natsume, coldBrews),
            new Section(NITRO_COLD_BREWS, R.drawable.harvest_moon_natsume, nitroColdBrews),
            new Section(ICED_AMERICANO, R.drawable.harvest_moon_natsume, icedAmericano),
            new Section(ICED_COFFEES, R.drawable.harvest_moon_natsume, icedCoffees),
            new Section(ICED_SHAKEN_ESPRESSO, R.drawable.harvest_moon_natsume, icedShakenEspresso),
            new Section(ICED_FLAT_WHITES, R.drawable.harvest_moon_natsume, icedFlatWhites),
            new Section(ICED_LATTES, R.drawable.harvest_moon_natsume, icedLattes),
            new Section(ICED_MACCHIATOS, R.drawable.harvest_moon_natsume, icedMacchiatos),
            new Section(ICED_MOCHAS, R.drawable.harvest_moon_natsume, icedMochas)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String OILEETO = "Oileeto";

    public static final List<MenuItem> oileetoAsMenuItem = Arrays.asList(
            new OleatoGoldenFoamColdBrew(),
            new OleatoCaffeLatteWithOatmilk(),
            new OleatoIcedShakenEspressoWithOatmilkAndToffeenut(),
            new IcedChaiTeaLatteWithOleatoGoldenFoam(),
            new IcedMatchaTeaLatteWithOleatoGoldenFoam(),
            new ParadiseDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam(),
            new DragonDrinkStarbucksRefreshersBeverageWithOleatoGoldenFoam()
    );

    public static final List<Section> oileetoAsSection = Arrays.asList(
            new Section(OILEETO, R.drawable.harvest_moon_natsume, oileetoAsMenuItem)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_TEAS = "Hot Teas";
    public static final String CHAI_TEAS = "Chai Teas";
    public static final String BLACK_TEAS = "Black Teas";
    public static final String GREEN_TEAS = "Green Teas";
    public static final String HERBAL_TEAS = "Herbal Teas";

    public static final List<MenuItem> chaiTeas = Arrays.asList(
            new ChaiTeaLatte(),
            new ChaiTea()
    );

    public static final List<MenuItem> blackTeas = Arrays.asList(
            new EarlGreyTea(),
            new TeavanaLondonFogTeaLatte(),
            new RoyalEnglishBreakfastTea(),
            new RoyalEnglishBreakfastTeaLatte()
    );

    public static final List<MenuItem> greenTeas = Arrays.asList(
            new EmperorsCloudsAndMist(),
            new MatchaTeaLatte(),
            new HoneyCitrusMintTea(),
            new JadeCitrusMintBrewedTea()
    );

    public static final List<MenuItem> herbalTeas = Arrays.asList(
            new MintMajesty(),
            new PeachTranquility()
    );

    public static final List<Section> hotTeas = Arrays.asList(
            new Section(CHAI_TEAS, R.drawable.harvest_moon_natsume, chaiTeas),
            new Section(BLACK_TEAS, R.drawable.harvest_moon_natsume, blackTeas),
            new Section(GREEN_TEAS, R.drawable.harvest_moon_natsume, greenTeas),
            new Section(HERBAL_TEAS, R.drawable.harvest_moon_natsume, herbalTeas)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_DRINKS = "Hot Drinks";
    public static final String HOT_CHOCOLATES = "Hot Chocolates";
    public static final String JUICE = "Juice";
    public static final String STEAMERS = "Steamers";

    public static final List<MenuItem> hotChocolates = Arrays.asList(
            new HotChocolate(),
            new WhiteHotChocolate()
    );

    public static final List<MenuItem> juice = Arrays.asList(
            new CaramelAppleSpice(),
            new SteamedAppleJuice()
    );

    public static final List<MenuItem> steamers = Arrays.asList(
            new PumpkinSpiceCreme(),
            new SteamedMilk(),
            new VanillaCreme()
    );

    public static final List<Section> hotDrinks = Arrays.asList(
            new Section(HOT_CHOCOLATES, R.drawable.harvest_moon_natsume, hotChocolates),
            new Section(JUICE, R.drawable.harvest_moon_natsume, juice),
            new Section(STEAMERS, R.drawable.harvest_moon_natsume, steamers)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String BLENDED_BEVERAGES = "Blended Beverages";
    public static final String COFFEE_FRAPPUCCINO = "Coffee Frappuccino";
    public static final String CREME_FRAPPUCCINO = "Creme Frappuccino";

    public static final List<MenuItem> coffeeFrappuccino = Arrays.asList(
            new AppleCrispOatmilkFrappuccinoBlendedBeverage(),
            new PumpkinSpiceFrappuccinoBlendedBeverage(),
            new MochaCookieCrumbleFrappuccino(),
            new CaramelRibbonCrunchFrappuccinoBlendedBeverage(),
            new EspressoFrappuccinoBlendedBeverage(),
            new CoffeeFrappuccinoBlendedBeverage(),
            new CaffeVanillaFrappuccinoBlendedBeverage(),
            new CaramelFrappuccinoBlendedBeverage(),
            new MochaFrappuccinoBlendedBeverage(),
            new JavaChipFrappuccinoBlendedBeverage(),
            new WhiteChocolateMochaFrappuccinoBlendedBeverage()
    );

    public static final List<MenuItem> cremeFrappuccino = Arrays.asList(
            new AppleCrispOatmilkCremeFrappuccinoBlendedBeverage(),
            new PumpkinSpiceCremeFrappuccinoBlendedBeverage(),
            new ChocolateCookieCrumbleCremeFrappuccino(),
            new CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage(),
            new StrawberryCremeFrappuccinoBlendedBeverage(),
            new ChaiCremeFrappuccino(),
            new DoubleChocolatyChipCremeFrappuccinoBlendedBeverage(),
            new MatchaCremeFrappuccinoBlendedBeverage(),
            new VanillaBeanCremeFrappuccinoBlendedCreme(),
            new WhiteChocolateCremeFrappuccinoBlendedBeverage()
    );

    public static final List<Section> blendedBeverages = Arrays.asList(
            new Section(COFFEE_FRAPPUCCINO, R.drawable.harvest_moon_natsume, coffeeFrappuccino),
            new Section(CREME_FRAPPUCCINO, R.drawable.harvest_moon_natsume, cremeFrappuccino)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String ICED_TEAS = "Iced Teas";
    public static final String BOTTLED_TEAS = "Bottled Teas";
    public static final String ICED_BLACK_TEAS = "Iced Black Teas";
    public static final String ICED_CHAI_TEAS = "Iced Chai Teas";
    public static final String ICED_GREEN_TEAS = "Iced Green Teas";
    public static final String ICED_HERBAL_TEAS = "Iced Herbal Teas";

    public static final List<MenuItem> bottledTeas = Arrays.asList(
            new TeavanaSparklingUnsweetenedPeachNectarineGreenTea(),
            new TeavanaMangoBlackTea()
    );

    public static final List<MenuItem> icedBlackTeas = Arrays.asList(
            new IcedBlackTea(),
            new IcedBlackTeaLemonade(),
            new IcedRoyalEnglishBreakfastTeaLatte(),
            new IcedLondonFogTeaLatte()
    );

    public static final List<MenuItem> icedChaiTeas = Arrays.asList(
            new IcedPumpkinCreamChaiTeaLatte(),
            new IcedChaiTeaLatte()
    );

    public static final List<MenuItem> icedGreenTeas = Arrays.asList(
            new IcedPeachGreenTea(),
            new IcedPeachGreenTeaLemonade(),
            new IcedMatchaTeaLatte(),
            new IcedGreenTea(),
            new IcedGreenTeaLemonade(),
            new IcedMatchaLemonade()
    );

    public static final List<MenuItem> icedHerbalTeas = Arrays.asList(
            new IcedPassionTangoTea(),
            new IcedPassionTangoTeaLemonade()
    );

    public static final List<Section> icedTeas = Arrays.asList(
            new Section(BOTTLED_TEAS, R.drawable.harvest_moon_natsume, bottledTeas),
            new Section(ICED_BLACK_TEAS, R.drawable.harvest_moon_natsume, icedBlackTeas),
            new Section(ICED_CHAI_TEAS, R.drawable.harvest_moon_natsume, icedChaiTeas),
            new Section(ICED_GREEN_TEAS, R.drawable.harvest_moon_natsume, icedGreenTeas),
            new Section(ICED_HERBAL_TEAS, R.drawable.harvest_moon_natsume, icedHerbalTeas)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String COLD_DRINKS = "Cold Drinks";
    public static final String REFRESHERS = "Starbucks Refreshers";
    public static final String ICED_JUICE = "Juice";
    public static final String MILK = "Milk";
    public static final String SPARKLING_WATER = "Sparkling Water";
    public static final String WATER = "Water";

    public static final List<MenuItem> refreshers = Arrays.asList(
            new FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage(),
            new FrozenStrawberryAcaiLemonadeStarbucksRefreshersBeverage(),
            new FrozenMangoDragonfruitLemonadeStarbucksRefreshersBeverage(),
            new ParadiseDrinkStarbucksRefreshersBeverage(),
            new PineapplePassionfruitStarbucksRefreshersBeverage(),
            new PineapplePassionfruitLemonadeStarbucksRefreshersBeverage(),
            new PinkDrinkStarbucksRefreshersBeverage(),
            new StrawberryAcaiStarbucksRefreshersBeverage(),
            new StrawberryAcaiLemonadeStarbucksRefreshersBeverage(),
            new DragonDrinkStarbucksRefreshersBeverage(),
            new MangoDragonfruitStarbucksRefreshersBeverage(),
            new MangoDragonfruitLemonadeStarbucksRefreshersBeverage()
    );

    public static final List<MenuItem> icedJuice = Arrays.asList(
            new StarbucksBayaEnergyMangoGuava(),
            new EvolutionFreshOrganicVitalBerry(),
            new EvolutionFreshOrganicDefenseUp(),
            new EvolutionFreshOrange(),
            new EvolutionFreshOrganicSuperFruitGreens(),
            new EvolutionFreshMightyWatermelon(),
            new TreeTopAppleJuiceBox(),
            new StarbucksBayaEnergyRaspberryLime(),
            new Lemonade(),
            new BlendedStrawberryLemonade()
    );

    public static final List<MenuItem> milk = Arrays.asList(
            new HorizonChocolateOrganicMilk(),
            new HorizonOrganicLowfatMilkBox(),
            new ColdMilk(),
            new HorizonOrganicVanillaMilkBox()
    );

    public static final List<MenuItem> sparklingWater = Arrays.asList(
            new GalvaninaSparklingWater(),
            new SpindriftGrapefruitSparklingWater(),
            new SpindriftRaspberryLimeSparklingWater(),
            new GalvaninaSparklingWaterLime()
    );

    public static final List<MenuItem> water = Arrays.asList(
            new DasaniBottledWater(),
            new EthosBottledWater(),
            new HawaiiVolcanicWater(),
            new FilteredTapWater()
    );

    public static final List<Section> coldDrinks = Arrays.asList(
            new Section(REFRESHERS, R.drawable.harvest_moon_natsume, refreshers),
            new Section(ICED_JUICE, R.drawable.harvest_moon_natsume, icedJuice),
            new Section(MILK, R.drawable.harvest_moon_natsume, milk),
            new Section(SPARKLING_WATER, R.drawable.harvest_moon_natsume, sparklingWater),
            new Section(WATER, R.drawable.harvest_moon_natsume, water)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // ======================================================================

    public static final String HOT_BREAKFAST = "Hot Breakfast";
    public static final String BREAKFAST_SANDWICHES_AND_WRAPS = "Breakfast Sandwiches & Wraps";
    public static final String SOUS_VIDE_EGG_BITES = "Sous Vide Egg Bites";

    public static final List<MenuItem> breakfastSandwichesAndWraps = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> sousVideEggBites = Arrays.asList(
            // TODO:
    );

    public static final List<Section> hotBreakfast = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String OATMEAL_AND_YOGURT = "Oatmeal & Yogurt";

    public static final List<Section> oatmealAndYogurt = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String BAKERY = "Bakery";
    public static final String BAGELS = "Bagels";
    public static final String CAKE_POPS = "Cake Pops";
    public static final String COOKIES_BROWNIES_AND_BARS = "Cookies, Brownies & Bars";
    public static final String CROISSANTS = "Croissants";
    public static final String LOAVES_CAKES_AND_BUNS = "Loaves, Cakes & Buns";
    public static final String DANISHES_AND_DOUGHNUTS = "Danishes & Doughnuts";
    public static final String MUFFINS_AND_SCONES = "Muffins & Scones";

    public static final List<MenuItem> bagels = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> cakePops = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> cookiesBrowniesAndBars = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> croissants = Arrays.asList(
            // TODO:
    );

    public static final List<Section> loavesCakesAndBuns = Arrays.asList(
            // TODO:
    );

    public static final List<Section> danishesAndDoughnuts = Arrays.asList(
            // TODO:
    );

    public static final List<Section> muffinsAndScones = Arrays.asList(
            // TODO:
    );

    public static final List<Section> bakery = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String LUNCH = "Lunch";
    public static final String WARM_SANDWICHES = "Warm Sandwiches";
    public static final String PROTEIN_BOXES = "Protein Boxes";

    public static final List<Section> warmSandwiches = Arrays.asList(
            // TODO:
    );

    public static final List<Section> proteinBoxes = Arrays.asList(
            // TODO:
    );

    public static final List<Section> lunch = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String SNACKS_AND_SWEETS = "Snacks & Sweets";
    public static final String BISCOTTI_AND_COOKIES = "Biscotti & Cookies";
    public static final String CHOCOLATES_AND_CANDY = "Chocolates & Candy";
    public static final String FRUITS_AND_NUTS = "Fruits & Nuts";
    public static final String GUM_AND_MINTS = "Gum & Mints";
    public static final String POPCORN_AND_CHIPS = "Popcorn & Chips";
    public static final String MEAT_AND_CHEESE = "Meat & Cheese";
    public static final String SNACK_BARS = "Snack Bars";
    public static final String SPREADS = "Spreads";

    public static final List<MenuItem> biscottiAndCookies = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> chocolatesAndCandy = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> fruitsAndNuts = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> gumAndMints = Arrays.asList(
            // TODO:
    );

    public static final List<Section> popcornAndChips = Arrays.asList(
            // TODO:
    );

    public static final List<Section> meatAndCheese = Arrays.asList(
            // TODO:
    );

    public static final List<Section> snackBars = Arrays.asList(
            // TODO:
    );

    public static final List<Section> spreads = Arrays.asList(
            // TODO:
    );

    public static final List<Section> snacksAndSweets = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String WHOLE_BEAN = "Whole Bean";

    public static final List<Section> wholeBean = Arrays.asList(
            // TODO:
    );

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String INSTANT_COFFEE = "Instant Coffee";

    public static final List<Section> instantCoffee = Arrays.asList(
            // TODO:
    );

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String COLD_CUPS = "Cold Cups";

    public static final List<Section> coldCups = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String TUMBLERS = "Tumblers";

    public static final List<Section> tumblers = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String MUGS = "Mugs";

    public static final List<Section> mugs = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String WATER_BOTTLES = "Water Bottles";

    public static final List<Section> waterBottles = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String OTHER = "Other";

    public static final List<Section> other = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // ######################################################################

    public static final String HAPPY_BIRTHDAY = "Happy Birthday";

    public static final List<Section> happyBirthday = Arrays.asList(
            // TODO:
    );

    // ######################################################################

    // ######################################################################

    public static final String THANK_YOU = "Thank You";

    public static final List<Section> thankYou = Arrays.asList(
            // TODO:
    );

    // ######################################################################

    // ######################################################################

    public static final String TRADITIONAL = "Traditional";

    public static final List<Section> traditional = Arrays.asList(
            // TODO:
    );

    // ######################################################################

    // **********************************************************************
    // class: MenuFragment
    // **********************************************************************

    public static final List<Topic> drinks = Arrays.asList(
            new Topic(OILEETO, R.drawable.harvest_moon_natsume, oileetoAsSection),
            new Topic(HOT_COFFEES, R.drawable.harvest_moon_natsume, hotCoffees),
            new Topic(HOT_TEAS, R.drawable.harvest_moon_natsume, hotTeas),
            new Topic(HOT_DRINKS, R.drawable.harvest_moon_natsume, hotDrinks),
            new Topic(BLENDED_BEVERAGES, R.drawable.harvest_moon_natsume, blendedBeverages),
            new Topic(COLD_COFFEES, R.drawable.harvest_moon_natsume, coldCoffees),
            new Topic(ICED_TEAS, R.drawable.harvest_moon_natsume, icedTeas),
            new Topic(COLD_DRINKS, R.drawable.harvest_moon_natsume, coldDrinks)
    );

    public static final List<Topic> food = Arrays.asList(
            new Topic(HOT_BREAKFAST, R.drawable.harvest_moon_natsume, hotBreakfast),
            new Topic(OATMEAL_AND_YOGURT, R.drawable.harvest_moon_natsume, oatmealAndYogurt),
            new Topic(BAKERY, R.drawable.harvest_moon_natsume, bakery),
            new Topic(LUNCH, R.drawable.harvest_moon_natsume, lunch),
            new Topic(SNACKS_AND_SWEETS, R.drawable.harvest_moon_natsume, snacksAndSweets)
    );

    public static final List<Topic> atHomeCoffee = Arrays.asList(
            new Topic(WHOLE_BEAN, R.drawable.harvest_moon_natsume, wholeBean),
            new Topic(INSTANT_COFFEE, R.drawable.harvest_moon_natsume, instantCoffee)
    );

    public static final List<Topic> merchandise = Arrays.asList(
            new Topic(COLD_CUPS, R.drawable.harvest_moon_natsume, coldCups),
            new Topic(TUMBLERS, R.drawable.harvest_moon_natsume, tumblers),
            new Topic(MUGS, R.drawable.harvest_moon_natsume, mugs),
            new Topic(WATER_BOTTLES, R.drawable.harvest_moon_natsume, waterBottles),
            new Topic(OTHER, R.drawable.harvest_moon_natsume, other)
    );

    public static final List<Topic> giftCards = Arrays.asList(
            new Topic(HAPPY_BIRTHDAY, R.drawable.harvest_moon_natsume, happyBirthday),
            new Topic(THANK_YOU, R.drawable.harvest_moon_natsume, thankYou),
            new Topic(TRADITIONAL, R.drawable.harvest_moon_natsume, traditional)
    );

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    public static final String DRINKS = "Drinks";
    public static final String FOOD = "Food";
    public static final String AT_HOME_COFFEE = "At Home Coffee";
    public static final String MERCHANDISE = "Merchandise";
    public static final String GIFT_CARDS = "Gift Cards";

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    public static final List<Category> categories = Arrays.asList(
            new Category(DRINKS, R.drawable.harvest_moon_natsume, drinks),
            new Category(FOOD, R.drawable.harvest_moon_natsume, food),
            new Category(AT_HOME_COFFEE, R.drawable.harvest_moon_natsume, atHomeCoffee),
            new Category(MERCHANDISE, R.drawable.harvest_moon_natsume, merchandise),
            new Category(GIFT_CARDS, R.drawable.harvest_moon_natsume, giftCards)
    );
}
