/**IMPORTANT: Make sure you are using the correct package name.
This example uses the package name:
package com.example.android.justjava
If you get an error when copying this code into Android studio, update it to match teh package name found
in the project's AndroidManifest.xml file.
 */
package com.example.myfirstapp


import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


/**

This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {
    /**
     * Variable global
     */
    var cantidad: Int = 0
    var pointteamA: Int = 0
    var pointteamB: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /**
     * This method is called when the order button is clicked.
     */


    fun increment(view: View?) {
        if(cantidad == 100){
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return
        }
        cantidad += 1
        display(cantidad)


    }

    fun decrement(view: View?) {
        if (cantidad == 1){
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return
        }
        cantidad -= 1
        display(cantidad)

    }

    fun submitOrder(view: View?) {

        // Codigo Edit Text
        val nameField = findViewById<View>(R.id.edit_text) as EditText
        val name = nameField.text.toString()

        // Figure out if the user wants chocolate topping

        // Figure out if the user wants chocolate topping
        val chocolateCheckBox = findViewById<View>(R.id.chocolate_cream_checkbox) as CheckBox
        val hasChocolate = chocolateCheckBox.isChecked


        val whippedCreamCheckBox = findViewById<View>(R.id.whipped_cream_checkbox) as CheckBox
        val hasWhippedCream = whippedCreamCheckBox.isChecked

        val price = calculatePrice(hasChocolate, hasWhippedCream)
        val message: String = createOrderSummary(name, price, hasChocolate, hasWhippedCream)
        displayPrice(message)

    }


    private fun createOrderSummary(name: String, price: Int, addWhippedCream: Boolean, addChocolate: Boolean): String {
        var priceMessage = "Nombre:$name"
        priceMessage += "\nAdd whipped cream? $addWhippedCream"
        priceMessage += "\nAdd chocolate? $addChocolate"
        priceMessage += "\nTotal: $price"
        priceMessage += "\nThank you!"
        return priceMessage
    }


    private fun calculatePrice(addChocolate: Boolean, addWhippedCream: Boolean): Int {

        var basePrice: Int = 5
        if (addWhippedCream) {
            basePrice = basePrice + 1
        }
        if (addChocolate) {
            basePrice = basePrice + 2

        }

        return cantidad * basePrice
    }

    fun points3(view: View?) {
        pointteamA += 3
        displayForTeamA(pointteamA)
    }

    fun points2(view: View?) {
        pointteamA += 2
        displayForTeamA(pointteamA)
    }

    fun points1(view: View?) {
        pointteamA += 1
        displayForTeamA(pointteamA)
    }

    fun points3B(view: View?) {
        this.pointteamB += 3
        displayForTeamB(pointteamB)
    }

    fun points2B(view: View?) {
        pointteamB += 2
        displayForTeamB(pointteamB)
    }

    fun points1B(view: View?) {
        pointteamB += 1
        displayForTeamB(pointteamB)
    }

    fun reset(view: View?) {

        displayForTeamA(0)
        displayForTeamB(0)
        pointteamA = 0
        pointteamB = 0

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private fun display(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_text_view) as TextView
        quantityTextView.text = ("" + number)
    }


    private fun displayForTeamA(score: Int) {
        val scoreView = findViewById<View>(R.id.team_a_score) as TextView
        scoreView.text = score.toString()
    }

    fun displayForTeamB(score: Int) {
        val scoreView = findViewById<View>(R.id.team_b_score) as TextView
        scoreView.text = score.toString()
    }

    private fun displayPrice(message: String) {
        val orderSummaryTextView = findViewById<View>(R.id.price_text_view) as TextView
        orderSummaryTextView.text = message
    }


}

