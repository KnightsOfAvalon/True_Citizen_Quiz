package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton previousButton;
    private TextView questionTextView;
    private TextView questionNumber;
    
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.previous_button);
        questionNumber = findViewById(R.id.question_number);
        questionTextView = findViewById(R.id.answer_text_view);

        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
        questionNumber.setText(String.valueOf(currentQuestionIndex + 1));


        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next_button:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.previous_button:
                currentQuestionIndex = (currentQuestionIndex + (questionBank.length - 1)) % questionBank.length;
                updateQuestion();
                break;
                
        }

    }

    private void updateQuestion() {
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
        questionNumber.setText(String.valueOf(currentQuestionIndex + 1));
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questionBank[currentQuestionIndex].isCorrectAnswer();
        int toastMessageId;

        if (userAnswer == correctAnswer) {
            toastMessageId = R.string.correct_answer;

        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}