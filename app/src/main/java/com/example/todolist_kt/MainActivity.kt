package com.example.todolist_kt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemLongClickListener

import android.widget.ArrayAdapter
import android.widget.Toast







class MainActivity : AppCompatActivity() {
    lateinit var items : ArrayList<String>
    lateinit var list : ListView
    lateinit var button : Button
    lateinit var itemsAdapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.list)
        button = findViewById(R.id.btn_enter)


        button.setOnClickListener {

                additem()

        }

        items = ArrayList()
        itemsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        list.adapter = itemsAdapter
        list.onItemLongClickListener =
            OnItemLongClickListener { parent, view, position, id -> remove(position) }


    }

    private fun remove(position: Int): Boolean {
        val context: Context = applicationContext
        Toast.makeText(context, "삭제", Toast.LENGTH_LONG).show()
        items.removeAt(position)
        itemsAdapter.notifyDataSetChanged()
        return true
    }
    fun additem() {
        val input : EditText = findViewById(R.id.et_text)
        var itemText : String = input.text.toString()

        if (!(itemText.equals("."))){
            itemsAdapter.add(itemText);
            input.setText("");
        }

        else {
            Toast.makeText(getApplicationContext(), "엔터를 눌러주세요...", Toast.LENGTH_SHORT).show();
        }
    }
}