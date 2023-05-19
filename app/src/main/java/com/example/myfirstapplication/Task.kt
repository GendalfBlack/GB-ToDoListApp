package com.example.myfirstapplication

import java.util.Date

class Task(s: String, s1: String, date: Date) {
    private var title_ = s
    var title: String
        get(){return title_}
        set(value){ title_ = value}
    private var description_ = s1
    var description: String
        get(){return description_}
        set(value){ description_ = value}
    var dueDate: Date = date
}