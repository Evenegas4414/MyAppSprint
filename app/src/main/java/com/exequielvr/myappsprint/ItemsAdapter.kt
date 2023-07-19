package com.exequielvr.myappsprint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exequielvr.myappsprint.databinding.CoursesListBinding


class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemVH>() {

    private var listItems = listOf<ItemsEntity>()
    private val SelectedItem = MutableLiveData<ItemsEntity>()


    fun update(list: List<ItemsEntity>) {
        listItems = list
        notifyDataSetChanged()
    }

    fun selectedItem():
            LiveData<ItemsEntity> = SelectedItem


    inner class ItemVH(private val mBinding: CoursesListBinding) :
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener {

        //////// MODIFICAR
        fun bind(course: ItemsEntity) {
            Glide.with(mBinding.ivLogo).load(course.image).centerCrop().into(mBinding.ivLogo)
            mBinding.tvname.text = course.title
            mBinding.tvdescription.text = course.previewDescription
            mBinding.tvduration.text = "duración: " + course.weeks.toString() + " Semanas"
            mBinding.tvstart.text = "Inicio: " + course.star
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            SelectedItem.value = listItems[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        return ItemVH(CoursesListBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }


    override fun getItemCount() =
        listItems.size
}




