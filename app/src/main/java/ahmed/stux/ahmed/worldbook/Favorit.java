package ahmed.stux.ahmed.worldbook;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class Favorit extends AppCompatActivity {

    private FavoritAdapter Fadapter;
    private ListView list;
    private ArrayList<Integer> pages;
    private Database myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pages = new ArrayList<>();
        myDB = new Database(this);

        viewAll();
        Fadapter = new FavoritAdapter(this, pages);

        list = (ListView) findViewById(R.id.favoritlist);

        list.setAdapter(Fadapter);

    }


    public void viewAll()
    {
        Cursor res = myDB.getAllData();
        if (0 ==res.getCount()) {
            return;
        }
        while (res.moveToNext()) {
            pages.add(res.getInt(0));
        }
    }

}
