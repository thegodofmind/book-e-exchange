package com.example.bookexchange

class bookdetails
{
    /// Model class
    var bookName : String? = null
    var authorName : String? = null
    var language : String? = null
    var bookImage : String? = null

    constructor(){

    }

    constructor(bookName: String?, authorName: String?,language:String?, bookImage: String?) {
        this.bookName = bookName
        this.authorName = authorName
        this.language = language
        this.bookImage = bookImage
    }
}