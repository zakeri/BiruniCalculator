package ir.ideacenter.birunicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    TextView kb_result;
    Button kb_digit[] = new Button[10];
    Button kb_multiply, kb_divide, kb_minus, kb_add, kb_equal, kb_clear;
    Double result, num_last;
    Boolean num_empty, last_key_operation;
    Integer last_operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init vars:
        result = 0.0;
        num_last = 0.0;
        num_empty = true;
        last_key_operation = false;
        last_operation = -1;

        kb_result = (TextView) findViewById(R.id.kb_result);
        kb_result.setText(result.toString());

        kb_digit[0] = (Button) findViewById(R.id.kb_0);
        kb_digit[1] = (Button) findViewById(R.id.kb_1);
        kb_digit[2] = (Button) findViewById(R.id.kb_2);
        kb_digit[3] = (Button) findViewById(R.id.kb_3);
        kb_digit[4] = (Button) findViewById(R.id.kb_4);
        kb_digit[5] = (Button) findViewById(R.id.kb_5);
        kb_digit[6] = (Button) findViewById(R.id.kb_6);
        kb_digit[7] = (Button) findViewById(R.id.kb_7);
        kb_digit[8] = (Button) findViewById(R.id.kb_8);
        kb_digit[9] = (Button) findViewById(R.id.kb_9);

        kb_multiply = (Button) findViewById(R.id.kb_multiply);
        kb_divide = (Button) findViewById(R.id.kb_divide);
        kb_add = (Button) findViewById(R.id.kb_add);
        kb_minus = (Button) findViewById(R.id.kb_minus);
        kb_equal = (Button) findViewById(R.id.kb_equal);
        kb_clear = (Button) findViewById(R.id.kb_clear);

        kb_digit[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(0);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(1);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(2);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(3);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(4);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(5);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(6);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(7);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(8);
                kb_result.setText(result.toString());
            }
        });

        kb_digit[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDigit(9);
                kb_result.setText(result.toString());
            }
        });

        kb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(0);
                kb_result.setText(result.toString());
            }
        });

        kb_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(1);
                kb_result.setText(result.toString());
            }
        });

        kb_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(2);
                kb_result.setText(result.toString());
            }
        });

        kb_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(3);
                kb_result.setText(result.toString());
            }
        });

        kb_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processEqual();
                kb_result.setText(result.toString());
            }
        });

        kb_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processClear();
                kb_result.setText(result.toString());
            }
        });
    }

    private void processDigit(int d) {
        if (last_key_operation) {
            num_last = result;
            num_empty = false;
            last_key_operation = false;
            result = 0.0;
        }

        result = result * 10 + d;
    }

    private void processOperation(int operation) {
        if (last_operation >= 0 && !num_empty) {
            if (last_operation == 0)
                result = num_last + result;
            else if (last_operation == 1)
                result = num_last - result;
            else if (last_operation == 2)
                result = num_last * result;
            else if (last_operation == 3)
                result = num_last / result;

            num_last = 0.0;
            num_empty = true;
        }

        last_key_operation = true;
        last_operation = operation;
    }

    private void processEqual() {
        if (last_operation >= 0 && !num_empty) {
            Double backup = result;

            if (last_operation == 0)
                result = num_last + result;
            else if (last_operation == 1)
                result = num_last - result;
            else if (last_operation == 2)
                result = num_last * result;
            else if (last_operation == 3)
                result = num_last / result;

            num_last = backup;
            num_empty = true;
        }
        else if (last_operation >= 0 && num_empty) {
            if (last_operation == 0)
                result = result + num_last;
            else if (last_operation == 1)
                result = result - num_last;
            else if (last_operation == 2)
                result = result * num_last;
            else if (last_operation == 3)
                result = result / num_last;
        }
        else {
            last_key_operation = false;
            last_operation = -1;
        }
    }

    private void processClear() {
        result = 0.0;
        num_last = 0.0;
        num_empty = true;
        last_key_operation = false;
        last_operation = -1;
    }
}
