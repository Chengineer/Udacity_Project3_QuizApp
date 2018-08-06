package com.example.android.p3quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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
    boolean isNeededScondFeedbackB = false;// tells if the second feedback LinearLayout of question 2 is needed
    Resources res;// helps to set the feedback text color
    int correctColor;// helps to set the feedback text color
    int wrongColor;// helps to set the feedback text color
    CheckBox[] checkBoxArr;

    // question 1 correct Answer
    RadioButton firstQcorrectA;
    // question 1 all possible answers
    RadioGroup firstQradiogroup;
    // question 2 all possible answers
    CheckBox secondQfirstA;
    CheckBox secondQsecondA;
    CheckBox secondQthirdA;
    CheckBox secondQfourthA;
    CheckBox secondQfifthA;
    CheckBox secondQsixthA;
    CheckBox secondQseventhA;
    CheckBox secondQeighthA;
    // question 3 correct Answer
    RadioButton thirdQcorrectA;
    // question 3 all possible answers
    RadioGroup thirdQradiogroup;
    // question 4 correct Answer
    RadioButton fourthQcorrectA;
    // question 4 all possible answers
    RadioGroup fourthQradiogroup;
    // question 5 correct Answer
    RadioButton fifthQcorrectA;
    // question 5 all possible answers
    RadioGroup fifthQradiogroup;
    // question 6 correct Answer
    RadioButton sixthQcorrectA;
    // question 6 all possible answers
    RadioGroup sixthQradiogroup;
    // question 7 user's typed answer
    EditText seventhQanswer;
    // The Get Feedback button
    Button feedBack;
    // feedback icon (v or x) of each question
    ImageView imageFirst;
    ImageView imageSecondA;
    ImageView imageSecondB;
    ImageView imageThird;
    ImageView imageFourth;
    ImageView imageFifth;
    ImageView imageSixth;
    ImageView imageSeventh;
    // feedback text (correct or wrong) of each question
    TextView textFirst;
    TextView textSecondA;
    TextView textSecondB;
    TextView textThird;
    TextView textFourth;
    TextView textFifth;
    TextView textSixth;
    TextView textSeventh;
    // feedback LinearLayout (that contains both feedback icon and feedback text) of each question
    LinearLayout firstFeedback;
    LinearLayout secondFeedbackA;
    LinearLayout secondFeedbackB;
    LinearLayout thirdFeedback;
    LinearLayout fourthFeedback;
    LinearLayout fifthFeedback;
    LinearLayout sixthFeedback;
    LinearLayout seventhFeedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Q1
        firstQcorrectA = findViewById(R.id.first_question_second_answer);
        firstQradiogroup = findViewById(R.id.first_question_radio_group);
        // Q2
        secondQfirstA = findViewById(R.id.second_question_first_answer);
        secondQsecondA = findViewById(R.id.second_question_second_answer);
        secondQthirdA = findViewById(R.id.second_question_third_answer);
        secondQfourthA = findViewById(R.id.second_question_fourth_answer);
        secondQfifthA = findViewById(R.id.second_question_fifth_answer);
        secondQsixthA = findViewById(R.id.second_question_sixth_answer);
        secondQseventhA = findViewById(R.id.second_question_seventh_answer);
        secondQeighthA = findViewById(R.id.second_question_eighth_answer);
        // Q3
        thirdQcorrectA = findViewById(R.id.third_question_first_answer);
        thirdQradiogroup = findViewById(R.id.third_question_radio_group);
        // Q4
        fourthQcorrectA = findViewById(R.id.fourth_question_fourth_answer);
        fourthQradiogroup = findViewById(R.id.fourth_question_radio_group);
        // Q5
        fifthQcorrectA = findViewById(R.id.fifth_question_second_answer);
        fifthQradiogroup = findViewById(R.id.fifth_question_radio_group);
        // Q6
        sixthQcorrectA = findViewById(R.id.sixth_question_third_answer);
        sixthQradiogroup = findViewById(R.id.sixth_question_radio_group);
        // Q7
        seventhQanswer = findViewById(R.id.seventh_question_answer);
        // Get Feedback button
        feedBack = findViewById(R.id.feedback_button);
        // all Qs feedback icons
        imageFirst = findViewById(R.id.first_question_feedback_image);
        imageSecondA = findViewById(R.id.second_question_feedback_image_a);
        imageSecondB = findViewById(R.id.second_question_feedback_image_b);
        imageThird = findViewById(R.id.third_question_feedback_image);
        imageFourth = findViewById(R.id.fourth_question_feedback_image);
        imageFifth = findViewById(R.id.fifth_question_feedback_image);
        imageSixth = findViewById(R.id.sixth_question_feedback_image);
        imageSeventh = findViewById(R.id.seventh_question_feedback_image);
        // all Qs feedback text
        textFirst = findViewById(R.id.first_question_feedback_text);
        textSecondA = findViewById(R.id.second_question_feedback_text_a);
        textSecondB = findViewById(R.id.second_question_feedback_text_b);
        textThird = findViewById(R.id.third_question_feedback_text);
        textFourth = findViewById(R.id.fourth_question_feedback_text);
        textFifth = findViewById(R.id.fifth_question_feedback_text);
        textSixth = findViewById(R.id.sixth_question_feedback_text);
        textSeventh = findViewById(R.id.seventh_question_feedback_text);
        // feedback LinearLayout (both icon and text)
        firstFeedback = findViewById(R.id.first_feedback);
        secondFeedbackA = findViewById(R.id.second_feedback_a);
        secondFeedbackB = findViewById(R.id.second_feedback_b);
        thirdFeedback = findViewById(R.id.third_feedback);
        fourthFeedback = findViewById(R.id.fourth_feedback);
        fifthFeedback = findViewById(R.id.fifth_feedback);
        sixthFeedback = findViewById(R.id.sixth_feedback);
        seventhFeedback = findViewById(R.id.seventh_feedback);
        // get colors from colors.xml file
        res = getResources();
        correctColor = res.getColor(R.color.correctColor);
        wrongColor = res.getColor(R.color.wrongColor);
        // array of all CheckBox views to make manipulations and checks easier to perform
        checkBoxArr = new CheckBox[]{secondQfirstA, secondQsecondA, secondQthirdA, secondQfourthA, secondQfifthA, secondQsixthA, secondQseventhA, secondQeighthA};
        // set all CheckBox views font (because it doesn't work through xml attributes..)
        for (int i = 0; i < checkBoxArr.length; i++) {
            checkBoxArr[i].setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.amarante));
        }
        // set EditText hint size
        seventhQanswer.setHint(Html.fromHtml("<small>" + getString(R.string.seventh_question_hint) + "</small>"));
    }

    /**
     * This method is called when the Results button is clicked.
     */
    public void results(View view) {
        score = 0;
        // if not all questions are answered
        if (checkAllAnswered() == false)
            // exit this method early because there's nothing left to do here
            return;
            // if all questions are answered calculate and display the score
        else {
            // call methods that check if the answers for Q1-Q6 are correct, and handle the scoring and feedback
            checkRadioButtonCorrect(firstQradiogroup, firstQcorrectA, imageFirst, textFirst);
            checkCheckBoxes();
            checkRadioButtonCorrect(thirdQradiogroup, thirdQcorrectA, imageThird, textThird);
            checkRadioButtonCorrect(fourthQradiogroup, fourthQcorrectA, imageFourth, textFourth);
            checkRadioButtonCorrect(fifthQradiogroup, fifthQcorrectA, imageFifth, textFifth);
            checkRadioButtonCorrect(sixthQradiogroup, sixthQcorrectA, imageSixth, textSixth);
            // check if the Q7's answer (EditText input) is correct, and handle the scoring and feedback
            if (Integer.parseInt(seventhQanswer.getText().toString()) == 10) {
                score += 1;
                imageSeventh.setImageResource(R.drawable.ic_check_black_24dp);
                textSeventh.setText(getResources().getString(R.string.correct_answer));
                textSeventh.setTextColor(correctColor);
            } else {
                imageSeventh.setImageResource(R.drawable.ic_clear_black_24dp);
                textSeventh.setText(getResources().getString(R.string.wrong_answer));
                textSeventh.setTextColor(wrongColor);
            }
            // make the feedback button visible, so the user can get a feedback for his answers if he wants to
            feedBack.setVisibility(View.VISIBLE);
            // display the score
            String toastResults = (getResources().getString(R.string.final_score)) + (String.valueOf(score)) + "/" + (String.valueOf(TOTAL_NUMBER_OF_QUESTIONS));
            Toast.makeText(this, toastResults, Toast.LENGTH_LONG).show();
            //disable all questions (the user cannot change his answers after pressing the results button)
            controlRadioGroup(firstQradiogroup, false);
            secondQfirstA.setEnabled(false);
            secondQsecondA.setEnabled(false);
            secondQthirdA.setEnabled(false);
            secondQfourthA.setEnabled(false);
            secondQfifthA.setEnabled(false);
            secondQsixthA.setEnabled(false);
            secondQseventhA.setEnabled(false);
            secondQeighthA.setEnabled(false);
            controlRadioGroup(thirdQradiogroup, false);
            controlRadioGroup(fourthQradiogroup, false);
            controlRadioGroup(fifthQradiogroup, false);
            controlRadioGroup(sixthQradiogroup, false);
            seventhQanswer.setEnabled(false);
        }
    }

    /**
     * This method checks if all questions are answered, and displays a message if at least one of them is not answered
     *
     * @return true is all questions are answered, false if at least one question is not answered
     */
    public boolean checkAllAnswered() {
        if ((firstQradiogroup.getCheckedRadioButtonId() == -1) || ((secondQfirstA.isChecked() == false) && (secondQsecondA.isChecked() == false) && (secondQthirdA.isChecked() == false) && (secondQfourthA.isChecked() == false) && (secondQfifthA.isChecked() == false) && (secondQsixthA.isChecked() == false) && (secondQseventhA.isChecked() == false) && (secondQeighthA.isChecked() == false)) || (thirdQradiogroup.getCheckedRadioButtonId() == -1) || (fourthQradiogroup.getCheckedRadioButtonId() == -1) || (fifthQradiogroup.getCheckedRadioButtonId() == -1) || (sixthQradiogroup.getCheckedRadioButtonId() == -1) || (seventhQanswer.getText().toString().isEmpty() == true)) {
            String toastMissingAnswers = getResources().getString(R.string.toast_missing_answers);
            // display a message to the user to answer all questions
            Toast.makeText(this, toastMissingAnswers, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * This method checks if the user's answer (checked RadioButton) of a single-choice question is correct,
     * and handles the scoring and the feedback text and image
     *
     * @param question:      the group of possible answers for a specific question
     * @param correctAnswer: the correct answer
     * @param image:         the feedback image
     * @param text:          the feedback text
     */
    public void checkRadioButtonCorrect(RadioGroup question, RadioButton correctAnswer, ImageView image, TextView text) {
        if (question.getCheckedRadioButtonId() == correctAnswer.getId()) {
            score += 1;
            image.setImageResource(R.drawable.ic_check_black_24dp);
            text.setText(getResources().getString(R.string.correct_answer));
            text.setTextColor(correctColor);
        } else {
            image.setImageResource(R.drawable.ic_clear_black_24dp);
            text.setText(getResources().getString(R.string.wrong_answer));
            text.setTextColor(wrongColor);
        }
    }

    /**
     * This method is called when the Reset Quiz button is clicked.
     */
    public void reset(View view) {
        score = 0;
        isNeededScondFeedbackB = false;
        //enable all questions
        controlRadioGroup(firstQradiogroup, true);
        secondQfirstA.setEnabled(true);
        secondQsecondA.setEnabled(true);
        secondQthirdA.setEnabled(true);
        secondQfourthA.setEnabled(true);
        secondQfifthA.setEnabled(true);
        secondQsixthA.setEnabled(true);
        secondQseventhA.setEnabled(true);
        secondQeighthA.setEnabled(true);
        controlRadioGroup(thirdQradiogroup, true);
        controlRadioGroup(fourthQradiogroup, true);
        controlRadioGroup(fifthQradiogroup, true);
        controlRadioGroup(sixthQradiogroup, true);
        seventhQanswer.setEnabled(true);
        // clear checks/text from all questions
        firstQradiogroup.clearCheck();
        secondQfirstA.setChecked(false);
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
        seventhQanswer.getText().clear();
        // make feedback Button invisible
        feedBack.setVisibility(View.GONE);
        // make all feedback LinearLayouts invisible
        firstFeedback.setVisibility(View.GONE);
        secondFeedbackA.setVisibility(View.GONE);
        secondFeedbackB.setVisibility(View.GONE);
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
        // make all feedback LinearLayouts visible
        firstFeedback.setVisibility(View.VISIBLE);
        secondFeedbackA.setVisibility(View.VISIBLE);
        /** if the answer to Q2 is only partially correct, we need the second feedback LinearLayout
         * to be visible in order to display both numbers of correct and wrong answers**/
        if (isNeededScondFeedbackB == true)
            secondFeedbackB.setVisibility(View.VISIBLE);
        thirdFeedback.setVisibility(View.VISIBLE);
        fourthFeedback.setVisibility(View.VISIBLE);
        fifthFeedback.setVisibility(View.VISIBLE);
        sixthFeedback.setVisibility(View.VISIBLE);
        seventhFeedback.setVisibility(View.VISIBLE);
    }

    /**
     * This method enables/disables RadioButtons of a RadioGroup
     *
     * @param radioGroup: pass a RadioGroup object
     * @param state       : pass "true" in order to enable that RadioGroup, pass "false" in order to disable that RadioGroup
     */
    public void controlRadioGroup(RadioGroup radioGroup, boolean state) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(state);
        }
    }

    /**
     * This method checks the user's answer to the second question of the quiz (multiple choice checkbox question),
     * and handles the scoring and the feedback text and image
     */
    public void checkCheckBoxes() {
        int countCorrectChecks = 0;
        int countWrongChecks = 0;
        for (int i = 0; i < checkBoxArr.length; i++) {
            /** if the current CheckBox is checked, and it's one of the correct answers, increase correct counter by 1.
             * else, it's a wrong answer so increase wrong counter by 1**/
            if (checkBoxArr[i].isChecked() == true) {
                if ((checkBoxArr[i] == secondQsecondA) || (checkBoxArr[i] == secondQthirdA) || (checkBoxArr[i] == secondQsixthA) || (checkBoxArr[i] == secondQeighthA))
                    countCorrectChecks += 1;
                else countWrongChecks += 1;
            }
        }
        /** if all correct answers are checked, and all wrong answers are not checked, that's the correct answer to the second question**/
        if ((countCorrectChecks == 4) && (countWrongChecks == 0)) {
            score += 1;
            imageSecondA.setImageResource(R.drawable.ic_check_black_24dp);
            textSecondA.setText(getResources().getString(R.string.correct_answer));
            textSecondA.setTextColor(correctColor);
            /** if none of the correct answers is checked, the answer to the second question is completely wrong**/
        } else if (countCorrectChecks == 0) {
            imageSecondA.setImageResource(R.drawable.ic_clear_black_24dp);
            textSecondA.setText(getResources().getString(R.string.wrong_answer));
            textSecondA.setTextColor(wrongColor);
            /** if: only part of the correct answers is checked/ only part of the correct answers are checked and also wrong
             *  answers are checked/all correct answers are checked but also wrong answers- then the answer to the second
             *  question is wrong, but the feedback will show how many of the checked answers are wrong or correct**/
        } else {
            isNeededScondFeedbackB = true;
            imageSecondA.setImageResource(R.drawable.ic_check_black_24dp);
            textSecondA.setText((getResources().getString(R.string.correct_answers)) + countCorrectChecks);
            textSecondA.setTextColor(correctColor);
            imageSecondB.setImageResource(R.drawable.ic_clear_black_24dp);
            textSecondB.setText((getResources().getString(R.string.wrong_answers)) + countWrongChecks);
            textSecondB.setTextColor(wrongColor);
        }
    }

}
