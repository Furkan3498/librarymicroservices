package com.kitaplikmicroservices.library_service.dto

data class LibraryDto(
    val id :String,
    val userBookMap: List<BookDto>
){

}
