package com.example.jadwalshalat_uasakb.ui.monthly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jadwalshalat_uasakb.databinding.ItemScheduleMonthlyBinding
import com.example.jadwalshalat_uasakb.model.ScheduleMonthlyResponse

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ItemScheduleMonthlyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position], position = position)

    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ScheduleViewHolder(private val binding: ItemScheduleMonthlyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ScheduleMonthlyResponse.Data.Jadwal, position: Int) {
            binding.run {
                tvBoxImsakClock.text = item.imsak
                tvBoxDzuhurClock.text = item.dzuhur
                tvBoxAsharClock.text = item.ashar
                tvBoxMaghribClock.text = item.maghrib
                tvBoxIsyaClock.text = item.isya
                tvDateBox.text = item.tanggal
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<ScheduleMonthlyResponse.Data.Jadwal>() {
        override fun areItemsTheSame(
            oldExampleModel: ScheduleMonthlyResponse.Data.Jadwal, newExampleModel: ScheduleMonthlyResponse.Data.Jadwal
        ): Boolean {
            return oldExampleModel.date == newExampleModel.date
        }

        override fun areContentsTheSame(
            oldExampleModel: ScheduleMonthlyResponse.Data.Jadwal, newExampleModel: ScheduleMonthlyResponse.Data.Jadwal
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

}