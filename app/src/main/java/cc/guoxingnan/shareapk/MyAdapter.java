package cc.guoxingnan.shareapk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<AppInfo> data;

    public MyAdapter(Context context, List<AppInfo> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public AppInfo getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
            holder.sizeTextView = (TextView) convertView.findViewById(R.id.sizeTextView);
            holder.timeTextView = (TextView) convertView.findViewById(R.id.timeTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        AppInfo appInfo = data.get(position);

        holder.nameTextView.setText(appInfo.getAppName());
        holder.sizeTextView.setText(appInfo.getAppSize());
        holder.timeTextView.setText(appInfo.getAppTime());
        holder.iconImageView.setImageDrawable(appInfo.getAppIcon());

        return convertView;
    }

    class ViewHolder {
        TextView nameTextView;
        TextView sizeTextView;
        TextView timeTextView;
        ImageView iconImageView;
    }
}
