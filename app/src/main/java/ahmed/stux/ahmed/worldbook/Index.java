package ahmed.stux.ahmed.worldbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class Index extends AppCompatActivity {

    private String [] ListData = {"المقدمة", "الحصن", "الورد اليومي", "أذكار و دعوات", "حزب ربنا الله", "حزب الأسماء الحسنى", "حزب الله", "كتاب الفضائل", "طريقة العمل بالكتاب", "المراجع", "ملحقات الكتاب"};
    private Integer [] ListIndex = {3, 18, 22, 26, 35, 50, 70, 182, 269, 271, 272};
    private Adapter adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        adapter = new Adapter(this, ListData);

        list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Index.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("index", ListIndex[position]);
                startActivity(intent);
            }
        });


    }
}
