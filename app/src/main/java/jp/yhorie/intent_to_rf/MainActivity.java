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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onStart() {
    super.onStart();
    getAndSendIntent(getIntent());
  }

  private void getAndSendIntent(Intent mIntent) {
    String mAction = mIntent.getAction();
    if (Intent.ACTION_SEND.equals(mAction)) {
      Bundle extras = mIntent.getExtras();
      if (extras != null) {
        CharSequence mCharSequenceSubject = extras.getCharSequence(Intent.EXTRA_SUBJECT);
        extras.remove(Intent.EXTRA_SUBJECT);
        CharSequence mCharSequenceText = extras.getCharSequence(Intent.EXTRA_TEXT);
        extras.remove(Intent.EXTRA_TEXT);
        if (mCharSequenceText != null) {
          Uri uri = Uri.parse("http://yhor1e.github.io/rf/?title=" + String.valueOf(mCharSequenceSubject) + "&description=" + String.valueOf(mCharSequenceText));
          Toast.makeText(MainActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
          intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
          startActivity(intent);
        }
      }
    }
  }

  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    this.setIntent(intent);
  }
}
