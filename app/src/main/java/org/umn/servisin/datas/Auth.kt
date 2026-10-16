package org.umn.servisin.datas

import org.umn.servisin.model.User

object AuthRepository {
    private val userList = mutableListOf<User>()

//    Untuk dafta user baru
    fun registerUser(user: User): Boolean {

        val existingUser = userList.find { it.email == user.email || it.phone == user.phone }
        if (existingUser != null) {
            return false
        }
        userList.add(user)
        return true
    }

//    Validasi
    fun loginUser(emailOrPhone: String, pass: String): User? {
        return userList.find {
            (it.email == emailOrPhone || it.phone == emailOrPhone) && it.password == pass
        }
    }
}