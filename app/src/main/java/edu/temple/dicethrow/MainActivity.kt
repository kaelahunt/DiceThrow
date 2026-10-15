package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


//some code was referenced from @andron-e's fork on GitHub, due to the fact that I missed the first part of the assignment

class MainActivity : AppCompatActivity(), DieFragment.DieRollInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) !is DieFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(sides = 20))
                .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {

            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView) as DieFragment).throwDie()

            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView2) as DieFragment).throwDie()
        }

    }
    override fun rollDice(){
        (supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as DieFragment).throwDie()

        (supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView2) as DieFragment).throwDie()
    }

}