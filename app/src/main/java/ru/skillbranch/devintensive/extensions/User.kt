package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Never been" else if (isOnline) "online" else "Last view ${lastVisit.humanizeDiff(
            lastVisit
        )}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickname = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}

