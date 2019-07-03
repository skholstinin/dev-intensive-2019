package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")
    }

    @Test
    fun test_factory() {
//       val user = User.makeUser("John Cena")
//       val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John Wick")
        print(user3)
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")
        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()
        println("$id,$firstName,$lastName")
        println("${user.component1()},$firstName,$lastName")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date())
        val user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))
        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent()
        )
    }

    @Test
    fun test_date_format() {
        val date = Date(System.currentTimeMillis())
        println(date.format())
        println(date.format("HH:mm:ss"))
    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("Sergey Kh")
        user.lastVisit?.add(-2, TimeUnits.HOUR)
        val userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abtract_factory() {
        val user = User.makeUser("Sergey Kh")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")
        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_create_initials() {
        val user = User.makeUser("vasja Pupkin")
        println(Utils.toInitials("john", "doe"))
        println(Utils.toInitials("John", null))
        println(Utils.toInitials(null, null))
        println(Utils.toInitials(" ", ""))
    }

    @Test
    fun test_transliteration() {
        val user = User.makeUser("vasja Pupkin")
        println(Utils.transliteration("Вася Пупкин", "_"))
    }
}
