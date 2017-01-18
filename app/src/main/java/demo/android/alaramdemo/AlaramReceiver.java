package demo.android.alaramdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlaramReceiver extends WakefulBroadcastReceiver {

    public AlaramReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        MainActivity inst = MainActivity.instance();
        inst.setAlarmText("Alaram Ringing ! Wake Up !");
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");


        try {
            ComponentName comp = new ComponentName(context.getPackageName(),
                    AlaramService.class.getName());
            startWakefulService(context, (intent.setComponent(comp)));
            setResultCode(MainActivity.RESULT_OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
