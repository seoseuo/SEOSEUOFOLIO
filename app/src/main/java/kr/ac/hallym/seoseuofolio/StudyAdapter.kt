package kr.ac.hallym.seoseuofolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.seoseuofolio.databinding.StudyCardViewBinding

class StudyViewHolder(val binding: StudyCardViewBinding) : RecyclerView.ViewHolder(binding.root)

class StudyAdapter(
    val contents1: MutableList<Int>?, val contents2: MutableList<String>?,
    val contents3:MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        StudyViewHolder(StudyCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        ))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as StudyViewHolder).binding

        binding.imageView.setImageResource(contents1!![position])
        binding.titleText.text= contents2!![position]
        binding.detailText.text=contents3!![position]
    }

    override fun getItemCount(): Int {
        return contents1?.size?:0
    }
}