package com.example.chatapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.MessageActivity;
import com.example.chatapp.R;
import com.example.chatapp.modelClasses.RegisterDataModel;

import java.util.List;

public class UserAapter extends RecyclerView.Adapter <UserAapter.ViewHolder>{



    private Context mContext;
    private List<RegisterDataModel> mUser;
    private boolean isChat;

    public UserAapter(Context mContext, List<RegisterDataModel> mUser,boolean isChat) {
        this.mContext = mContext;
        this.mUser = mUser;
        this.isChat = isChat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.users_item,parent,false);
        return new UserAapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RegisterDataModel model = mUser.get(position);
        holder.username.setText(model.getUserName());
/*        if (model.getImageURl().equals("default")){

            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        }else {
            Glide.with(mContext).load(model.getImageURl()).into(holder.profile_image);
        }

 */


            // online & offline status
            if (model.getStatus().equals("online")){
                holder.img_on.setVisibility(View.VISIBLE);
                holder.img_off.setVisibility(View.GONE);
            }else if (model.getStatus().equals("offline")){
                holder.img_on.setVisibility(View.GONE);
                holder.img_off.setVisibility(View.VISIBLE);
            }else {
                holder.img_on.setVisibility(View.GONE);
                holder.img_off.setVisibility(View.GONE);
            }


            // move to the message activity
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MessageActivity.class);
                    intent.putExtra("userid",model.getId());
                    mContext.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;
        public ImageView profile_image;
        private ImageView img_on;
        private ImageView img_off;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile_image = itemView.findViewById(R.id.user_profile_image);
            username = itemView.findViewById(R.id.username_txt);
            img_on = itemView.findViewById(R.id.online);
            img_off = itemView.findViewById(R.id.offline);

        }
    }
}
