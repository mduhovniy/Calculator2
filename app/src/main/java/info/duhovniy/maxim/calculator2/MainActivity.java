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
    final int MAX_RESULT_LENGHT = 12;
    final String KEY_INPUT_TEXT = "inputText";
    final String KEY_RESULT_TEXT = "resultText";
    final String KEY_INPUT_LIST = "inputList";

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

    TextView textInput;
    TextView textResult;

    LinkedList oper = new LinkedList<>();
    double num1 = 0;
    double num2 = 0;
    double result = 0;

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

        textInput = (TextView) findViewById(R.id.textView);
        textResult = (TextView) findViewById(R.id.resultView);

        if(savedInstanceState != null){
//            String savedInput = savedInstanceState.getString(KEY_INPUT_TEXT);
            //listToString(oper));
            String savedResult = savedInstanceState.getString(KEY_RESULT_TEXT);
            //String.valueOf(result));
            textResult.setText(savedResult);
//            textInput.setText(savedInput);
            oper = (LinkedList) savedInstanceState.getSerializable(KEY_INPUT_LIST);
            textInput.setText(listToString(oper));
        }

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

    }

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
                result = 0;
                num1 = 0;
                num2 = 0;
                textInput.setText(listToString(oper));
                textResult.setText(String.valueOf(result));
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
                if (!oper.isEmpty() && (oper.contains('/') || oper.contains('+')
                        || oper.contains('x') || oper.contains('-'))) {
                    calculateResult();
                }
                break;
            case R.id.buttonDel:
                if (!oper.isEmpty())
                    oper.removeLast();
                break;
            case R.id.buttonAdd:
                if (!oper.isEmpty()) {
                    newChar = '+';
                    if(num1 !=0) {
                        calculateResult();
                    } else {
                        num1 = Double.valueOf(listToString(oper));
                        result = num1;
                    }
                }
                break;
            case R.id.buttonMult:
                if (!oper.isEmpty()) {
                    newChar = 'x';
                    if(num1 !=0) {
                        calculateResult();
                    } else {
                        num1 = Double.valueOf(listToString(oper));
                        result = num1;
                    }
                }
                break;
            case R.id.buttonSub:
                if (!oper.isEmpty()) {
                    newChar = '-';
                    if(num1 !=0) {
                        calculateResult();
                    } else {
                        num1 = Double.valueOf(listToString(oper));
                        result = num1;
                    }
                }
                break;
            case R.id.buttonDiv:
                if(!oper.isEmpty()) {
                    newChar = '/';
                    if(num1 !=0) {
                        calculateResult();
                    } else {
                        num1 = Double.valueOf(listToString(oper));
                        result = num1;
                    }
                }
                break;
            default:
                break;
        }
        if((oper.size() < MAX_RESULT_LENGHT) && (newChar != ' ')) {
            oper.add(newChar);
        }

        textResult.setText(String.valueOf(result));

        textInput.setText(listToString(oper));
    }

    String listToString(LinkedList l) {
        String res = "";

        for(int i = 0; i < l.size(); i++) {
            res += l.get(i);
        }
        return res;
    }

    void calculateResult() {
        String res = "";
        boolean start = false;
        Character operName = ' ';

        for(int i = 0; i < oper.size(); i++) {
            if(start)
                res += oper.get(i);
            if((Character)oper.get(i) == '+' || (Character)oper.get(i) == '/'
                    || (Character)oper.get(i) == 'x' || (Character)oper.get(i) == '-') {
                start = true;
                operName = (Character) oper.get(i);
            }
        }
        num2 = Double.valueOf(res);
        switch(operName) {
            case '+':
                result = num1 + num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case 'x':
                result = num1 * num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            default:

                break;
        }
        num1 = 0;
        oper.clear();

        for(int i = 0; i < String.valueOf(result).length(); i++) {
            oper.add(String.valueOf(result).charAt(i));
        }
        result = 0;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_RESULT_TEXT, (String) textResult.getText());
//        outState.putString(KEY_INPUT_TEXT, (String) textInput.getText());
        outState.putSerializable(KEY_INPUT_LIST, oper);
    }
}
