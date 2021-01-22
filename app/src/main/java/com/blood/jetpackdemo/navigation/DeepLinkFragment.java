package com.blood.jetpackdemo.navigation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.LayoutFragmentDeepLinkBinding;

public class DeepLinkFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "DeepLinkFragment";

    private LayoutFragmentDeepLinkBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_deep_link, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBinding.deepLink.setOnClickListener(this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Log.i(TAG, ">>>>>>>>>>>>>>>>>>>> DeepLink: " + bundle.toString());
        }
    }

    @Override
    public void onClick(View v) {
        Bundle args = new Bundle();
        args.putString("arg", "arg_test");

        PendingIntent deeplink = NavHostFragment.findNavController(this)
                .createDeepLink()
                .setDestination(R.id.deepLinkFragment)
                .setArguments(args)
                .createPendingIntent();

        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("deeplink", "Deep Links", NotificationManager.IMPORTANCE_HIGH));
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "deeplink")
                .setContentTitle("Navigation")
                .setContentText("Deep link to Android")
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(deeplink)
                .setAutoCancel(true);
        notificationManager.notify(0, builder.build());
    }
}
