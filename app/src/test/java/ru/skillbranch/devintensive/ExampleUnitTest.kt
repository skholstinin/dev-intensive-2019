package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.models.User
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
        val user2 = user.copy(id = "2", lastVisit = Date())
        if (user.equals(user2)) {
            println("equals $user \n $user2")
        } else {
            println("not equals $user \n $user2")
        }
    }
}
