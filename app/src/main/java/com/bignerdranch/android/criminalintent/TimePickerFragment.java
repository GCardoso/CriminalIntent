package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by guilhermecardoso on 9/30/15.
 */
public class TimePickerFragment extends DialogFragment{
    private static final String ARG_TIME = "time";
    public static final String EXTRA_TIME = "com.bignerdranch.android.criminalintent.date";

    TimePicker mTimePicker;

    public static TimePickerFragment newInstance(Calendar calendar) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TIME, calendar);

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void sendResult(int resultCode, Calendar calendar){
        if (getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME,calendar);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedinstanceState){
        Calendar calendar = (Calendar) getArguments().getSerializable(ARG_TIME);
        int hour = calendar.get(Calendar.DAY_OF_MONTH);
        int minute = calendar.get(Calendar.MINUTE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time,null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
        mTimePicker.setCurrentHour(hour);

        return new AlertDialog.Builder(getActivity()).setView(v).setTitle(R.string.date_picker_title).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int hour = mTimePicker.getCurrentHour();
                int minute = mTimePicker.getCurrentMinute();

                Calendar time = Calendar.getInstance();
                time.set(Calendar.HOUR_OF_DAY,hour);
                time.set(Calendar.MINUTE,minute);
                sendResult(Activity.RESULT_OK, time);
            }
        }).create();
    }
}
