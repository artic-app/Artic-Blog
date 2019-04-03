package anway.somani.artic_blog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static java.security.AccessController.getContext;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewHolder> {

    protected Context mContext;
    private List<BlogInstance> blogList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, title, author_name, desc;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            author_name = (TextView) view.findViewById(R.id.author);
            desc = (TextView) view.findViewById(R.id.desc);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "An item has been clicked, and its been detected here! Balle!", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    v.getContext().startActivity(new Intent(v.getContext(), BlogLinkView.class));
                }
            });
        }
    }

    public BlogAdapter(HomeFragment mContext, List<BlogInstance> blogList) {
        this.blogList = blogList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_blog, parent, false);
        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BlogInstance blogInstance = blogList.get(position);

        //holder.id.setText(String.valueOf(blogInstance.getId()));
        holder.title.setText(blogInstance.getTitle());
        holder.author_name.setText(blogInstance.getAuthor_name());
        holder.desc.setText(blogInstance.getContent());

    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }
}
