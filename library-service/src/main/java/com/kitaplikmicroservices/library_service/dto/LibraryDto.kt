package com.kitaplikmicroservices.library_service.dto

data class LibraryDto @JvmOverloads constructor(
    //JvmOverloads make different constructor
    val id :String,
    val userBookList: List<BookDto>? =ArrayList()
){

}
