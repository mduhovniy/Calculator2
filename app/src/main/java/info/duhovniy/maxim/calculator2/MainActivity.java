package info.duhovniy.maxim.calculator2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_CLEAR_ID = 1;
    final int MENU_EXIT_ID = 2;
    final int MAX_RESULT_LENGHT = 10;

    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;
    Button but7;
    Button but8;
    Button but9;
    Button but0;
    Button butDot;
    Button butEqual;
    Button butAdd;
    Button butMult;
    Button butDiv;
    Button butSub;
    Button butDel;

    TextView textResult;

    LinkedList oper = new LinkedList<Character>();
    String tmp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = (Button) findViewById(R.id.button1);
        but2 = (Button) findViewById(R.id.button2);
        but3 = (Button) findViewById(R.id.button3);
        but4 = (Button) findViewById(R.id.button4);
        but5 = (Button) findViewById(R.id.button5);
        but6 = (Button) findViewById(R.id.button6);
        but7 = (Button) findViewById(R.id.button7);
        but8 = (Button) findViewById(R.id.button8);
        but9 = (Button) findViewById(R.id.button9);
        but0 = (Button) findViewById(R.id.button0);
        butDel = (Button) findViewById(R.id.buttonDel);
        butEqual = (Button) findViewById(R.id.buttonEqual);
        butDot = (Button) findViewById(R.id.buttonDot);
        butAdd = (Button) findViewById(R.id.buttonAdd);
        butMult = (Button) findViewById(R.id.buttonMult);
        butSub = (Button) findViewById(R.id.buttonSub);
        butDiv = (Button) findViewById(R.id.buttonDiv);

        textResult = (TextView) findViewById(R.id.textView);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but0.setOnClickListener(this);
        butDel.setOnClickListener(this);
        butEqual.setOnClickListener(this);
        butDot.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butMult.setOnClickListener(this);
        butSub.setOnClickListener(this);
        butDiv.setOnClickListener(this);

//        if(this.getRequestedOrientation() == );


    }
    // some changes

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_CLEAR_ID, 0, "Clear");
        menu.add(0, MENU_EXIT_ID, 0, "Exit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case MENU_CLEAR_ID:
                oper.clear();
                textResult.setText(listToString(oper));
                break;
            case MENU_EXIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        char newChar = ' ';

        switch(v.getId()) {
            case R.id.button1:
                newChar = '1';
                break;
            case R.id.button2:
                newChar = '2';
                break;
            case R.id.button3:
                newChar = '3';
                break;
            case R.id.button4:
                newChar = '4';
                break;
            case R.id.button5:
                newChar = '5';
                break;
            case R.id.button6:
                newChar = '6';
                break;
            case R.id.button7:
                newChar = '7';
                break;
            case R.id.button8:
                newChar = '8';
                break;
            case R.id.button9:
                newChar = '9';
                break;
            case R.id.button0:
                newChar = '0';
                break;
            case R.id.buttonDot:
                newChar = '.';
                break;
            case R.id.buttonEqual:
                // TODO: count method
                break;
            case R.id.buttonDel:
                if(!oper.isEmpty())
                    oper.removeLast();
                break;
            case R.id.buttonAdd:
                // TODO: add method
                break;
            case R.id.buttonMult:
                // TODO: multiply method
                break;
            case R.id.buttonSub:
                // TODO: substitute method
                break;
            case R.id.buttonDiv:
                // TODO: divide method
                break;
            default:
                break;

        }
        if((oper.size() < MAX_RESULT_LENGHT) && (newChar != ' ')) {
            oper.add(newChar);
        }
        textResult.setText(listToString(oper));

    }

    String listToString(LinkedList l) {
        String result = "";
        for(int i = 0; i < l.size(); i++) {
            result += l.get(i);
        }
        return result;
    }

}
