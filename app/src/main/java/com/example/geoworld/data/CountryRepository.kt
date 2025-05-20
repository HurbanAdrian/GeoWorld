package com.example.geoworld.data

import com.example.geoworld.R
import com.example.geoworld.model.Country
import com.example.geoworld.model.Region

object CountryRepository {
    val countries = listOf(
        Country("Albania", "alb", R.drawable.flag_alb, R.drawable.map_alb, "Europe"),
        Country("Andorra", "and", R.drawable.flag_and, R.drawable.map_and, "Europe"),
        Country("Austria", "aut", R.drawable.flag_aut, R.drawable.map_aut, "Europe"),
        Country("Belgium", "bel", R.drawable.flag_bel, R.drawable.map_bel, "Europe"),
        Country("Bulgaria", "bgr", R.drawable.flag_bgr, R.drawable.map_bgr, "Europe"),
        Country("Bosnia and Herzegovina", "bih", R.drawable.flag_bih, R.drawable.map_bih, "Europe"),
        Country("Belarus", "blr", R.drawable.flag_blr, R.drawable.map_blr, "Europe"),
        Country("Switzerland", "che", R.drawable.flag_che, R.drawable.map_che, "Europe"),
        Country("Czech Republic", "cze", R.drawable.flag_cze, R.drawable.map_cze, "Europe"),
        Country("Germany", "deu", R.drawable.flag_deu, R.drawable.map_deu, "Europe"),
        Country("Denmark", "dnk", R.drawable.flag_dnk, R.drawable.map_dnk, "Europe"),
        Country("Spain", "esp", R.drawable.flag_esp, R.drawable.map_esp, "Europe"),
        Country("Estonia", "est", R.drawable.flag_est, R.drawable.map_est, "Europe"),
        Country("Finland", "fin", R.drawable.flag_fin, R.drawable.map_fin, "Europe"),
        Country("France", "fra", R.drawable.flag_fra, R.drawable.map_fra, "Europe"),
        Country("United Kingdom", "gbr", R.drawable.flag_gbr, R.drawable.map_gbr, "Europe"),
        Country("Greece", "grc", R.drawable.flag_grc, R.drawable.map_grc, "Europe"),
        Country("Croatia", "hrv", R.drawable.flag_hrv, R.drawable.map_hrv, "Europe"),
        Country("Hungary", "hun", R.drawable.flag_hun, R.drawable.map_hun, "Europe"),
        Country("Ireland", "irl", R.drawable.flag_irl, R.drawable.map_irl, "Europe"),
        Country("Iceland", "isl", R.drawable.flag_isl, R.drawable.map_isl, "Europe"),
        Country("Italy", "ita", R.drawable.flag_ita, R.drawable.map_ita, "Europe"),
        Country("Liechtenstein", "lie", R.drawable.flag_lie, R.drawable.map_lie, "Europe"),
        Country("Lithuania", "ltu", R.drawable.flag_ltu, R.drawable.map_ltu, "Europe"),
        Country("Luxembourg", "lux", R.drawable.flag_lux, R.drawable.map_lux, "Europe"),
        Country("Latvia", "lva", R.drawable.flag_lva, R.drawable.map_lva, "Europe"),
        Country("Monaco", "mco", R.drawable.flag_mco, R.drawable.map_mco, "Europe"),
        Country("Moldova", "mda", R.drawable.flag_mda, R.drawable.map_mda, "Europe"),
        Country("North Macedonia", "mkd", R.drawable.flag_mkd, R.drawable.map_mkd, "Europe"),
        Country("Malta", "mlt", R.drawable.flag_mlt, R.drawable.map_mlt, "Europe"),
        Country("Montenegro", "mne", R.drawable.flag_mne, R.drawable.map_mne, "Europe"),
        Country("Netherlands", "nld", R.drawable.flag_nld, R.drawable.map_nld, "Europe"),
        Country("Norway", "nor", R.drawable.flag_nor, R.drawable.map_nor, "Europe"),
        Country("Poland", "pol", R.drawable.flag_pol, R.drawable.map_pol, "Europe"),
        Country("Portugal", "prt", R.drawable.flag_prt, R.drawable.map_prt, "Europe"),
        Country("Romania", "rou", R.drawable.flag_rou, R.drawable.map_rou, "Europe"),
        Country("Russia", "rus", R.drawable.flag_rus, R.drawable.map_rus, "Europe"),
        Country("San Marino", "smr", R.drawable.flag_smr, R.drawable.map_smr, "Europe"),
        Country("Serbia", "srb", R.drawable.flag_srb, R.drawable.map_srb, "Europe"),
        Country("Slovakia", "svk", R.drawable.flag_svk, R.drawable.map_svk, "Europe"),
        Country("Slovenia", "svn", R.drawable.flag_svn, R.drawable.map_svn, "Europe"),
        Country("Sweden", "swe", R.drawable.flag_swe, R.drawable.map_swe, "Europe"),
        Country("Turkey", "tur", R.drawable.flag_tur, R.drawable.map_tur, "Europe"),
        Country("Ukraine", "ukr", R.drawable.flag_ukr, R.drawable.map_ukr, "Europe"),
        Country("Vatican City", "vat", R.drawable.flag_vat, R.drawable.map_vat, "Europe"),

        // Africa
        Country("Algeria", "alg", R.drawable.flag_alg, R.drawable.map_alg, "Africa"),
        Country("Egypt", "egy", R.drawable.flag_egy, R.drawable.map_egy, "Africa"),
        Country("Ethiopia", "eth", R.drawable.flag_eth, R.drawable.map_eth, "Africa"),
        Country("Nigeria", "nga", R.drawable.flag_nga, R.drawable.map_nga, "Africa"),
        Country("South Africa", "saf", R.drawable.flag_saf, R.drawable.map_saf, "Africa"),

        // Asia
        Country("China", "chn", R.drawable.flag_chn, R.drawable.map_chn, "Asia"),
        Country("Japan", "jpn", R.drawable.flag_jpn, R.drawable.map_jpn, "Asia"),
        Country("Mongolia", "mng", R.drawable.flag_mng, R.drawable.map_mng, "Asia"),
        Country("South Korea", "kor", R.drawable.flag_kor, R.drawable.map_kor, "Asia"),
        Country("Vietnam", "vnm", R.drawable.flag_vnm, R.drawable.map_vnm, "Asia"),

        // Oceania
        Country("Fiji", "fji", R.drawable.flag_fji, R.drawable.map_fji, "Oceania"),
        Country("Vanuatu", "vut", R.drawable.flag_vut, R.drawable.map_vut, "Oceania"),
        Country("Australia", "aus", R.drawable.flag_aus, R.drawable.map_aus, "Oceania"),
        Country("New Zealand", "nzl", R.drawable.flag_nzl, R.drawable.map_nzl, "Oceania"),

        // America
        Country("Canada", "can", R.drawable.flag_can, R.drawable.map_can, "America"),
        Country("Mexico", "mex", R.drawable.flag_mex, R.drawable.map_mex, "America"),
        Country("United States", "usa", R.drawable.flag_usa, R.drawable.map_usa, "America"),
        Country("Argentina", "arg", R.drawable.flag_arg, R.drawable.map_arg, "America"),
        Country("Brazil", "bra", R.drawable.flag_bra, R.drawable.map_bra, "America"),
    )

    fun getCountriesByRegion(region: Region): List<Country> {
        return countries.filter { country ->
            when (region) {
                Region.EUROPE -> country.continent.equals("Europe", ignoreCase = true)
                Region.ASIA -> country.continent.equals("Asia", ignoreCase = true)
                Region.AFRICA -> country.continent.equals("Africa", ignoreCase = true)
                Region.AMERICA -> country.continent.equals("America", ignoreCase = true)
                Region.OCEANIA -> country.continent.equals("Oceania", ignoreCase = true)
            }
        }
    }
}