package abdo.finalproject.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import abdo.finalproject.data.Data;
import abdo.finalproject.R;
import abdo.finalproject.models.MobileModel;
import abdo.finalproject.ui.activity.DetailsActivity;

public class MenuPage extends Fragment {
    View view;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.recycleView);

        List<MobileModel> list = new Data().getData();
        recyclerView.setAdapter(new MobileAdapter(list, getContext()));
        
    }

    class MobileAdapter extends RecyclerView.Adapter<MobileAdapterVH> {
        List<MobileModel> list;
        Context context;

        public MobileAdapter(List<MobileModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public MobileAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.mobile_item, parent, false);
            return new MobileAdapterVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MobileAdapterVH holder, int position) {

            final MobileModel mobileModel = list.get(position);

            String name = mobileModel.getName();
            String label = mobileModel.getLabel();
            int image = mobileModel.getImage();

            holder.name_mobile.setText(name);
            holder.label_mobile.setText(label);
            holder.mobile_image.setImageResource(image);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("mobile", mobileModel);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class MobileAdapterVH extends RecyclerView.ViewHolder {

        ImageView mobile_image;
        TextView name_mobile, label_mobile;

        public MobileAdapterVH(@NonNull View itemView) {
            super(itemView);

            mobile_image = itemView.findViewById(R.id.mobile_iv_item);
            name_mobile = itemView.findViewById(R.id.name_tv_item);
            label_mobile = itemView.findViewById(R.id.label_tv_item);

        }
    }
}
