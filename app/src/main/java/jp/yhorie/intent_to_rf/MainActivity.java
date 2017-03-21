package jp.yhorie.intent_to_rf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // get ACTION_SEND intent
    Intent mGetIntent = getIntent();
    String mAction = mGetIntent.getAction();
    if (Intent.ACTION_SEND.equals(mAction)) {
      Bundle extras = mGetIntent.getExtras();
      if (extras != null) {
        CharSequence mCharSequenceSubject = extras.getCharSequence(Intent.EXTRA_SUBJECT);
        CharSequence mCharSequenceText = extras.getCharSequence(Intent.EXTRA_TEXT);
        if (mCharSequenceText != null) {
          Uri uri = Uri.parse("http://yhor1e.github.io/rf/?title=" + String.valueOf(mCharSequenceSubject) + "&description=" + String.valueOf(mCharSequenceText));
          Intent mIntent = new Intent(Intent.ACTION_VIEW, uri);
          startActivity(mIntent);
        }
      }
    }
  }
}
