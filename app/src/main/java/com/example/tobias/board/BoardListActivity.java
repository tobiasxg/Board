package com.example.tobias.board;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class BoardListActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());


        String[] listOfUsers = "olim,toby,omar,frenkieboy,mickey mouse,Piet,Jan,Johan,Sjaak,Koningin Beatrix,Swaggerboy123,Piet2".split(",");
//        String[] listOfIcons = ;

        lv=(ListView) findViewById(R.id.listViewCustom);
        lv.setAdapter(new CustomAdapter(this, listOfUsers,listOfUsers));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "OLIM", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if(event2.getX() < event1.getX()){
                Toast.makeText(BoardListActivity.this, "OLIM SWIPE Right", Toast.LENGTH_SHORT).show();
            }
            else if(event2.getX() > event1.getX()){
                Intent intent = new Intent(BoardListActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
            return true;
        }
    }
}