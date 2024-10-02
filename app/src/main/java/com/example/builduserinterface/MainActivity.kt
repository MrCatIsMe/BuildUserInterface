package com.example.builduserinterface

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserInfoAdapter
    private val userInfoList = mutableListOf<UserInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo các thành phần UI
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextPhone: EditText = findViewById(R.id.editTextPhone)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val checkBoxAgree: CheckBox = findViewById(R.id.checkBoxAgree)
        val buttonSave: Button = findViewById(R.id.buttonSave)
        val recyclerViewInfo: RecyclerView = findViewById(R.id.recyclerViewInfo)

        // Khởi tạo RecyclerView và Adapter
        adapter = UserInfoAdapter(userInfoList)
        recyclerViewInfo.adapter = adapter
        recyclerViewInfo.layoutManager = LinearLayoutManager(this)

        // Xử lý sự kiện khi nhấn nút Lưu
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()
            val gender = when (radioGroupGender.checkedRadioButtonId) {
                R.id.radioMale -> "Nam"
                R.id.radioFemale -> "Nữ"
                else -> "Khác"
            }
            val isAgree = checkBoxAgree.isChecked

            if (isAgree) {
                val userInfo = UserInfo(name, email, phone, gender)
                userInfoList.add(userInfo)
                adapter.notifyDataSetChanged()  // Cập nhật RecyclerView
            } else {
                Toast.makeText(this, "Bạn phải đồng ý với điều khoản", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
