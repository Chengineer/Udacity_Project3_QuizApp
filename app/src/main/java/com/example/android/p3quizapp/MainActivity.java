package com.example.android.p3quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int TOTAL_NUMBER_OF_QUESTIONS = 7;
    int score = 0;

    RadioButton firstQcorrectA;
    RadioGroup firstQradiogroup;

    CheckBox secondQfirstA;
    CheckBox secondQsecondA;
    CheckBox secondQthirdA;
    CheckBox secondQfourthA;
    CheckBox secondQfifthA;
    CheckBox secondQsixthA;
    CheckBox secondQseventhA;
    CheckBox secondQeighthA;

    RadioButton thirdQcorrectA;
    RadioGroup thirdQradiogroup;

    RadioButton fourthQcorrectA;
    RadioGroup fourthQradiogroup;

    RadioButton fifthQcorrectA;
    RadioGroup fifthQradiogroup;

    RadioButton sixthQcorrectA;
    RadioGroup sixthQradiogroup;

    EditText seventhQanswer;

    Button feedBack;

    ImageView imageFirst;
    ImageView imageSecond;
    ImageView imageThird;
    ImageView imageFourth;
    ImageView imageFifth;
    ImageView imageSixth;
    ImageView imageSeventh;

    TextView textFirst;
    TextView textSecond;
    TextView textThird;
    TextView textFourth;
    TextView textFifth;
    TextView textSixth;
    TextView textSeventh;

    LinearLayout firstFeedback;
    LinearLayout secondFeedback;
    LinearLayout thirdFeedback;
    LinearLayout fourthFeedback;
    LinearLayout fifthFeedback;
    LinearLayout sixthFeedback;
    LinearLayout seventhFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstQcorrectA = findViewById(R.id.first_question_second_answer);
        firstQradiogroup = findViewById(R.id.first_question_radio_group);

        secondQfirstA = findViewById(R.id.second_question_first_answer);
        secondQsecondA = findViewById(R.id.second_question_second_answer);
        secondQthirdA = findViewById(R.id.second_question_third_answer);
        secondQfourthA = findViewById(R.id.second_question_fourth_answer);
        secondQfifthA = findViewById(R.id.second_question_fifth_answer);
        secondQsixthA = findViewById(R.id.second_question_sixth_answer);
        secondQseventhA = findViewById(R.id.second_question_seventh_answer);
        secondQeighthA = findViewById(R.id.second_question_eighth_answer);

        thirdQcorrectA = findViewById(R.id.third_question_first_answer);
        thirdQradiogroup = findViewById(R.id.third_question_radio_group);

        fourthQcorrectA = findViewById(R.id.fourth_question_fourth_answer);
        fourthQradiogroup = findViewById(R.id.fourth_question_radio_group);

        fifthQcorrectA = findViewById(R.id.fifth_question_second_answer);
        fifthQradiogroup = findViewById(R.id.fifth_question_radio_group);

        sixthQcorrectA = findViewById(R.id.sixth_question_third_answer);
        sixthQradiogroup = findViewById(R.id.sixth_question_radio_group);

        seventhQanswer = findViewById(R.id.seventh_question_answer);

        feedBack = findViewById(R.id.feedback_button);

        imageFirst = findViewById(R.id.first_question_feedback_image);
        imageSecond = findViewById(R.id.second_question_feedback_image);
        imageThird = findViewById(R.id.third_question_feedback_image);
        imageFourth = findViewById(R.id.fourth_question_feedback_image);
        imageFifth = findViewById(R.id.fifth_question_feedback_image);
        imageSixth = findViewById(R.id.sixth_question_feedback_image);
        imageSeventh = findViewById(R.id.seventh_question_feedback_image);

        textFirst = findViewById(R.id.first_question_feedback_text);
        textSecond = findViewById(R.id.second_question_feedback_text);
        textThird = findViewById(R.id.third_question_feedback_text);
        textFourth = findViewById(R.id.fourth_question_feedback_text);
        textFifth = findViewById(R.id.fifth_question_feedback_text);
        textSixth = findViewById(R.id.sixth_question_feedback_text);
        textSeventh = findViewById(R.id.seventh_question_feedback_text);

        firstFeedback = findViewById(R.id.first_feedback);
        secondFeedback = findViewById(R.id.second_feedback);
        thirdFeedback = findViewById(R.id.third_feedback);
        fourthFeedback = findViewById(R.id.fourth_feedback);
        fifthFeedback = findViewById(R.id.fifth_feedback);
        sixthFeedback = findViewById(R.id.sixth_feedback);
        seventhFeedback = findViewById(R.id.seventh_feedback);

    }

    /**
     * This method is called when the Results button is clicked.
     */
    public void results(View view) {

        boolean isCheckedSecondQfirstA = secondQfirstA.isChecked();
        boolean isCheckedSecondQsecondA = secondQsecondA.isChecked();
        boolean isCheckedSecondQthirdA = secondQthirdA.isChecked();
        boolean isCheckedSecondQfourthA = secondQfourthA.isChecked();
        boolean isCheckedSecondQfifthA = secondQfifthA.isChecked();
        boolean isCheckedSecondQsixthA = secondQsixthA.isChecked();
        boolean isCheckedSecondQseventhA = secondQseventhA.isChecked();
        boolean isCheckedSecondQeighthA = secondQeighthA.isChecked();

        if (checkAllAnswered(firstQradiogroup, isCheckedSecondQfirstA, isCheckedSecondQsecondA, isCheckedSecondQthirdA, isCheckedSecondQfourthA, isCheckedSecondQfifthA, isCheckedSecondQsixthA, isCheckedSecondQseventhA, isCheckedSecondQeighthA, thirdQradiogroup, fourthQradiogroup, fifthQradiogroup, sixthQradiogroup, seventhQanswer) == false)
            // exit this method early because there's nothing left to do
            return;
        else {
            if (checkRadioButtonCorrect(firstQradiogroup, firstQcorrectA) == true) {
                imageFirst.setImageResource(R.drawable.ic_check_black_24dp);
                textFirst.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageFirst.setImageResource(R.drawable.ic_clear_black_24dp);
                textFirst.setText(getResources().getString(R.string.wrong_answer));
            }
            if (isCheckedSecondQfirstA == false && isCheckedSecondQsecondA == true && isCheckedSecondQthirdA == true && isCheckedSecondQfourthA == false && isCheckedSecondQfifthA == false && isCheckedSecondQsixthA == true && isCheckedSecondQseventhA == false && isCheckedSecondQeighthA == true) {
                score += 1;
                imageSecond.setImageResource(R.drawable.ic_check_black_24dp);
                textSecond.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageSecond.setImageResource(R.drawable.ic_clear_black_24dp);
                textSecond.setText(getResources().getString(R.string.wrong_answer));
            }
            if (checkRadioButtonCorrect(thirdQradiogroup, thirdQcorrectA) == true) {
                imageThird.setImageResource(R.drawable.ic_check_black_24dp);
                textThird.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageThird.setImageResource(R.drawable.ic_clear_black_24dp);
                textThird.setText(getResources().getString(R.string.wrong_answer));
            }
            if (checkRadioButtonCorrect(fourthQradiogroup, fourthQcorrectA) == true) {
                imageFourth.setImageResource(R.drawable.ic_check_black_24dp);
                textFourth.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageFourth.setImageResource(R.drawable.ic_clear_black_24dp);
                textFourth.setText(getResources().getString(R.string.wrong_answer));
            }
            if (checkRadioButtonCorrect(fifthQradiogroup, fifthQcorrectA) == true) {
                imageFifth.setImageResource(R.drawable.ic_check_black_24dp);
                textFifth.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageFifth.setImageResource(R.drawable.ic_clear_black_24dp);
                textFifth.setText(getResources().getString(R.string.wrong_answer));
            }
            if (checkRadioButtonCorrect(sixthQradiogroup, sixthQcorrectA) == true) {
                imageSixth.setImageResource(R.drawable.ic_check_black_24dp);
                textSixth.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageSixth.setImageResource(R.drawable.ic_clear_black_24dp);
                textSixth.setText(getResources().getString(R.string.wrong_answer));
            }
            if ((seventhQanswer.getText().toString()) == "10") {
                score += 1;
                imageSeventh.setImageResource(R.drawable.ic_check_black_24dp);
                textSeventh.setText(getResources().getString(R.string.correct_answer));
            } else {
                imageSeventh.setImageResource(R.drawable.ic_clear_black_24dp);
                textSeventh.setText(getResources().getString(R.string.wrong_answer));
            }
            feedBack.setVisibility(View.VISIBLE);
            String toastResults = (getResources().getString(R.string.correct_answers)) + (String.valueOf(score)) + "/" + (String.valueOf(TOTAL_NUMBER_OF_QUESTIONS));
            Toast.makeText(this, toastResults, Toast.LENGTH_LONG).show();

        }


    }

    public boolean checkAllAnswered(RadioGroup firstQ, boolean secondQfirstA, boolean secondQsecondA, boolean secondQthirdA, boolean secondQfourthA, boolean secondQfifthA, boolean secondQsixthA, boolean secondQseventhA, boolean secondQeighthA, RadioGroup thridQ, RadioGroup fourthQ, RadioGroup fifthQ, RadioGroup sixthQ, EditText seventhQ) {
        if (firstQ.getCheckedRadioButtonId() == -1 || (secondQfirstA == false && secondQsecondA == false && secondQthirdA == false && secondQfourthA == false && secondQfifthA == false && secondQsixthA == false && secondQseventhA == false && secondQeighthA == false) || thridQ.getCheckedRadioButtonId() == -1 || fourthQ.getCheckedRadioButtonId() == -1 || fifthQ.getCheckedRadioButtonId() == -1 || sixthQ.getCheckedRadioButtonId() == -1 || seventhQ.getText().toString().isEmpty() == true) {
            String toastMissingAnswers = getResources().getString(R.string.toast_missing_answers);
            Toast.makeText(this, toastMissingAnswers, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean checkRadioButtonCorrect(RadioGroup question, RadioButton correctAnswer) {
        if (question.getCheckedRadioButtonId() == correctAnswer.getId()) {
            score += 1;
            return true;
        } else return false;
    }

    /**
     * This method is called when the Reset Quiz button is clicked.
     */
    public void reset(View view) {
        score = 0;

        firstQradiogroup.clearCheck();

        secondQsecondA.setChecked(false);
        secondQthirdA.setChecked(false);
        secondQfourthA.setChecked(false);
        secondQfifthA.setChecked(false);
        secondQsixthA.setChecked(false);
        secondQseventhA.setChecked(false);
        secondQeighthA.setChecked(false);

        thirdQradiogroup.clearCheck();

        fourthQradiogroup.clearCheck();

        fifthQradiogroup.clearCheck();

        sixthQradiogroup.clearCheck();

        seventhQanswer.setText("");

        feedBack.setVisibility(View.GONE);

        firstFeedback.setVisibility(View.GONE);
        secondFeedback.setVisibility(View.GONE);
        thirdFeedback.setVisibility(View.GONE);
        fourthFeedback.setVisibility(View.GONE);
        fifthFeedback.setVisibility(View.GONE);
        sixthFeedback.setVisibility(View.GONE);
        seventhFeedback.setVisibility(View.GONE);
    }

    /**
     * This method is called when the Show Feedback button is clicked.
     */
    public void feedback(View view) {

        firstFeedback.setVisibility(View.VISIBLE);
        secondFeedback.setVisibility(View.VISIBLE);
        thirdFeedback.setVisibility(View.VISIBLE);
        fourthFeedback.setVisibility(View.VISIBLE);
        fifthFeedback.setVisibility(View.VISIBLE);
        sixthFeedback.setVisibility(View.VISIBLE);
        seventhFeedback.setVisibility(View.VISIBLE);

    }

}
