package com.hero.infobeer.models

/**
 * Created by Cyan on 12/03/2018.
 */
class Brewery {
    lateinit var key : String
    lateinit var title : String
    lateinit var synonyms : String
    lateinit var since : String
    lateinit var address : String
    lateinit var web : String
    var prod : String? = ""
    var tags = mutableListOf<String>()
    var beers = mutableListOf<Beer>()
    lateinit var country : Country
}