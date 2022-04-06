package com.example.chatproject;

import android.content.Context;
import androidx.cardview.widget.CardView;import androidx.recyclerview.widget.RecyclerView;import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;



public class Adapter_List_Chat extends RecyclerView.Adapter<Adapter_List_Chat.ViewHolder>
{
    List<model_list_chat> data_list;
    Context context;
    String NameCustumer;

    public Adapter_List_Chat(String nameUser,Context context, List<model_list_chat> data_list)
    {
        this.context = context;
        this.data_list = data_list;
        this.NameCustumer=nameUser;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //Connect adapter view to layout row_chat
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.row_chat, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {


            //set text message and get data from modeL

            holder.txt_soal.setText( NameCustumer +": "+data_list.get( position ).getDescription() );



    }


    @Override
    public int getItemCount()
    {
        return data_list.size();
    }

    public void insert(int position,model_list_chat data)
    {
        data_list.add(position, data );
        notifyItemInserted(position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView txt_soal;
        CardView cardView;


        public ViewHolder(View item)
        {
            super( item );

            txt_soal = (TextView) item.findViewById( R.id.txt_soal );

            cardView = (CardView) item.findViewById( R.id.crd_chat );

        }
    }
}
