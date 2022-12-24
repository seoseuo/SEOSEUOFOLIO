package kr.ac.hallym.seoseuofolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.seoseuofolio.databinding.SeoCardViewBinding

class SeoViewHolder(val binding: SeoCardViewBinding) : RecyclerView.ViewHolder(binding.root)

class SeoAdapter(val contents1: MutableList<String>?, val contents2:MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        SeoViewHolder(
            SeoCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as SeoViewHolder).binding
        binding.titleText.text = contents1!![position]
        binding.detailText.text = contents2!![position]
    }

    override fun getItemCount(): Int {
        return contents1?.size?:0
    }
}