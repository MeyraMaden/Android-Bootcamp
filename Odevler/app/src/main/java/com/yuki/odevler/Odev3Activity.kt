import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.yuki.odevler.R

class Odev3Activity : AppCompatActivity() {

    private var isDarkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_odev3)

        val pizzaAdiTextView: TextView = findViewById(R.id.pizzaAdi)
        val pizzaImageView: ImageView = findViewById(R.id.pizzaGorseli)
        val icindekilerTextView: TextView = findViewById(R.id.icindekiler)
        val fiyatTextView: TextView = findViewById(R.id.fiyat)
        val sepeteEkleButton: Button = findViewById(R.id.sepeteEkle)
        val dilSecenekButton: Button = findViewById(R.id.dilSecenek) // Basit bir dil seçeneği butonu
        val geceModuButton: Button = findViewById(R.id.geceModu) // Gece modu butonu

        pizzaAdiTextView.text = "Beef Cheese"
        icindekilerTextView.text = "Peynir, Sucuk, Zeytin, Biber"
        fiyatTextView.text = "$5.98"
        // pizzaImageView.setImageResource(R.drawable.beef_cheese_pizza) // Görseli ekleyin

        dilSecenekButton.setOnClickListener {
            // Burada basit bir dil değişimi simülasyonu yapılabilir.
            // Örneğin, bir TextView'in içeriğini değiştirebilirsiniz.
        }

        geceModuButton.setOnClickListener {
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            isDarkMode = !isDarkMode
        }
    }
}