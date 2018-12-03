package com.sulistyo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    companion object {
        const val TITLE = "nama"
        const val IMAGE = "logo"
        const val DESCRIPTION = "deskripsi"
    }

    private var title: String = ""
    private var logo: Int = 0
    private var description: String = ""

    lateinit var clubName: TextView
    lateinit var logoClub: ImageView
    lateinit var clubdescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            logoClub = imageView().
                lparams(width = dip(100), height = wrapContent) {
                    gravity = Gravity.CENTER
                }

            clubName = textView().
                lparams(width = wrapContent) {
                    gravity = Gravity.CENTER
                    topMargin = dip(16)
                }

            clubdescription = textView().
                lparams(width = wrapContent) {
                    topMargin = dip(20)

                }
        }

        title = intent.getStringExtra(TITLE)
        logo = intent.getIntExtra(IMAGE, 0)
        description = intent.getStringExtra(DESCRIPTION)

        Glide.with(applicationContext).load(logo).into(logoClub)
        clubName.text = title
        clubdescription.text = description
    }
}
