package jp.hotmix.databasesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CocktailMemoActivity extends AppCompatActivity {

    int _cocktailId = -1;
    String _cocktailName = "";
    TextView _tvCocktailName;
    Button _btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_memo);

        _tvCocktailName = findViewById(R.id.tvCocktailName);
        _btnSave = findViewById(R.id.btnSave);
        ListView lvCocktail = findViewById(R.id.lvCocktail);
        lvCocktail.setOnItemClickListener(new ListItemClickListener());

    }

    public void onSaveButtonClick(View view){
        EditText etNote = findViewById(R.id.etNote);
        _tvCocktailName.setText(getString(R.string.tv_name));
        etNote.setText("");
        _btnSave.setEnabled(false);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            _cocktailId = position;
            _cocktailName = (String) parent.getItemAtPosition(position);
            _tvCocktailName.setText(_cocktailName);
            _btnSave.setEnabled(true);
        }
    }
}
