package com.ldh.profilelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ItemViewHolder>{
    List<Person> persons;
    private ProfileClickListener profileClickListener;

    public ProfileAdapter(List<Person> persons, ProfileClickListener profileClickListener) {
        this.persons = persons;
        this.profileClickListener = profileClickListener;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_profile_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
         Person person = persons.get(position);
         holder.textView_stt.setText(person.getId()+"");
         holder.imageView_avatar.setImageResource(person.getAvatar());
         holder.textView_name.setText(person.getName());
         holder.textView_gmail.setText(person.getEmail());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textView_stt,textView_name,textView_gmail;
        private ImageView imageView_avatar;
        private ProfileClickListener _profileClickListener;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_stt = itemView.findViewById(R.id.textView_stt);
            textView_gmail = itemView.findViewById(R.id.textView_gmail);
            textView_name = itemView.findViewById(R.id.textView_name);
            imageView_avatar = itemView.findViewById(R.id.imageView_avatar);
            _profileClickListener = profileClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (_profileClickListener!=null){
                        _profileClickListener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
