package io.github.lettucech.navcompexamples.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import io.github.lettucech.navcompexamples.R
import io.github.lettucech.navcompexamples.fragment.NavContainerFragment
import io.github.lettucech.navcompexamples.view.OnBackPressedListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_container, NavContainerFragment())
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val fragment = supportFragmentManager.findFragmentById(R.id.layout_container)
                fragment is OnBackPressedListener && fragment.onBackPressed()
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
