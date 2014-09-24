package app.it.testone_55410075;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Show1075 extends Activity {
	private ListView l1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show1_075);
		l1 = (ListView) findViewById(R.id.listView1);

		SQLDB_075 sqldb_075 = new SQLDB_075(this);
		ArrayList<HashMap<String, String>> arrayList = sqldb_075
				.SelectAllData();
		SimpleAdapter adapter;
		adapter = new SimpleAdapter(Show1075.this, arrayList,
				R.layout.show_item075,
				new String[] {"UserID","Name","Score","Grade"}, new int[] {
						R.id.user075, R.id.name075, R.id.score075,
						R.id.Grade075 });
		l1.setAdapter(adapter);
	}
}
