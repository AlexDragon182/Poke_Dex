package com.example.pokedex.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Retrofit.Models.Pokemon
import com.example.pokedex.databinding.RvpokemonitemBinding

import okhttp3.internal.http2.Http2Connection


class PokemonAdapter (
    private val context: Context,
    list:List<Pokemon>
): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    //Diff Uitil
    private val differCallback = object : DiffUtil.ItemCallback<Pokemon> (){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
    //Asynt list differ , tool to compare differences
    val differ = AsyncListDiffer(this, differCallback)

    private var setOnItemClickListener : ((Pokemon) -> Unit)? = null
    fun setOnItemClickListener(listener:(Pokemon) -> Unit) {
        setOnItemClickListener = listener
    }


    inner class PokemonViewHolder (val binding: RvpokemonitemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:Pokemon) = with (binding){
            root.setOnClickListener(){
                setOnItemClickListener?.invoke(item)
            }
            //Glide.with(context).load(item.url.).into(ivPokemonFace)
            tvPokemonName.text = item.name
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            RvpokemonitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = differ.currentList[position]
        holder.bind(pokemon)

        }
    }

