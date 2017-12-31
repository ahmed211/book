package ahmed.stux.ahmed.worldbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class FavoritAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Integer> pages;
    private Database myDB;

    public FavoritAdapter(@NonNull Context context, ArrayList<Integer> pages) {
        super(context, R.layout.favorit_raw, pages);


        this.context = context;
        this.pages = pages;

    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.favorit_raw, parent, false);

        TextView text = (TextView) row.findViewById(R.id.favorititem);
        ImageButton del = (ImageButton) row.findViewById(R.id.delete);
        myDB = new Database(context);


        if(pages.get(position) <3)
            text.setText("مقدمة " + (pages.get(position)+1));
        else
            text.setText("صفحة رقم " + (pages.get(position)-2) );

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteData(pages.get(position).toString());
                pages.remove(position);
                notifyDataSetChanged();
            }

        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("index", pages.get(position));
                context.startActivity(intent);

            }
        });

        return row;
    }
}