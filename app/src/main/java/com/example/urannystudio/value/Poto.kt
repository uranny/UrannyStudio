package com.example.urannystudio.value

import java.net.URI

data class Post(
    val id : Int,
    val uri : String,
    val ttl : String,
    val cnt : String,
    var fav : Boolean
)

object Value {
    val postLst = arrayListOf(
        Post(1, "hello", "hello1", "hello", false),
        Post(2, "hello", "hello2", "hello", true),
        Post(3, "hello", "hello3", "hello", false)
    )
}