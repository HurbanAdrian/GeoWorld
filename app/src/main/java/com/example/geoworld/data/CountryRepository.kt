package com.example.geoworld.data

import com.example.geoworld.R
import com.example.geoworld.model.Country
import com.example.geoworld.model.Region

object CountryRepository {
    val countries = listOf(
        Country(R.string.country_albania, "alb", R.drawable.flag_alb, R.drawable.map_alb, "Europe"),
        Country(R.string.country_andorra, "and", R.drawable.flag_and, R.drawable.map_and, "Europe"),
        Country(R.string.country_austria, "aut", R.drawable.flag_aut, R.drawable.map_aut, "Europe"),
        Country(R.string.country_belgium, "bel", R.drawable.flag_bel, R.drawable.map_bel, "Europe"),
        Country(R.string.country_bulgaria, "bgr", R.drawable.flag_bgr, R.drawable.map_bgr, "Europe"),
        Country(R.string.country_bosnia_and_herzegovina, "bih", R.drawable.flag_bih, R.drawable.map_bih, "Europe"),
        Country(R.string.country_belarus, "blr", R.drawable.flag_blr, R.drawable.map_blr, "Europe"),
        Country(R.string.country_switzerland, "che", R.drawable.flag_che, R.drawable.map_che, "Europe"),
        Country(R.string.country_czech_republic, "cze", R.drawable.flag_cze, R.drawable.map_cze, "Europe"),
        Country(R.string.country_germany, "deu", R.drawable.flag_deu, R.drawable.map_deu, "Europe"),
        Country(R.string.country_denmark, "dnk", R.drawable.flag_dnk, R.drawable.map_dnk, "Europe"),
        Country(R.string.country_spain, "esp", R.drawable.flag_esp, R.drawable.map_esp, "Europe"),
        Country(R.string.country_estonia, "est", R.drawable.flag_est, R.drawable.map_est, "Europe"),
        Country(R.string.country_finland, "fin", R.drawable.flag_fin, R.drawable.map_fin, "Europe"),
        Country(R.string.country_france, "fra", R.drawable.flag_fra, R.drawable.map_fra, "Europe"),
        Country(R.string.country_united_kingdom, "gbr", R.drawable.flag_gbr, R.drawable.map_gbr, "Europe"),
        Country(R.string.country_greece, "grc", R.drawable.flag_grc, R.drawable.map_grc, "Europe"),
        Country(R.string.country_croatia, "hrv", R.drawable.flag_hrv, R.drawable.map_hrv, "Europe"),
        Country(R.string.country_hungary, "hun", R.drawable.flag_hun, R.drawable.map_hun, "Europe"),
        Country(R.string.country_ireland, "irl", R.drawable.flag_irl, R.drawable.map_irl, "Europe"),
        Country(R.string.country_iceland, "isl", R.drawable.flag_isl, R.drawable.map_isl, "Europe"),
        Country(R.string.country_italy, "ita", R.drawable.flag_ita, R.drawable.map_ita, "Europe"),
        Country(R.string.country_liechtenstein, "lie", R.drawable.flag_lie, R.drawable.map_lie, "Europe"),
        Country(R.string.country_lithuania, "ltu", R.drawable.flag_ltu, R.drawable.map_ltu, "Europe"),
        Country(R.string.country_luxembourg, "lux", R.drawable.flag_lux, R.drawable.map_lux, "Europe"),
        Country(R.string.country_latvia, "lva", R.drawable.flag_lva, R.drawable.map_lva, "Europe"),
        Country(R.string.country_monaco, "mco", R.drawable.flag_mco, R.drawable.map_mco, "Europe"),
        Country(R.string.country_moldova, "mda", R.drawable.flag_mda, R.drawable.map_mda, "Europe"),
        Country(R.string.country_north_macedonia, "mkd", R.drawable.flag_mkd, R.drawable.map_mkd, "Europe"),
        Country(R.string.country_malta, "mlt", R.drawable.flag_mlt, R.drawable.map_mlt, "Europe"),
        Country(R.string.country_montenegro, "mne", R.drawable.flag_mne, R.drawable.map_mne, "Europe"),
        Country(R.string.country_netherlands, "nld", R.drawable.flag_nld, R.drawable.map_nld, "Europe"),
        Country(R.string.country_norway, "nor", R.drawable.flag_nor, R.drawable.map_nor, "Europe"),
        Country(R.string.country_poland, "pol", R.drawable.flag_pol, R.drawable.map_pol, "Europe"),
        Country(R.string.country_portugal, "prt", R.drawable.flag_prt, R.drawable.map_prt, "Europe"),
        Country(R.string.country_romania, "rou", R.drawable.flag_rou, R.drawable.map_rou, "Europe"),
        Country(R.string.country_russia, "rus", R.drawable.flag_rus, R.drawable.map_rus, "Europe"),
        Country(R.string.country_san_marino, "smr", R.drawable.flag_smr, R.drawable.map_smr, "Europe"),
        Country(R.string.country_serbia, "srb", R.drawable.flag_srb, R.drawable.map_srb, "Europe"),
        Country(R.string.country_slovakia, "svk", R.drawable.flag_svk, R.drawable.map_svk, "Europe"),
        Country(R.string.country_slovenia, "svn", R.drawable.flag_svn, R.drawable.map_svn, "Europe"),
        Country(R.string.country_sweden, "swe", R.drawable.flag_swe, R.drawable.map_swe, "Europe"),
        Country(R.string.country_turkey, "tur", R.drawable.flag_tur, R.drawable.map_tur, "Europe"),
        Country(R.string.country_ukraine, "ukr", R.drawable.flag_ukr, R.drawable.map_ukr, "Europe"),
        Country(R.string.country_vatican_city, "vat", R.drawable.flag_vat, R.drawable.map_vat, "Europe"),

        // Africa
        Country(R.string.country_algeria, "alg", R.drawable.flag_alg, R.drawable.map_alg, "Africa"),
        Country(R.string.country_egypt, "egy", R.drawable.flag_egy, R.drawable.map_egy, "Africa"),
        Country(R.string.country_ethiopia, "eth", R.drawable.flag_eth, R.drawable.map_eth, "Africa"),
        Country(R.string.country_nigeria, "nga", R.drawable.flag_nga, R.drawable.map_nga, "Africa"),
        Country(R.string.country_south_africa, "saf", R.drawable.flag_saf, R.drawable.map_saf, "Africa"),

        // Asia
        Country(R.string.country_china, "chn", R.drawable.flag_chn, R.drawable.map_chn, "Asia"),
        Country(R.string.country_japan, "jpn", R.drawable.flag_jpn, R.drawable.map_jpn, "Asia"),
        Country(R.string.country_mongolia, "mng", R.drawable.flag_mng, R.drawable.map_mng, "Asia"),
        Country(R.string.country_south_korea, "kor", R.drawable.flag_kor, R.drawable.map_kor, "Asia"),
        Country(R.string.country_vietnam, "vnm", R.drawable.flag_vnm, R.drawable.map_vnm, "Asia"),

        // Oceania
        Country(R.string.country_fiji, "fji", R.drawable.flag_fji, R.drawable.map_fji, "Oceania"),
        Country(R.string.country_vanuatu, "vut", R.drawable.flag_vut, R.drawable.map_vut, "Oceania"),
        Country(R.string.country_australia, "aus", R.drawable.flag_aus, R.drawable.map_aus, "Oceania"),
        Country(R.string.country_new_zealand, "nzl", R.drawable.flag_nzl, R.drawable.map_nzl, "Oceania"),

        // America
        Country(R.string.country_canada, "can", R.drawable.flag_can, R.drawable.map_can, "America"),
        Country(R.string.country_mexico, "mex", R.drawable.flag_mex, R.drawable.map_mex, "America"),
        Country(R.string.country_united_states, "usa", R.drawable.flag_usa, R.drawable.map_usa, "America"),
        Country(R.string.country_argentina, "arg", R.drawable.flag_arg, R.drawable.map_arg, "America"),
        Country(R.string.country_brazil, "bra", R.drawable.flag_bra, R.drawable.map_bra, "America"),
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