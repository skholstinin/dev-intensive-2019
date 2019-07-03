package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstName: String? = parts?.getOrNull(0)
        var lastName: String? = parts?.getOrNull(1)
        firstName = if (firstName == "") null else firstName
        lastName = if (lastName == "") null else lastName
        return Pair(firstName, lastName)
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val parts: List<String>? = payload?.split(divider)
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        val charFirstName: CharArray = firstName!!.toCharArray()
        val charLastName: CharArray = lastName!!.toCharArray()
        var str: String = ""
        charFirstName.forEach { i ->
            if (i.isUpperCase()) str += cyrToLat(i).toUpperCase() else str += cyrToLat(i)
        }
        str += divider
        charLastName.forEach { i ->
            if (i.isUpperCase()) str += cyrToLat(i).toUpperCase() else str += cyrToLat(i)
        }
        return str
    }

    fun cyrToLat(char: Char): String {
        var str: String = when (char.toLowerCase()) {
            'a' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е' -> "e"
            'ё' -> "e"
            'ж' -> "zh"
            'з' -> "z"
            'и' -> "i"
            'й' -> "i"
            'к' -> "k"
            'л' -> "l"
            'м' -> "m"
            'н' -> "n"
            'о' -> "o"
            'п' -> "p"
            'р' -> "r"
            'с' -> "s"
            'т' -> "t"
            'у' -> "u"
            'ф' -> "f"
            'х' -> "h"
            'ц' -> "c"
            'ч' -> "ch"
            'ш' -> "sh"
            'щ' -> "sh"
            'ъ' -> ""
            'ы' -> "i"
            'ь' -> ""
            'э' -> "e"
            'ю' -> "yu"
            'я' -> "ya"
            else -> char.toString()
        }
        return str
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstInitial: String? = when (firstName) {
            null -> ""
            " " -> ""
            "" -> ""
            else -> firstName[0].toString().toUpperCase()
        }
        val secondInitial: String? = when (lastName) {
            null -> ""
            " " -> ""
            "" -> ""
            else -> lastName[0].toString().toUpperCase()
        }
        val initials: String = firstInitial.toString() + secondInitial.toString()
        return when (initials) {
            "" -> "null"
            else -> initials
        }
    }
}