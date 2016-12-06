package com.rayootech.www.greendaoexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoHolder> {

    private UserInfoClick clickListener;
    private List<UserIMInfo> dataset;

    public interface UserInfoClick {
        void onNoteClick(int position);
    }

    static class UserInfoHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public TextView comment;

        public UserInfoHolder(View itemView, final UserInfoClick clickListener) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tv_userinfo);
            comment = (TextView) itemView.findViewById(R.id.tv_dbid);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.onNoteClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public UserInfoAdapter(UserInfoClick clickListener) {
        this.clickListener = clickListener;
        this.dataset = new ArrayList<UserIMInfo>();
    }

    public void setNotes(@NonNull List<UserIMInfo> notes) {
        dataset = notes;
        notifyDataSetChanged();
    }

    public UserIMInfo getUserInfo(int position) {
        return dataset.get(position);
    }

    @Override
    public UserInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserInfoHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(UserInfoHolder holder, int position) {
        UserIMInfo userIMInfo = dataset.get(position);
        holder.text.setText(userIMInfo.toString());
//        holder.comment.setText(userIMInfo.getId() + "");
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
