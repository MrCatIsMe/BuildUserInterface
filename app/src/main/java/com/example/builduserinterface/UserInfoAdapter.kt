package com.example.builduserinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Dữ liệu người dùng
data class UserInfo(val name: String, val email: String, val phone: String, val gender: String)

// Adapter cho RecyclerView
class UserInfoAdapter(private val userInfoList: List<UserInfo>) :
    RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>() {

    // ViewHolder để quản lý từng item trong RecyclerView
    class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        val phoneTextView: TextView = itemView.findViewById(R.id.textViewPhone)
        val genderTextView: TextView = itemView.findViewById(R.id.textViewGender)
    }

    // Tạo ViewHolder từ layout item_user_info.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_info, parent, false)
        return UserInfoViewHolder(view)
    }

    // Gán dữ liệu vào các thành phần UI trong ViewHolder
    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val userInfo = userInfoList[position]
        holder.nameTextView.text = userInfo.name
        holder.emailTextView.text = userInfo.email
        holder.phoneTextView.text = userInfo.phone
        holder.genderTextView.text = userInfo.gender
    }

    // Trả về số lượng item trong danh sách
    override fun getItemCount(): Int = userInfoList.size
}
