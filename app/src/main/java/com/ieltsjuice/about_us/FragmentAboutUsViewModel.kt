package com.ieltsjuice.about_us

import android.content.Intent
import com.ieltsjuice.model.Teacher
import com.ieltsjuice.util.*

class FragmentAboutUsViewModel {
    fun putExtra(intent: Intent,teacher:Teacher){
        intent.putExtra(PAGE_NAME_KEY,"AboutUs")
        intent.putExtra(KEY_teacherName, teacher.teacherName)
        intent.putExtra(KEY_teacherFamily, teacher.teacherFamily)
        intent.putExtra(KEY_teacherTitle, teacher.title)
        intent.putExtra(KEY_teacherDesc, teacher.description)
        intent.putExtra(KEY_teacherImage, teacher.image)
        intent.putExtra(KEY_teacherFacebook, teacher.facebook)
        intent.putExtra(KEY_teacherLinkedin, teacher.linkedin)
        intent.putExtra(KEY_teacherInstagram, teacher.instagram)
        intent.putExtra(KEY_teacherWebpage, teacher.webpage)
        intent.putExtra(KEY_teacherSkype, teacher.skype)
    }
}