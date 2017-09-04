package com.yanlongrivenk.greendao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanlongrivenk.greendao.entity.Student;

import java.util.List;

/**
 * Created by yanlongRivenK on 2017/9/4.
 */

public class GdRecyclerview extends RecyclerView.Adapter<GdRecyclerview.ViewHolder> {

    private List<Student> list;
    private Context mContext;
    protected String hh = "\n";

    public GdRecyclerview(Context context, List<Student> list) {
        this.list = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = list.get(position);
        holder.mTv.setText(student.getStuId() + hh + student.getStuName() + hh + student.getStuCode() + hh
        + student.getStuSex() + hh + student.getStuScore());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected final TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = ((TextView) itemView.findViewById(R.id.tv));
        }
    }

    public void update(List<Student> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
