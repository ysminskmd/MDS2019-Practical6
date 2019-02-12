package com.example.shad.shad2018_practical5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

private const val PICK_CONTACT_REQUEST = 1000

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pickContact1(view: View) {
        // Create an intent to "pick" a contact, as defined by the content provider URI
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, PICK_CONTACT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_CONTACT_REQUEST) {
            // Perform a query to the contact's content provider for the contact's name
            val cursor = contentResolver.query(
                    data.data!!,
                    arrayOf(ContactsContract.Contacts.DISPLAY_NAME),
                    null,
                    null,
                    null
            )
            if (cursor?.moveToFirst() == true) { // True if the cursor is not empty
                val columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                val name = cursor.getString(columnIndex)
                // Do something with the selected contact's name...

                Toast.makeText(this@MainActivity, name, Toast.LENGTH_SHORT).show()
            }
            cursor?.close()
        }
    }
}
