package com.example.shubham.basiccalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    double numberOne;
    double numberTwo;
    int operation;
    boolean firstTime;

    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button zeroButton;

    Button multiplyButton;
    Button divideButton;
    Button addButton;
    Button subtractButton;
    Button equalsButton;
    Button cButton;
    Button periodButton;

    EditText displayEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = 0;
        numberTwo = 0;
        operation = -1;
        firstTime = true;

        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        sevenButton = (Button) findViewById(R.id.sevenButton);
        eightButton = (Button) findViewById(R.id.eightButton);
        nineButton = (Button) findViewById(R.id.nineButton);
        zeroButton = (Button) findViewById(R.id.zeroButton);

        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        equalsButton = (Button) findViewById(R.id.equalsButton);
        cButton = (Button) findViewById(R.id.cButton);
        periodButton = (Button) findViewById(R.id.periodButton);

        displayEditText = (EditText) findViewById(R.id.displayEditText);

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(1);
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(2);
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(3);
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(4);
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(5);
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(6);
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(7);
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(8);
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(9);
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNumber(0);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOperation(0);
            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOperation(1);
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOperation(3);
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOperation(2);
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
            }
        });
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != -1) {
                    resolve();
                    updateEditText(0);
                    operation = -1;
                }
            }
        });

      /*  periodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimalPortion = 0.0;
            }
        });*/
        updateEditText(0);
    }

    private void resolve() {
        if (operation == 0)
            numberOne += numberTwo;
        else if (operation == 1)
            numberOne -= numberTwo;
        else if (operation == 2)
            numberOne *= numberTwo;
        else if (operation == 3)
            numberOne /= numberTwo;
        numberTwo = 0;
    }

    private void updateOperation(int choice) {
        if (firstTime) {
            numberOne = numberTwo;
            numberTwo = 0;
            firstTime = false;
        } else
            resolve();
        operation = choice;
        updateEditText(0);
    }

    private void updateNumber(int number) {
        if (operation == -1 & !firstTime)
            removeAll();
        numberTwo = numberTwo * 10 + number;
        updateEditText(1);
    }

    private void updateEditText(int x) {
        DecimalFormat df = new DecimalFormat("###.#");
        if (x == 1)
            displayEditText.setText(df.format(numberTwo) + "");
        else
            displayEditText.setText(df.format(numberOne) + "");
    }

    private void removeAll() {
        numberOne = 0;
        numberTwo = 0;
        operation = -1;
        firstTime = true;
        updateEditText(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
